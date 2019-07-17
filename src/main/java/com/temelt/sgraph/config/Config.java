package com.temelt.sgraph.config;

import com.temelt.sgraph.dao.TaskDao;
import com.temelt.sgraph.model.Task;
import com.temelt.sgraph.mutation.Mutation;
import com.temelt.sgraph.query.Query;
import com.temelt.sgraph.resolver.TaskResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by temelt on 13.07.2019.
 */
@Configuration
public class Config {

    @Bean
    public TaskDao taskDao() {
        List<Task> posts = new ArrayList<>();
        for (int taskId = 0; taskId < 10; ++taskId) {
            Task task = new Task();
            task.setId(taskId);
            task.setTitle("Task " + ":" + taskId);
            task.setContent("Task " + taskId + " content ");
            posts.add(task);
        }
        return new TaskDao(posts);
    }

    @Bean
    public TaskResolver taskResolver(TaskDao taskDao) {
        return new TaskResolver(taskDao);
    }

    @Bean
    public Query query(TaskDao taskDao) {
        return new Query(taskDao);
    }

    @Bean
    public Mutation mutation(TaskDao taskDao) {
        return new Mutation(taskDao);
    }
}
