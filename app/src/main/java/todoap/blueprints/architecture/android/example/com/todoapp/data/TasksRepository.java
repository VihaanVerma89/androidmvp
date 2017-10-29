package todoap.blueprints.architecture.android.example.com.todoapp.data;

import android.support.annotation.NonNull;

import java.util.LinkedHashMap;
import java.util.Map;

import todoap.blueprints.architecture.android.example.com.todoapp.tasks.TasksPresenter;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by vihaan on 28/10/17.
 */


public class TasksRepository implements  TasksDataSource{

    private static TasksRepository INSTANCE = null;

    private final TasksDataSource mTasksRemoteDataSource;

    private final TasksDataSource mTasksLocalDataSource;

    /**
     * This variable has package local visibility so it can be accessed from tests.
     */
    Map<String, Task> mCachedTasks;

    /**
     * Marks the cache as invalid, to force an update the next time data is requested. This variable
     * has package local visibility so it can be accessed from tests.
     */
    boolean mCacheIsDirty = false;

    // Prevent direct instantiation.
    private TasksRepository(@NonNull TasksDataSource tasksRemoteDataSource,
                            @NonNull TasksDataSource tasksLocalDataSource) {
        mTasksRemoteDataSource = checkNotNull(tasksRemoteDataSource);
        mTasksLocalDataSource = checkNotNull(tasksLocalDataSource);
    }
    public static TasksRepository getInstance(TasksDataSource tasksRemoteDataSource,
                                              TasksDataSource tasksLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new TasksRepository(tasksRemoteDataSource, tasksLocalDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void saveTask(@NonNull Task task) {
        checkNotNull(task);
        mTasksRemoteDataSource.saveTask(task);
        mTasksLocalDataSource.saveTask(task);

        // Do in memory cache update to keep the app UI up to date
        if (mCachedTasks == null) {
            mCachedTasks = new LinkedHashMap<>();
        }
        mCachedTasks.put(task.getId(), task);
    }
}
