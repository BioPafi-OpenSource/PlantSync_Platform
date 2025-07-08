package com.plantsync.platform.plantguides.interfaces.rest;

import com.plantsync.platform.plantguides.domain.model.queries.GetAllGuidesQuery;
import com.plantsync.platform.plantguides.domain.model.queries.GetGuideByIdQuery;
import com.plantsync.platform.plantguides.interfaces.rest.assemblers.GuideResourceFromEntityAssembler;
import com.plantsync.platform.plantguides.interfaces.rest.resources.GuideResource;
import com.plantsync.platform.plantguides.domain.services.GuideQueryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * REST controller for handling HTTP requests related to Guide queries.
 * Provides endpoints to retrieve all guides or a specific guide by its ID.
 */
@RestController
@RequestMapping(value = "/api/v1/guides", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Guides", description = "Guide Endpoints")
public class GuideQueryController {

    private final GuideQueryService guideQueryService;

    public GuideQueryController(GuideQueryService guideQueryService) {
        this.guideQueryService = guideQueryService;
    }


    @GetMapping
    @Operation(summary = "Get all guides", description = "Get all guides")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Guides found"),
            @ApiResponse(responseCode = "404", description = "Guides not found or non existent")})
    public ResponseEntity<List<GuideResource>> getAllGuides() {
        var guides = guideQueryService.handle(new GetAllGuidesQuery());
        if (guides.isEmpty()) return ResponseEntity.notFound().build();
        var guideResources = guides.stream()
                .map(GuideResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(guideResources);
    }




    /**
     * Retrieves a guide by its ID.
     *
     * @param guideId the ID of the guide to retrieve
     * @return a {@link ResponseEntity} containing the {@link GuideResource} if found, or 404 if not
     */
    @GetMapping("/{guideId}")
    @Operation(summary = "Get guide by id", description = "Get guide by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Guide found"),
            @ApiResponse(responseCode = "404", description = "Guide not found")})
    public ResponseEntity<GuideResource> getGuideById(@PathVariable Long guideId) {
        var getGuideByIdQuery = new GetGuideByIdQuery(guideId);
        var guide = guideQueryService.handle(getGuideByIdQuery);
        if (guide.isEmpty()) return ResponseEntity.notFound().build();
        var guideEntity = guide.get();
        var guideResource = GuideResourceFromEntityAssembler.toResourceFromEntity(guideEntity);
        return ResponseEntity.ok(guideResource);
    }



}
