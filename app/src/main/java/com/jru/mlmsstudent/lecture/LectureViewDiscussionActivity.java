package com.jru.mlmsstudent.lecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jru.mlmsstudent.R;

import butterknife.ButterKnife;

public class LectureViewDiscussionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_view_discussion);
        ButterKnife.bind(this);
    }
}
