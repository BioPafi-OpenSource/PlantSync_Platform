package com.plantsync.platform.iam.interfaces.rest;

import com.plantsync.platform.iam.domain.services.UserCommandService;
import com.plantsync.platform.iam.interfaces.rest.assemblers.SignInCommandFromResourceAssembler;
import com.plantsync.platform.iam.interfaces.rest.assemblers.SignUpCommandFromResourceAssembler;
import com.plantsync.platform.iam.interfaces.rest.assemblers.UserResourceFromEntityAssembler;
import com.plantsync.platform.iam.interfaces.rest.resources.SignInResource;
import com.plantsync.platform.iam.interfaces.rest.resources.SignUpResource;
import com.plantsync.platform.iam.interfaces.rest.resources.UserResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Users", description = "Available User Command Endpoints")
public class UsersCommandController {
    private final UserCommandService userCommandService;

    public UsersCommandController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }





    @PostMapping("/sign-in")
    @Operation(summary = "Sign-in", description = "Simulated sign-in, returns user if credentials match.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found."),
            @ApiResponse(responseCode = "404", description = "User not found or wrong password.")
    })
    public ResponseEntity<UserResource> signIn(@RequestBody SignInResource signInResource) {
        var signInCommand = SignInCommandFromResourceAssembler.toCommandFromResource(signInResource);
        var user = userCommandService.handle(signInCommand);

        if (user.isEmpty()) return ResponseEntity.notFound().build();

        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }



    @PostMapping("/sign-up")
    @Operation(summary = "Sign-up", description = "Sign-up with the provided credentials.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created successfully."),
            @ApiResponse(responseCode = "400", description = "Bad request.")})
    public ResponseEntity<UserResource> signUp(@org.springframework.web.bind.annotation.RequestBody SignUpResource signUpResource) {
        var signUpCommand = SignUpCommandFromResourceAssembler.toCommandFromResource(signUpResource);
        var user = userCommandService.handle(signUpCommand);
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);

    }

}
