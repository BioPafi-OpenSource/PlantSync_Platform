package com.plantsync.platform.plantprofiles.interfaces.rest;


import com.plantsync.platform.plantprofiles.domain.model.queries.GetAllPlantsByProfileIdQuery;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetAllPlantsQuery;
import com.plantsync.platform.plantprofiles.domain.model.queries.GetPlantByIdQuery;
import com.plantsync.platform.plantprofiles.domain.model.valueobjects.ProfileId;
import com.plantsync.platform.plantprofiles.interfaces.rest.resources.PlantResource;
import com.plantsync.platform.plantprofiles.domain.services.PlantQueryService;
import com.plantsync.platform.plantprofiles.interfaces.rest.assemblers.PlantResourceFromEntityAssembler;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@RestController
@RequestMapping(value = "/api/v1/plants", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Plants", description = "Plant Management Endpoints")
public class PlantQueryController {

    private final PlantQueryService plantQueryService;

    public PlantQueryController(PlantQueryService plantQueryService) {
        this.plantQueryService = plantQueryService;
    }

    @GetMapping
    @Operation(summary = "Get all plants")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Plants found"),
            @ApiResponse(responseCode = "404", description = "No plants found")
    })
    public ResponseEntity<List<PlantResource>> getAllPlants() {
        var plants = plantQueryService.handle(new GetAllPlantsQuery());

        if (plants.isEmpty()) return ResponseEntity.notFound().build();

        var resources = plants.stream()
                .map(PlantResourceFromEntityAssembler::toResourceFromEntity)
                .toList();

        return ResponseEntity.ok(resources);
    }

    @GetMapping("/by-profile/{profileId}")
    @Operation(summary = "Get plants by profile ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Plants found for the user"),
            @ApiResponse(responseCode = "404", description = "No plants found for the user")
    })
    public ResponseEntity<List<PlantResource>> getAllPlantsByProfileId(@PathVariable Long profileId) {
        var plants = plantQueryService.handle(new GetAllPlantsByProfileIdQuery(new ProfileId(profileId)));

        if (plants.isEmpty()) return ResponseEntity.notFound().build();

        var resources = plants.stream()
                .map(PlantResourceFromEntityAssembler::toResourceFromEntity)
                .toList();

        return ResponseEntity.ok(resources);
    }

    @GetMapping("/{plantId}")
    @Operation(summary = "Get plant by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Plant found for the user"),
            @ApiResponse(responseCode = "404", description = "No plant found for the user")
    })
    public ResponseEntity<PlantResource> getPlantById( @PathVariable Long plantId) {

        var getPlantByIdQuery = new GetPlantByIdQuery(plantId);
        var plant = plantQueryService.handle(getPlantByIdQuery);
        if (plant.isEmpty()) return ResponseEntity.notFound().build();
        var plantEntity = plant.get();
        var plantResource = PlantResourceFromEntityAssembler.toResourceFromEntity(plantEntity);
        return ResponseEntity.ok(plantResource);



    }







}
