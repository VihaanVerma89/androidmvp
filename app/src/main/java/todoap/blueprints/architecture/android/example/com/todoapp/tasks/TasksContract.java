package todoap.blueprints.architecture.android.example.com.todoapp.tasks;

import todoap.blueprints.architecture.android.example.com.todoapp.BasePresenter;

/**
 * Created by vihaan on 27/10/17.
 */

public interface TasksContract {


    public interface Presenter extends BasePresenter{

        void addNewTask();
    }
}
