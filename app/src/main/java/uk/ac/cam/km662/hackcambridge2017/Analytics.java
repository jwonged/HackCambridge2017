package uk.ac.cam.km662.hackcambridge2017;

import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class Analytics extends AppCompatActivity {

    private static final String PREFS_NAME = "Cache";
    private ImageView userProfilePic;
    private TextView analyticsGreeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics);

        userProfilePic = (ImageView) findViewById(R.id.user_profile_pic);
        analyticsGreeting = (TextView) findViewById(R.id.analytics_title);

        // Restore preferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        // If can't find name, just call them buddy
        String username = settings.getString("username", "buddy");
        String profilePictureUrl = settings.getString("profilePicture",
                "https://www.google.co.uk/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjW8P3InObRAhWB7hoKHUcmAUkQjRwIBw&url=http%3A%2F%2Fwww.visualsays.com%2Fcat-pictures%2F&psig=AFQjCNFYlAWBYnAQEm2Ka3T0kkIzxHpN3g&ust=1485740424989722");


        analyticsGreeting.setText("Your Progress, " + username);
        Picasso.with(getApplicationContext()).load(profilePictureUrl)
                .transform(new CircleTransform()).into(userProfilePic);


    }


}
