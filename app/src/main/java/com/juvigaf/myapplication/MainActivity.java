package com.juvigaf.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.juvigaf.myapplication.UI.SearchFragment;
import com.juvigaf.myapplication.UI.main.MainFragment;
import com.juvigaf.myapplication.UI.profile.ProfileFragment;
import com.juvigaf.myapplication.UI.transaction.TransactionFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContainer, new MainFragment());

    }

    public void toHome(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContainer, new MainFragment());
    }

    public void toSearch(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContainer, new SearchFragment());
    }

    public void toTransaction(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContainer, new TransactionFragment());
    }

    public void toProfile(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContainer, new ProfileFragment());
    }
}