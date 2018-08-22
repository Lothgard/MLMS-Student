package com.jru.mlmsstudent.quiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jru.mlmsstudent.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuizPageFragment extends Fragment {

    private static final String ARG_QUESTION_NUMBER = "question_number";
    private static final String ARG_QUIZ_ITEM = "quiz_item";

    private QuizPageInteractionListener mListener;

    private int mQuestionNumber;
    private QuizItem mQuizItem;

    @BindView(R.id.lbl_item_number)
    TextView lblItemNumber;

    @BindView(R.id.lbl_question)
    TextView lblQuestion;

    @BindView(R.id.lbl_answer_a)
    TextView lblAnswerA;

    @BindView(R.id.lbl_answer_b)
    TextView lblAnswerB;

    @BindView(R.id.lbl_answer_c)
    TextView lblAnswerC;

    @BindView(R.id.lbl_answer_d)
    TextView lblAnswerD;

    public QuizPageFragment() {
        // Required empty public constructor
    }

    public static QuizPageFragment newInstance(int questionNumber, QuizItem quizItem) {
        QuizPageFragment fragment = new QuizPageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_QUESTION_NUMBER, questionNumber);
        args.putSerializable(ARG_QUIZ_ITEM, quizItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mQuestionNumber = getArguments().getInt(ARG_QUESTION_NUMBER);
            mQuizItem = (QuizItem) getArguments().getSerializable(ARG_QUIZ_ITEM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quiz_page, container, false);
        ButterKnife.bind(this, v);

        lblItemNumber.setText(String.valueOf(mQuestionNumber));
        lblQuestion.setText(mQuizItem.getQuestion());
        lblAnswerA.setText(mQuizItem.getChoices().get(0));
        lblAnswerB.setText(mQuizItem.getChoices().get(1));
        lblAnswerC.setText(mQuizItem.getChoices().get(2));
        lblAnswerD.setText(mQuizItem.getChoices().get(3));

        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof QuizPageInteractionListener) {
            mListener = (QuizPageInteractionListener) context;
        } else {
            throw new RuntimeException("Parent activity must implement interface QuizPageInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @OnClick({R.id.btn_answer_a, R.id.btn_answer_b, R.id.btn_answer_c, R.id.btn_answer_d})
    public void chosenAnswer(Button btnAnswer) {
        mListener.sendAnswer(mQuestionNumber, btnAnswer.getText().toString());
    }


    public interface QuizPageInteractionListener {
        void sendAnswer(int questionNumber, String answer);
    }
}
