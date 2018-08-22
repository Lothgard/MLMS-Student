package com.jru.mlmsstudent.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jru.mlmsstudent.R;
import com.jru.mlmsstudent.apioriginal.QuizData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuizListActivity extends AppCompatActivity {

   @BindView(R.id.rv_quizzes)
    RecyclerView rvQuizzes;

    private QuizListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);
        ButterKnife.bind(this);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        List<QuizData> lstQuizzes = new ArrayList<>();

        lstQuizzes.add(new QuizData(
                1,
                1000L,
                "GetQuiz in Social Studies",
                60L,
                String.valueOf(System.currentTimeMillis()),
                String.valueOf(System.currentTimeMillis()),
                String.valueOf(System.currentTimeMillis())
        ));

        lstQuizzes.add(new QuizData(
                1,
                1000L,
                "Science Examination",
                60L,
                String.valueOf(System.currentTimeMillis()),
                String.valueOf(System.currentTimeMillis()),
                String.valueOf(System.currentTimeMillis())
        ));

        mAdapter = new QuizListAdapter(this, lstQuizzes);
        rvQuizzes.setAdapter(mAdapter);
        rvQuizzes.setLayoutManager(new LinearLayoutManager(this));
    }
}
