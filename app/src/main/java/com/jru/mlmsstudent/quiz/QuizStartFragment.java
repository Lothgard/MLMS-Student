package com.jru.mlmsstudent.quiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jru.mlmsstudent.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuizStartFragment extends Fragment {

    @BindView(R.id.btn_start_quiz)
    Button btnStartQuiz;

    private QuizStartInteractionListener mListener;

    public QuizStartFragment() {
        // Required empty public constructor
    }

    public static QuizStartFragment newInstance(String param1, String param2) {
        QuizStartFragment fragment = new QuizStartFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quiz_start, container, false);
        ButterKnife.bind(this, v);
        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof QuizStartInteractionListener) {
            mListener = (QuizStartInteractionListener) context;
        } else {
            throw new RuntimeException("Parent activity must implement QuizStartInteractionListener interface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @OnClick(R.id.btn_start_quiz)
    public void startQuiz() {
        mListener.onQuizStarted();
    }


    public interface QuizStartInteractionListener {
        void onQuizStarted();
    }
}
