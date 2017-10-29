package com.example.android.architecture.blueprints.todoapp;

import android.content.ContentResolver;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.android.architecture.blueprints.todoapp.data.FakeTasksRemoteDataSource;

import todoap.blueprints.architecture.android.example.com.todoapp.data.TasksRepository;
import todoap.blueprints.architecture.android.example.com.todoapp.data.source.local.TasksLocalDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by vihaan on 27/10/17.
 */

public class Injection {

    public static TasksRepository provideTasksRepository(@NonNull Context context)
    {
        checkNotNull(context);
        return TasksRepository.getInstance(FakeTasksRemoteDataSource.getInstance(),
                TasksLocalDataSource.getInstance(context) );
    }
}
