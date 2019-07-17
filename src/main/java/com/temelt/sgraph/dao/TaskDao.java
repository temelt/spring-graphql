package com.temelt.sgraph.dao;

import com.temelt.sgraph.model.Task;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by temelt on 13.07.2019.
 */
public class TaskDao {
    private List<Task> tasks;

    public TaskDao(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks(int count, int offset) {
        return tasks.stream().skip(offset).limit(count).collect(Collectors.toList());
    }

    public void savePost(Task task) {
        tasks.add(0, task);
    }
}