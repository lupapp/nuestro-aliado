package nuestro.aliado.outsourcing.classes;


import android.content.Context;
import android.text.TextUtils;

public class Utils {

    /**
     * Internal validations
     */

    public static boolean isEmpty(String text) {
        return (text.trim().length() == 0);
    }

    public static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    /**
     * helper methods
     */

    public static int getDp(Context context, int paramInt) {
        return (int) (context.getResources().getDisplayMetrics().density * paramInt);
    }
}
