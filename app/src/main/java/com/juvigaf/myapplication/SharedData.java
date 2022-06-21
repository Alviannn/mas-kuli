package com.juvigaf.myapplication;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.juvigaf.myapplication.models.KuliMember;
import com.juvigaf.myapplication.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SharedData {

    public static User currentUser;
    public static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://maskuliapp-default-rtdb.firebaseio.com/");
    public static Map<String, KuliMember>teams;
    public static int orderCount;
    public static List<User> allKuli = new ArrayList<>();

}
