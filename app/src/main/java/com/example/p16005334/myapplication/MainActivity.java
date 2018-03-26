package com.example.p16005334.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "FirstVersionApp";
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.magicButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                Log.i(TAG,"Console prints this !"); // display stuffs on logs
                count++;
                String message = getString(R.string.cookie_clicked);
                message += count;
                TextView textView = findViewById(R.id.clickDisplaying);
                textView.setText(message);
                Toast.makeText(getApplicationContext(),"+1 Cookie bro",Toast.LENGTH_SHORT)
                    .show();

            }
        });
        setupLaunchButton();
    }

    private void setupLaunchButton() {
        Button swapActivityButton = findViewById(R.id.switchTab);
        swapActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Clicked swap tab", Toast.LENGTH_SHORT)
                    .show();

                // Load the second activity
               //  Intent intent = new Intent(MainActivity.this,SecondActivity.class); Sans encapsulation
                Intent intent = SecondActivity.makeIntent(MainActivity.this);
                startActivity(intent);
            }
        });
    }

}
