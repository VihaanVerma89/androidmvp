package todoap.blueprints.architecture.android.example.com.todoapp;

/**
 * Created by vihaan on 28/10/17.
 */

public interface BaseView<T> {

    void setPresenter(T presenter);
}
