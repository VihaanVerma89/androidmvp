package todoap.blueprints.architecture.android.example.com.todoapp.tasks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import todoap.blueprints.architecture.android.example.com.todoapp.R;

/**
 * Created by vihaan on 27/10/17.
 */

public class TasksFragment extends Fragment implements TasksContract.View{


    private TasksContract.Presenter mPresenter;
    public TasksFragment()
    {

    }

    public static TasksFragment newInstance() {
        TasksFragment fragment = new TasksFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tasks_frag, container, false);
        return root;
    }

    @Override
    public void setPresenter(TasksContract.Presenter presenter) {
        mPresenter =presenter;
    }


    private static class TasksAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }
}

