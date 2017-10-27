package todoap.blueprints.architecture.android.example.com.todoapp.data;

import todoap.blueprints.architecture.android.example.com.todoapp.tasks.TasksPresenter;

/**
 * Created by vihaan on 28/10/17.
 */


public class TasksRepository {

    private static TasksRepository INSTANCE = null;


    private TasksRepository(){

    }

    public static TasksRepository getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new TasksRepository();
        }
        return INSTANCE;
    }
}
