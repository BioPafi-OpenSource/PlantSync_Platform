package com.plantsync.platform.tasks.domain.model.services;



import com.plantsync.platform.tasks.domain.model.aggregates.Task;
import com.plantsync.platform.tasks.domain.model.queries.GetAllTasksQuery;

import java.util.List;

public interface TaskQueryService {

    List<Task> handle(GetAllTasksQuery query);


}
