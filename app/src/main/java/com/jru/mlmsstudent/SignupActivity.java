package com.jru.mlmsstudent;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jru.mlmsstudent.api.calls.SignUp;
import com.jru.mlmsstudent.api.request.SignUpRequest;
import com.jru.mlmsstudent.apioriginal.ResponseHandlerRegistration;
import com.jru.mlmsstudent.apioriginal.RetrofitManager;
import com.jru.mlmsstudent.apioriginal.RetrofitService;
import com.jru.mlmsstudent.apioriginal.SendRegistration;
import com.jru.mlmsstudent.data.EZSharedPreferences;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends BaseActivity {

    @BindView(R.id.etName)
    TextInputEditText etName;

    @BindView(R.id.etEmail)
    TextInputEditText etEmail;

    @BindView(R.id.etPassword)
    TextInputEditText etPassword;

    @BindView(R.id.btnSignUp)
    Button btnSignUp;

    @BindView(R.id.tvSignIn)
    TextView tvSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSignUp)
    void clickSignUp() {
        // Form the fields of the body here
        boolean isValid;
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString();
        String userType = "student"; // This will only be used for the API sending

        isValid = !(name.equals("") || email.equals("") || password.equals(""));

        if (isValid) {
            Log.d("_TAG", "Should proceed to registration if so");

            String header = EZSharedPreferences.getAccessToken(this);
            SignUpRequest request = new SignUpRequest(name, email, password, userType);
            SignUp.execute(header, request, new SignUp.Callback() {
                @Override
                public void isSuccessful() {
                    Toast.makeText(SignupActivity.this, "Sign up successful!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                    finish();
                }

                @Override
                public void onFailure(String errorMessage) {
                    Toast.makeText(SignupActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void showLoadingDialog() {
                    showProgressDialog("Sending registration. Please wait.");
                }

                @Override
                public void hideLoadingDialog() {
                    hideProgressDialog();
                }
            });
        } else {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.tvSignIn)
    void clickSignIn() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
