package ca.antonious.betahub.welcome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ca.antonious.betahub.R;
import ca.antonious.betahub.home.HomeFeedActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button continueButton = (Button) findViewById(R.id.continue_button);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchHomeFeed();
            }
        });
    }

    private void launchHomeFeed() {
        startActivity(new Intent(this, HomeFeedActivity.class));
    }
}
