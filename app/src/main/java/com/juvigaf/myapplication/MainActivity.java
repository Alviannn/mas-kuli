package com.juvigaf.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.juvigaf.myapplication.UI.LoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("test", "MainActivity");

    }

    public void toHome(View view) {
    }

    public void toSearch(View view) {

    }

    public void toTransaction(View view) {
    }

    public void toProfile(View view) {
    }
}