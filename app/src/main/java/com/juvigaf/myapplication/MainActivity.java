package com.juvigaf.myapplication;

import static com.juvigaf.myapplication.SharedData.databaseReference;
import static com.juvigaf.myapplication.SharedData.orderCount;
import static com.juvigaf.myapplication.SharedData.teams;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.juvigaf.myapplication.UI.search.SearchFragment;
import com.juvigaf.myapplication.UI.main.MainFragment;
import com.juvigaf.myapplication.UI.profile.ProfileFragment;
import com.juvigaf.myapplication.UI.transaction.TransactionFragment;
import com.juvigaf.myapplication.models.KuliMember;
import com.juvigaf.myapplication.models.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContainer, new MainFragment()).commit();

    }

    public void toHome(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContainer, new MainFragment()).commit();
    }

    public void toSearch(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContainer, new SearchFragment()).commit();
    }

    public void toTransaction(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContainer, new TransactionFragment()).commit();
    }

    public void toProfile(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainContainer, new ProfileFragment());
    }
}