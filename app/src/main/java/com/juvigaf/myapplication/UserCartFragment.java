package com.juvigaf.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.juvigaf.myapplication.adapter.CartAdapter;

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
        this.init(view);

        CartAdapter cartAdapter = new CartAdapter(this.getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        kuliCardView.setAdapter(cartAdapter);
        kuliCardView.setLayoutManager(linearLayoutManager);

        return view;
    }

    private void init(View view) {
        kuliCardView = view.findViewById(R.id.kuli_card);
    }

}