package todoap.blueprints.architecture.android.example.com.todoapp.tasks;

import android.app.Activity;

import todoap.blueprints.architecture.android.example.com.todoapp.addedittask.AddEditTaskActivity;
import todoap.blueprints.architecture.android.example.com.todoapp.data.TasksRepository;

/**
 * Created by vihaan on 27/10/17.
 */

public class TasksPresenter implements TasksContract.Presenter{

    private TasksRepository mTasksRepository;
    private TasksContract.View mTasksView;

    public TasksPresenter(TasksRepository tasksRepository, TasksContract.View tasksView)
    {
        mTasksRepository = tasksRepository;
        mTasksView = tasksView;

        mTasksView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void result(int requestCode, int resultCode) {
        // If a task was successfully added, show snackbar
        if (AddEditTaskActivity.REQUEST_ADD_TASK == requestCode && Activity.RESULT_OK == resultCode) {
            mTasksView.showSuccessfullySavedMessage();
        }
    }

    @Override
    public void addNewTask() {
        mTasksView.showAddTask();
    }
}
