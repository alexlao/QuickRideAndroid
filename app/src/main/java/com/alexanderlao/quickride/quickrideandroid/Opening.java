package com.alexanderlao.quickride.quickrideandroid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Opening extends Activity {
    private Button rider;
    private Button driver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opening);
        rider = (Button) findViewById(R.id.rider);
        driver =  (Button) findViewById(R.id.driver);
        rider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainRide.class);
                startActivity(i);
            }
        });

    }
}
