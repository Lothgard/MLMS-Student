package com.jru.mlmsstudent;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.jru.mlmsstudent.apioriginal.RetrofitManager;
import com.jru.mlmsstudent.apioriginal.RetrofitService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AttendanceActivity extends AppCompatActivity implements Callback<ResponseBody> {

    @BindView(R.id.txt_password)
    TextInputEditText txtPassword;

    @BindView(R.id.btn_send_attendance)
    Button btnSendAttendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        ButterKnife.bind(this);
    }

    private String getDeviceUuid() {
        return null;
    }

    @OnClick(R.id.btn_send_attendance)
    public void sendAttendance() {
        String studentId = "???"; // TODO: Know where to get student ID
        String password = txtPassword.getText().toString().trim();
        String uuid = getDeviceUuid();

        // Retrofit request here
        Retrofit retrofit = RetrofitManager.getInstance().getRetrofit();
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<ResponseBody> call = service.checkGoogle();
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        Log.d("!!! Response", "Response: " + response.raw());
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        Log.d("!!! Response", "Error encountered: " + t.getLocalizedMessage());
    }
}
