package com.temelt.sgraph.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.temelt.sgraph.model.Task;
import com.temelt.sgraph.dao.TaskDao;

import java.util.List;

/**
 * Created by temelt on 13.07.2019.
 */
public class TaskResolver implements GraphQLResolver<Task> {
    private TaskDao taskDao;

    public TaskResolver(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public List<Task> getTasks() {
        return taskDao.getTasks(0, 10);
    }
}