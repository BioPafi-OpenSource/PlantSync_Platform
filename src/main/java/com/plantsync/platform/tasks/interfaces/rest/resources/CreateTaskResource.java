package com.plantsync.platform.tasks.interfaces.rest.resources;


import java.time.LocalDate;

public record CreateTaskResource(




        String action,
        String date,
        Long plantId,
        Long profileId,
        Boolean completed

) {

    public CreateTaskResource{


        }

}
