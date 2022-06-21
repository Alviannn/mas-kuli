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

        //get order count
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                orderCount = snapshot.child("orderCount").getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //get kuli member
        databaseReference.child("Kulimember").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot data : snapshot.getChildren()){
                    //dapat data ada berapa user dalam team kuli
                    Integer teamCount = data.child("teamCount").getValue(Integer.class);
                    String teamId = data.child("team_id").getValue(String.class);
                    Double rating = data.child("rating").getValue(Double.class);
                    List<User> users = new ArrayList<>();
                    for(int i = 0; i < teamCount; i++){
                        //ambil data team kuli
                        String username = snapshot.child(String.valueOf(i)).getValue(String.class);

                        databaseReference.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                String email = snapshot.child("email").getValue(String.class);
                                String name = snapshot.child("name").getValue(String.class);
                                String phone = snapshot.child("phone").getValue(String.class);
                                Integer role = snapshot.child("role").getValue(Integer.class);
                                String password = snapshot.child("password").getValue(String.class);
                                User newUser = new User(username, email, password, phone, role);
                                users.add(newUser);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                    KuliMember newKuliMember = new KuliMember(teamId, users, rating);
                    teams.put(teamId, newKuliMember);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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