package com.juvigaf.myapplication;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.juvigaf.myapplication.models.User;

public class SharedData {

    public static User currentUser;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://maskuliapp-default-rtdb.firebaseio.com/");

}
