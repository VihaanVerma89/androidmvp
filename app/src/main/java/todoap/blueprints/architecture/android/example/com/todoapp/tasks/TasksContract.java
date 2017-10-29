package todoap.blueprints.architecture.android.example.com.todoapp.tasks;

import todoap.blueprints.architecture.android.example.com.todoapp.BasePresenter;
import todoap.blueprints.architecture.android.example.com.todoapp.BaseView;

/**
 * Created by vihaan on 27/10/17.
 */

public interface TasksContract {

    public interface View extends BaseView<Presenter> {
        void showAddTask();
        void showSuccessfullySavedMessage();
    }

    public interface Presenter extends BasePresenter{
        void result(int requestCode, int resultCode);
        void addNewTask();
    }
}
