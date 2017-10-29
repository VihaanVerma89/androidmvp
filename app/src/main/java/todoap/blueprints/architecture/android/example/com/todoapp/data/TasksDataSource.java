package todoap.blueprints.architecture.android.example.com.todoapp.data;

import android.support.annotation.NonNull;

/**
 * Created by vihaan on 29/10/17.
 */

public interface TasksDataSource {


    void saveTask(@NonNull Task task);
}
