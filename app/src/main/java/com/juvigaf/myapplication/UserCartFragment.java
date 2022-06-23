package com.juvigaf.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class UserCartFragment extends Fragment {

    private RecyclerView kuliCardView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_cart, container, false);

        init(view);
//        DataAdapter dataAdapter = new DataAdapter(getContext());
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
//        kuliCardView.setAdapter(dataAdapter);
//        kuliCardView.setLayoutManager(linearLayoutManager);

        return view;
    }

    private void init(View view){
        kuliCardView = view.findViewById(R.id.kuli_card);
    }

}