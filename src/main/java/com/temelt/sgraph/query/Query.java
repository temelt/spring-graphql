package com.temelt.sgraph.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.temelt.sgraph.dao.TaskDao;
import com.temelt.sgraph.model.Task;

import java.util.List;

/**
 * Created by temelt on 13.07.2019.
 */
public class Query implements GraphQLQueryResolver {
    private TaskDao taskDao;

    public Query(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    /**
     *  For Test -> http://localhost:8080/graphql?query={tasks(count:10,offset:0){id title content}}
     * @param count
     * @param offset
     * @return
     */
    public List<Task> tasks(int count, int offset) {
        return taskDao.getTasks(count, offset);
    }
}
