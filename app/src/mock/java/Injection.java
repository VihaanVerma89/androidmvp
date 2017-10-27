import android.content.ContentResolver;
import android.content.Context;
import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by vihaan on 27/10/17.
 */

public class Injection {

    public static void provideTaskRepository(@NonNull Context context)
    {
        checkNotNull(context);
    }
}
