package com.jru.mlmsstudent.lecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jru.mlmsstudent.R;

import butterknife.ButterKnife;

public class LectureAskQuestionActivity extends AppCompatActivity {

    private boolean isAnonymous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_ask_question);
        ButterKnife.bind(this);
    }

    private void sendQuestion() {

    }
}
