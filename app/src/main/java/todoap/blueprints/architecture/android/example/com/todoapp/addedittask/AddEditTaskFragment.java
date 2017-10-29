package todoap.blueprints.architecture.android.example.com.todoapp.addedittask;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import todoap.blueprints.architecture.android.example.com.todoapp.R;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by vihaan on 28/10/17.
 */

public class AddEditTaskFragment extends Fragment implements AddEditTaskContract.View{


    public static final String ARGUMENT_EDIT_TASK_ID = "EDIT_TASK_ID";

    private AddEditTaskContract.Presenter mPresenter;
    private TextView mTitle;
    private TextView mDescription;


    public static AddEditTaskFragment newInstance() {
        return new AddEditTaskFragment();
    }


    public AddEditTaskFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.addtask_frag, container, false);
        mTitle = (TextView) root.findViewById(R.id.add_task_title);
        mDescription = (TextView) root.findViewById(R.id.add_task_description);
        setHasOptionsMenu(true);
        return root;
    }

    @Override
    public void setPresenter(AddEditTaskContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
