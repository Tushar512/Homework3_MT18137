package com.example.tushar.homework3_mt18137;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    int currentQid=1;
    TextView question, questionId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail, container, false);
        question = view.findViewById(R.id.question);
        questionId = view.findViewById(R.id.questionId);
        Intent i = getActivity().getIntent();
        try {
            String qid = i.getStringExtra("questionId");
            currentQid = Integer.parseInt(qid.substring(1));
            displayQuestion();
            Button nextBtn = view.findViewById(R.id.nextBtn);
            nextBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(currentQid < 30) {
                        currentQid++;
                        displayQuestion();
                    }
                }
            });
            Button prevBtn = view.findViewById(R.id.prevBtn);
            prevBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(currentQid > 1) {
                        currentQid--;
                        displayQuestion();
                    }
                }
            });
        } catch(Exception e) {
            Log.i("Error", e.getMessage());
        }
        return view;
    }
    public void displayQuestion() {
        DatabaseHelper dh = new DatabaseHelper(getActivity());
        Question q = dh.getQuestionById(currentQid);
        question.setText(q.getQuestion());
        questionId.setText("Q"+q.getId());
    }
}
