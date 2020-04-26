package logic;

import android.content.Context;
import android.widget.Toast;

public class ShowToast {
    public static void showToast(Context mContext, String status) {
        Toast.makeText(mContext, status, Toast.LENGTH_SHORT).show();
    }
}
