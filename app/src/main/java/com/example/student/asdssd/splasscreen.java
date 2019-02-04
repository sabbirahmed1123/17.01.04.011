package com.example.student.asdssd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class splasscreen extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progrees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splasscreen);
        progressBar =(ProgressBar) findViewById(R.id.progressId);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                stratApp();
            }
        });
        thread.start();
    }
    public void doWork(){
        for(progrees=20;progrees<=100;progrees=progrees+20){
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progrees);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void stratApp(){
        Intent intent = new Intent(splasscreen.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
