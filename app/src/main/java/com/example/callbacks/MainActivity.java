package com.example.callbacks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Worker.WorkerCallback {

    private static final String TAG = "MainActivity_TAG";

    private Worker worker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        worker = new Worker();
    }

    private void doSomethingElse() {

    }

    private void doSomething() {
        worker.doSomething(this);
    }

    public void buttonClick(View view) {
        Log.d(TAG, "onCreate: called doSomething");
        doSomething();
        Log.d(TAG, "onCreate: called doSomethingElse");
        doSomethingElse();
    }

    @Override
    public void onUpdate(String update) {
        Log.d(TAG, "onUpdate: update message " + update);
    }

    @Override
    public void onFinished(String message) {
        Log.d(TAG, "onFinished: " + message);
    }

    @Override
    public void onError(String error) {
        Log.d(TAG, "onError: " + error);
    }
}
