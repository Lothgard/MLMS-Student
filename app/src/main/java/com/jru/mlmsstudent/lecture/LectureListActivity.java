package com.jru.mlmsstudent.lecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jru.mlmsstudent.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LectureListActivity extends AppCompatActivity {

    @BindView(R.id.rv_lectures)
    RecyclerView rvLectures;

    LectureListAdapter mLectureListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_list);
        ButterKnife.bind(this);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        // Mock Lecture List
        List<Lecture> list = new ArrayList<>();
        list.add(new Lecture("This is a title", "Bar description", "File://uri/here"));
        list.add(new Lecture("Title Foo", "Bar description again and again and again", "File://uri/here"));

        mLectureListAdapter = new LectureListAdapter(this, list);
        rvLectures.setAdapter(mLectureListAdapter);
        rvLectures.setLayoutManager(new LinearLayoutManager(this));
    }


}
