package com.plantsync.platform.plantprofiles.interfaces.rest;

import com.plantsync.platform.plantprofiles.domain.model.queries.GetPlantByIdQuery;

import com.plantsync.platform.plantprofiles.domain.model.services.PlantCommandService;
import com.plantsync.platform.plantprofiles.domain.model.services.PlantQueryService;
import com.plantsync.platform.plantprofiles.interfaces.rest.assemblers.CreatePlantCommandFromResourceAssembler;
import com.plantsync.platform.plantprofiles.interfaces.rest.assemblers.PlantResourceFromEntityAssembler;
import com.plantsync.platform.plantprofiles.interfaces.rest.resources.CreatePlantResource;
import com.plantsync.platform.plantprofiles.interfaces.rest.resources.PlantResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


    @RestController
    @RequestMapping(value = "/api/v1/plants", produces = APPLICATION_JSON_VALUE)
    @Tag(name = "Plants", description = "Available Plant Endpoints")
    public class PlantsCommandController {


        private final PlantCommandService plantCommandService;
        private final PlantQueryService plantQueryService;


        public PlantsCommandController(PlantCommandService plantCommandService, PlantQueryService plantQueryService) {
            this.plantCommandService = plantCommandService;
            this.plantQueryService = plantQueryService;

        }


        @PostMapping
        @Operation(summary = "Create a new plant", description = "Create a new plant")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201", description = "Plant created"),
                @ApiResponse(responseCode = "400", description = "Invalid input"),
                @ApiResponse(responseCode = "404", description = "Plant not found")})
        public ResponseEntity<PlantResource> createPlant(@Valid @RequestBody CreatePlantResource resource) {
            var createPlantCommand = CreatePlantCommandFromResourceAssembler.toCommandFromResource(resource);
            var plantId = plantCommandService.handle(createPlantCommand);
            if (plantId == null || plantId == 0L) return ResponseEntity.badRequest().build();
            var getPlantByIdQuery = new GetPlantByIdQuery(plantId);
            var plant = plantQueryService.handle(getPlantByIdQuery);
            if (plant.isEmpty()) return ResponseEntity.notFound().build();
            var plantEntity = plant.get();
            var plantResource = PlantResourceFromEntityAssembler.toResourceFromEntity(plantEntity);
            return new ResponseEntity<>(plantResource, HttpStatus.CREATED);
        }


    }