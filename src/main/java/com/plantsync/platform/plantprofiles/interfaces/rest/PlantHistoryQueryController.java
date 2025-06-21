package com.plantsync.platform.plantprofiles.interfaces.rest;

import com.plantsync.platform.plantprofiles.domain.model.queries.GetPlantHistoryByPlantIdQuery;
import com.plantsync.platform.plantprofiles.domain.services.PlantHistoryQueryService;
import com.plantsync.platform.plantprofiles.interfaces.rest.assemblers.PlantHistoryResourceFromEntityAssembler;
import com.plantsync.platform.plantprofiles.interfaces.rest.resources.PlantHistoryResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/plantHistory", produces = APPLICATION_JSON_VALUE)
@Tag(name = "PlantHistories", description = "Plant History Management Endpoints")
public class PlantHistoryQueryController {

    private final PlantHistoryQueryService plantHistoryQueryService;

    public PlantHistoryQueryController(PlantHistoryQueryService plantHistoryQueryService) {
        this.plantHistoryQueryService = plantHistoryQueryService;
    }


    @GetMapping("/plantId")
    @Operation(summary = "Get plant history by Plant ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Plant history found for the user"),
            @ApiResponse(responseCode = "404", description = "No plant history found for the user")
    })
    public ResponseEntity<PlantHistoryResource> getPlantByUserId(@RequestParam Long plantId) {

        var getPlantHistoryByPlantIdQuery = new GetPlantHistoryByPlantIdQuery(plantId);
        var plantHistory = plantHistoryQueryService.handle(getPlantHistoryByPlantIdQuery);
        if (plantHistory.isEmpty()) return ResponseEntity.notFound().build();
        var plantHistoryEntity = plantHistory.get();
        var plantHistoryResource = PlantHistoryResourceFromEntityAssembler.toResourceFromEntity(plantHistoryEntity);
        return ResponseEntity.ok(plantHistoryResource);



    }







}
