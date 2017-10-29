package todoap.blueprints.architecture.android.example.com.todoapp.addedittask;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import todoap.blueprints.architecture.android.example.com.todoapp.data.Task;
import todoap.blueprints.architecture.android.example.com.todoapp.data.TasksDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by vihaan on 28/10/17.
 */

public class AddEditTaskPresenter implements AddEditTaskContract.Presenter {



    @NonNull
    private final TasksDataSource mTasksRepository;

    @NonNull
    private final AddEditTaskContract.View mAddTaskView;

    @Nullable
    private String mTaskId;

    private boolean mIsDataMissing;

    /**
     * Creates a presenter for the add/edit view.
     *
     * @param taskId ID of the task to edit or null for a new task
     * @param tasksRepository a repository of data for tasks
     * @param addTaskView the add/edit view
     * @param shouldLoadDataFromRepo whether data needs to be loaded or not (for config changes)
     */
    public AddEditTaskPresenter(@Nullable String taskId, @NonNull TasksDataSource tasksRepository,
                                @NonNull AddEditTaskContract.View addTaskView, boolean shouldLoadDataFromRepo) {
        mTaskId = taskId;
        mTasksRepository = checkNotNull(tasksRepository);
        mAddTaskView = checkNotNull(addTaskView);
        mIsDataMissing = shouldLoadDataFromRepo;

        mAddTaskView.setPresenter(this);
    }


    @Override
    public void saveTask(String title, String description) {
        if (isNewTask()) {
            createTask(title, description);
        } else
        {

        }
    }

    private boolean isNewTask() {
        return mTaskId == null;
    }


    private void createTask(String title, String description) {
        Task newTask = new Task(title, description);
        if (newTask.isEmpty()) {
            mAddTaskView.showEmptyTaskError();
        }
        else{
            mTasksRepository.saveTask(newTask);
            mAddTaskView.showTasksList();
        }
    }


    @Override
    public void start() {

    }


}
