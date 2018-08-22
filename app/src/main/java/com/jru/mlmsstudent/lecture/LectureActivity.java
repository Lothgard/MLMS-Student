package com.jru.mlmsstudent.lecture;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.jru.mlmsstudent.R;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LectureActivity extends AppCompatActivity {

    private static final int STORAGE_PERMISSION = 100;

    private Lecture mLecture;

    @BindView(R.id.lbl_title)
    TextView lblTitle;

    @BindView(R.id.lbl_description)
    TextView lblDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            mLecture = (Lecture) extras.getSerializable("lecture");

            if (mLecture == null) {
                Toast.makeText(this, "Cannot find lecture", Toast.LENGTH_SHORT).show();
                return;
            }
        } else {
            return;
        }

        lblTitle.setText(mLecture.getTitle());
        lblDescription.setText(mLecture.getDescription());
    }

    @OnClick(R.id.btn_download)
    public void downloadLectureFromApi() {
        // Downloads the lecture from an API to an application designated folder
        // Need to ask permissions first (READ/WRITE storage permission | STORAGE permission)

        askStoragePermission();
    }

    @OnClick(R.id.btn_ask_question)
    public void openAskQuestion() {
        Intent intent = new Intent(this, LectureAskQuestionActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_view_discussion)
    public void openViewDiscussion() {
        Intent intent = new Intent(this, DiscussionListActivity.class);
        intent.putExtra("lecture_name", mLecture.getTitle());
        startActivity(intent);
    }

    private void askStoragePermission() {
        // 1. Ask permission if not yet allowed
        // 2. When allowed
        //      2.1. Create application folder
        //      2.2. Proceed to download. NOTE. The application may only commence a download
        //           once the application folder has been created.
        // 3. If denied, do nothing
        // 4. When user tried to download again the next time, show permission rationale

        // This Condition checks if permission is not yet granted
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                // This block should explain why the application needs the permission it's asking
                AlertDialog dialog = new AlertDialog.Builder(this)
                        .setTitle("Why do we need this permission")
                        .setMessage("The application needs storage permission to create folder and download lectures from the server, and save it on your phone locally")
                        .setCancelable(false)
                        .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(LectureActivity.this,
                                        new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                        STORAGE_PERMISSION);
                            }
                        })
                        .setNegativeButton("Do not give permission", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create();

                dialog.show();
            } else {
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION);
            }

            // These will only be the conditions since we will not provide a 'Don't Ask Again' option for the user'


        } else {
            createApplicationFolder();
        }
    }

    // Get the result of permission ask with an override method
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                createApplicationFolder();
            } else {
                Toast.makeText(this, "You cannot download a lecture until you grant Storage permission", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void createApplicationFolder() {
        String folderName = "MLMS";
        File applicationFolder = new File(Environment.getExternalStorageDirectory().toString()
                .concat(File.separator).concat(folderName));

        if (!applicationFolder.exists()) {
            if (applicationFolder.mkdirs()) {
                Log.i("MLMS", "Application folder has been created successfully");
                // This is the only time that the application may download
                startLectureDownload();
            } else {
                Log.i("MLMS", "An error occurred when creating folder");
                Toast.makeText(this,
                        "Cannot proceed with lecture download. There was an error creating an application folder for you lectures",
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            // If the folder already exists, then the application can now download the lecture
            startLectureDownload();
        }
    }

    private void startLectureDownload() {
        Toast.makeText(this, "Starting to download lecture", Toast.LENGTH_SHORT).show();
    }

}
