package com.juvigaf.myapplication;

import static com.juvigaf.myapplication.SharedData.ALL_KULI;
import static com.juvigaf.myapplication.SharedData.DATABASE_REFERENCE;
import static com.juvigaf.myapplication.SharedData.ORDER_COUNT;
import static com.juvigaf.myapplication.SharedData.teams;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.juvigaf.myapplication.UI.login.LoginFragment;
import com.juvigaf.myapplication.models.KuliMember;
import com.juvigaf.myapplication.models.User;

import java.util.ArrayList;
import java.util.List;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        //get order count
        DATABASE_REFERENCE.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ORDER_COUNT = snapshot.child("orderCount").getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //get kuli member
        DATABASE_REFERENCE.child("Kulimember").addListenerForSingleValueEvent(new ValueEventListener() {
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

                        DATABASE_REFERENCE.child(username).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                String email = snapshot.child("email").getValue(String.class);
                                String name = snapshot.child("name").getValue(String.class);
                                String phone = snapshot.child("phone").getValue(String.class);
                                int role = snapshot.child("role").getValue(Integer.class);
                                String password = snapshot.child("password").getValue(String.class);
                                User newUser = new User(username, name, email, password, phone, role);
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

        DATABASE_REFERENCE.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot data : snapshot.getChildren()){
                    //ambil semua kuli
                    int role = data.child("role").getValue(Integer.class);
                    //jika bukan customer (kuli)
                    if(role != 1){
                        String username = data.child("username").getValue(String.class);
                        String name = data.child("name").getValue(String.class);
                        String email = data.child("email").getValue(String.class);
                        String password = data.child("password").getValue(String.class);
                        String phone = data.child("phone").getValue(String.class);
                        int profile = data.child("profile").getValue(Integer.class);
                        User newUser = new User(username, name, email, password, phone, role);
                        newUser.setProfile(profile);
                        ALL_KULI.add(newUser);
                    }
                }

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.landingContainer, new LoginFragment()).commit();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}