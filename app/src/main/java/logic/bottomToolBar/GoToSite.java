package logic.bottomToolBar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.linkclink.LSR.R;

import androidx.appcompat.app.AppCompatActivity;

public class GoToSite extends AppCompatActivity {

    private String url;

    /* Open program site in GitHub default: https://github.com/LinkClink/Reservation-System-LSR-Android-WEB-API */
    public void OpenSite(Context context) {

        url = context.getResources().getString(R.string.AppSiteGitHub);
        Uri uri = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
