package com.temelt.sgraph.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.temelt.sgraph.dao.TaskDao;
import com.temelt.sgraph.model.Task;

import java.util.Random;

/**
 * Created by temelt on 13.07.2019.
 */
public class Mutation implements GraphQLMutationResolver {
    private TaskDao taskDao;
    private Random random;

    public Mutation(TaskDao taskDao) {
        this.taskDao = taskDao;
        this.random = new Random();
    }

    public Task addTask(String title, String content) {
        Task task = new Task();
        task.setId(random.nextInt());
        task.setTitle(title);
        task.setContent(content);
        taskDao.savePost(task);
        return task;
    }

}