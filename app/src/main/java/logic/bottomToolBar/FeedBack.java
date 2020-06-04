package logic.bottomToolBar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;

import com.linkclink.LSR.R;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;

public class FeedBack extends AppCompatActivity
{

    public void OpenFeedBackDialog(Context context)
    {

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_feedback);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.show();




        /*
        final AlertDialog.Builder alert = new AlertDialog.Builder(context);
        View mView = getLayoutInflater().inflate(R.layout.dialog_feedback,null);
        alert.setView(mView);
        final AlertDialog alertDialog = alert.create();
        Objects.requireNonNull(alertDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show(); */
    }
}
