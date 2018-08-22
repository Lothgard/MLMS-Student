package com.jru.mlmsstudent.quiz;

import android.content.DialogInterface;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.jru.mlmsstudent.R;
import com.jru.mlmsstudent.quiz.MockQuestions;
import com.jru.mlmsstudent.quiz.QuizFinishFragment;
import com.jru.mlmsstudent.quiz.QuizItem;
import com.jru.mlmsstudent.quiz.QuizPageFragment;
import com.jru.mlmsstudent.quiz.QuizStartFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuizActivity
        extends AppCompatActivity
        implements QuizStartFragment.QuizStartInteractionListener,
        QuizPageFragment.QuizPageInteractionListener {

    private boolean isQuizOngoing = false;

    private List<QuizItem> lstQuizItems = new ArrayList<>();
    private List<String> lstAnswers;
    private int currentQuizIndex = -1;

    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ButterKnife.bind(this);

        if (lstQuizItems != null) lstQuizItems.clear();
        lstAnswers = new LinkedList<>(Arrays.asList(new String[] {"N", "N", "N", "N", "N", "N", "N", "N", "N", "N"}));

        getQuiz();
        setInitialFragment();
    }

    @Override
    public void onBackPressed() {
        if (isQuizOngoing) {
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("Are you sure you want to exit?")
                    .setMessage("We will consider your current progress as your final set of answer. No retakes will be allowed")
                    .setPositiveButton("Yes, I understand", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finishQuiz();
                        }
                    })
                    .setNegativeButton("Continue Answering GetQuiz", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .setCancelable(false)
                    .create();

            dialog.show();
        } else {
            super.onBackPressed();
        }
    }

    private void setInitialFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        QuizStartFragment fragment = QuizStartFragment.newInstance("", "");
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    private void getQuiz() {
        // API request for getting the quiz
        lstQuizItems = MockQuestions.getDummyHtmlQuestions();
    }

    private void startQuiz() {
        Collections.shuffle(lstQuizItems);
        goToNextQuestion();
        isQuizOngoing = true;
    }

    private void startQuizTimer() {

    }

    private void goToNextQuestion() {
        currentQuizIndex++;

        if (currentQuizIndex == lstQuizItems.size()) {
            finishQuiz();
            return;
        }

        QuizItem currentItem = lstQuizItems.get(currentQuizIndex);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        QuizPageFragment fragment = QuizPageFragment.newInstance((currentQuizIndex + 1), currentItem);
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    private void saveAnswer(String answer) {
        lstAnswers.remove(currentQuizIndex);
        lstAnswers.add(currentQuizIndex, answer);
        goToNextQuestion();
    }

    private double calculateScore() {
        int numberOfItems = lstQuizItems.size();
        int scoreCounter = 0;

        for (int i = 0; i < numberOfItems; i++) {
            String correctAnswer = lstQuizItems.get(i).getLetterOfCorrectAnswer();
            String answer = lstAnswers.get(i);

            if (correctAnswer.equalsIgnoreCase(answer.toLowerCase())) scoreCounter++;
        }

        return ((double) scoreCounter / (double) numberOfItems) * 100;
    }

    private void finishQuiz() {
        isQuizOngoing = false;
        double scorePercentage = calculateScore();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        QuizFinishFragment fragment = QuizFinishFragment.newInstance(scorePercentage);
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    @Override
    public void onQuizStarted() {
        startQuiz();
    }

    @Override
    public void sendAnswer(int questionNumber, String answer) {
        saveAnswer(answer);
    }

}
