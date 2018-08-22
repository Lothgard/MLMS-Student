package com.jru.mlmsstudent.quiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jru.mlmsstudent.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuizFinishFragment extends Fragment {

    private static final String ARG_SCORE_PERCENTAGE = "score_percentage";


    private double mScorePercentage;

    @BindView(R.id.lbl_score_percentage)
    TextView lblScorePercentage;

    public QuizFinishFragment() {
        // Required empty public constructor
    }

    public static QuizFinishFragment newInstance(double scorePercentage) {
        QuizFinishFragment fragment = new QuizFinishFragment();
        Bundle args = new Bundle();
        args.putDouble(ARG_SCORE_PERCENTAGE, scorePercentage);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mScorePercentage = getArguments().getDouble(ARG_SCORE_PERCENTAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quiz_finish, container, false);

        ButterKnife.bind(this, v);

        lblScorePercentage.setText(String.format("%.2f%%", mScorePercentage));

        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @OnClick(R.id.btn_close_quiz)
    public void closeQuiz() {
        getActivity().finish();
    }

}
