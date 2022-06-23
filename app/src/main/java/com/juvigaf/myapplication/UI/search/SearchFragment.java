package com.juvigaf.myapplication.UI.search;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.juvigaf.myapplication.R;
import com.juvigaf.myapplication.SharedData;
import com.juvigaf.myapplication.adapter.DataAdapter;
import com.juvigaf.myapplication.models.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private RecyclerView kuliCardView;
    private Button sortRatingBtn;

    private boolean isAscendSort = false;

    @SuppressWarnings("ComparatorCombinators")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        init(view);
        DataAdapter dataAdapter = new DataAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        kuliCardView.setAdapter(dataAdapter);
        kuliCardView.setLayoutManager(linearLayoutManager);

        dataAdapter.notifyDataSetChanged();

        sortRatingBtn.setOnClickListener(btn ->  {
            List<User> kuliList = SharedData.ALL_KULI;
            isAscendSort = !isAscendSort;

            Comparator<User> descendingComparator = (a, b) -> a.getRating().compareTo(b.getRating());
            Comparator<User> ascendingComparator = (a, b) -> b.getRating().compareTo(a.getRating());
            Collections.sort(kuliList, isAscendSort ? ascendingComparator : descendingComparator);

            dataAdapter.notifyDataSetChanged();
        });

        return view;
    }

    private void init(View view){
        kuliCardView = view.findViewById(R.id.kuli_card);
        sortRatingBtn = view.findViewById(R.id.sort_rating_btn);
    }

}