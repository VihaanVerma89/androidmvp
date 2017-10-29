package com.example.android.architecture.blueprints.todoapp.data;

import android.support.annotation.NonNull;

import java.util.LinkedHashMap;
import java.util.Map;

import todoap.blueprints.architecture.android.example.com.todoapp.data.Task;
import todoap.blueprints.architecture.android.example.com.todoapp.data.TasksDataSource;

/**
 * Created by vihaan on 29/10/17.
 */

public class FakeTasksRemoteDataSource implements TasksDataSource{

    private static final Map<String, Task> TASKS_SERVICE_DATA = new LinkedHashMap<>();

    private static FakeTasksRemoteDataSource INSTANCE;

    private FakeTasksRemoteDataSource()
    {

    }


    public static FakeTasksRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FakeTasksRemoteDataSource();
        }
        return INSTANCE;
    }


    @Override
    public void saveTask(@NonNull Task task) {
        TASKS_SERVICE_DATA.put(task.getId(), task);
    }
}
