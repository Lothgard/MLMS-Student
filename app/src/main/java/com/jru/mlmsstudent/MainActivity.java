package com.jru.mlmsstudent;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jru.mlmsstudent.lecture.Lecture;
import com.jru.mlmsstudent.lecture.LectureListActivity;
import com.jru.mlmsstudent.lecture.LectureListAdapter;
import com.jru.mlmsstudent.quiz.QuizActivity;
import com.jru.mlmsstudent.quiz.QuizListActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_attendance)
    ImageButton btnAttendance;

    @BindView(R.id.btn_quiz)
    ImageButton btnQuiz;

    @BindView(R.id.rv_lectures)
    RecyclerView rvLectures;

    @BindView(R.id.container_attendance)
    LinearLayout containerAttendance;

    @BindView(R.id.txt_password)
    EditText txtPassword;

    private LectureListAdapter mLectureListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupLecturesRecyclerView();
    }

    private void setupLecturesRecyclerView() {
        List<Lecture> list = new ArrayList<>();
        list.add(new Lecture("This is a title", "Bar description", "File://uri/here"));
        list.add(new Lecture("Title Foo", "Bar description again and again and again", "File://uri/here"));

        mLectureListAdapter = new LectureListAdapter(this, list);
        rvLectures.setAdapter(mLectureListAdapter);
        rvLectures.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnClick(R.id.btn_attendance)
    public void openAttendanceModule() {
        int toggledVisibility = containerAttendance.getVisibility() == View.GONE ? View.VISIBLE
                : View.GONE;
        containerAttendance.setVisibility(toggledVisibility);
    }

    @OnClick(R.id.btn_quiz)
    public void openQuizModule() {
        Intent intent = new Intent(this, QuizListActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_lectures)
    public void openLectureListModule() {
//        Intent intent = new Intent(this, LectureListActivity.class);
//        startActivity(intent);
        Toast.makeText(this, "You don\'t have saved lectures yet!", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_send_attendance)
    public void sendAttendance() {
        String password = txtPassword.getText().toString().trim();
    }

    public String getDeviceUuid() {
        TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        return null;
    }

}
