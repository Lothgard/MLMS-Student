package com.jru.mlmsstudent.lecture;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.jru.mlmsstudent.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DiscussionListActivity extends AppCompatActivity {

    @BindView(R.id.lbl_lecture_name)
    TextView lblLectureName;

    @BindView(R.id.rv_discussions)
    RecyclerView rvDiscussions;

    @BindView(R.id.btn_ask_question)
    FloatingActionButton btnAskQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion_list);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("lecture_name")) {
            lblLectureName.setText(bundle.getString("lecture_name"));
        }

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        List<DiscussionItem> list = new ArrayList<>();
        list.add(new DiscussionItem(00001L,
                "Juan Dela Cuadra",
                "What is the purpose of this lecture?",
                10001L,
                "Tutsi Tuzi",
                "This will be your quiz next week"));

        list.add(new DiscussionItem(00002L,
                "Noning Nenanini",
                "What will be coverage of the quiz?",
                10002L,
                "Malou Yeye",
                "All except the last part. Please review."));

        DiscussionListAdapter adapter = new DiscussionListAdapter(this, list);
        rvDiscussions.setAdapter(adapter);
        rvDiscussions.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnClick(R.id.btn_ask_question)
    public void openAskQuestion() {
        Intent intent = new Intent(this, LectureAskQuestionActivity.class);
        startActivity(intent);
    }
}
