package todoap.blueprints.architecture.android.example.com.todoapp.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import todoap.blueprints.architecture.android.example.com.todoapp.data.Task;
import todoap.blueprints.architecture.android.example.com.todoapp.data.TasksDataSource;


import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by vihaan on 29/10/17.
 */

public class TasksLocalDataSource implements TasksDataSource {
    private static TasksLocalDataSource INSTANCE;

    private TasksDbHelper mDbHelper;

    // Prevent direct instantiation.
    private TasksLocalDataSource(@NonNull Context context) {
        checkNotNull(context);
        mDbHelper = new TasksDbHelper(context);
    }

    public static TasksLocalDataSource getInstance(@NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new TasksLocalDataSource(context);
        }
        return INSTANCE;
    }

    @Override
    public void saveTask(@NonNull Task task) {
        checkNotNull(task);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TasksPersistenceContract.TaskEntry.COLUMN_NAME_ENTRY_ID, task.getId());
        values.put(TasksPersistenceContract.TaskEntry.COLUMN_NAME_TITLE, task.getTitle());
        values.put(TasksPersistenceContract.TaskEntry.COLUMN_NAME_DESCRIPTION, task.getDescription());
        values.put(TasksPersistenceContract.TaskEntry.COLUMN_NAME_COMPLETED, task.isCompleted());

        db.insert(TasksPersistenceContract.TaskEntry.TABLE_NAME, null, values);

        db.close();
    }
}
