package com.juvigaf.myapplication.UI.main;

import static com.juvigaf.myapplication.SharedData.allKuli;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.juvigaf.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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

    LinearLayout kuliContainer;
    ImageView buttonLeft, buttonRight;
    TextView kuliName, kuliRole, kuliRating;
    int currentKuli = 0;
    int countKuli = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        //kerjain sini bang buat layoutnya
        init(view);

        setData();
        buttonLeft.setOnClickListener(changeInfoLeft->{
            if(++currentKuli >= countKuli){
                currentKuli = 0;
            }
            setData();
        });

        buttonRight.setOnClickListener(changeInfoRight->{
            if(--currentKuli < 0){
                currentKuli = countKuli - 1;
            }
            setData();
        });

        return view;
    }

    void setData(){
        kuliName.setText(allKuli.get(currentKuli).getName());
        kuliRole.setText("Peran : kuli"); //sementara kuli semua rolenya
        kuliRating.setText("Rating : 5.0"); //sementari kuli semua rating 5.0
    }

    void init(View view){
        kuliContainer = view.findViewById(R.id.kuliContainer);
        buttonLeft = view.findViewById(R.id.buttonLeft);
        buttonRight = view.findViewById(R.id.buttonRight);

        kuliName = view.findViewById(R.id.kuliName);
        kuliRole = view.findViewById(R.id.kuliRole);
        kuliRating = view.findViewById(R.id.kuliRating);

        countKuli = allKuli.size();
    }
}