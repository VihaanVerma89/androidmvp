package todoap.blueprints.architecture.android.example.com.todoapp.addedittask;

import todoap.blueprints.architecture.android.example.com.todoapp.BasePresenter;
import todoap.blueprints.architecture.android.example.com.todoapp.BaseView;

/**
 * Created by vihaan on 28/10/17.
 */

public class AddEditTaskContract {

    public interface View extends BaseView<Presenter>{
        void showEmptyTaskError();
        void showTasksList();
    }

    public interface Presenter extends BasePresenter{

        void saveTask(String title, String description);
    }
}
