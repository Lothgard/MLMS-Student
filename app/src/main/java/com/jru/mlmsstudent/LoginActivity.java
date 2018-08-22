package com.jru.mlmsstudent;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.jru.mlmsstudent.api.calls.Login;
import com.jru.mlmsstudent.api.response.LoginResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.btnSignIn)
    Button btnSignIn;

    @BindView(R.id.tilUsername)
    TextInputLayout tilUsername;

    @BindView(R.id.etUsername)
    TextInputEditText etUsername;

    @BindView(R.id.tilPassword)
    TextInputLayout tilPassword;

    @BindView(R.id.etPassword)
    TextInputEditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSignIn)
    public void signIn() {
        Log.d("AppLogin", "This should login the user");
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString();

        if (username.equals("")) {
            tilUsername.setError("Username is required");
            return;
        }

        if (password.equals("")) {
            tilPassword.setError("Password is required");
            return;
        }

        Log.d("AppLogin", "Username: ".concat(username).concat(" Password: ").concat(password));

        Login.request(username, password, new Login.RequestListener() {
            @Override
            public void isSuccessful(LoginResponse response) {
                Log.d("TAG_", response.toString());
                loginSuccessful(response);
            }

            @Override
            public void onFailure(String errorMessage) {
                Log.d("TAG_", "onFailure: " + errorMessage);
                Toast.makeText(LoginActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void showLoadingDialog() {
                // TODO: showLoadingDialog;
                showProgressDialog("Logging in...");
                Log.d("TAG_", "showLoadingDialog");
            }

            @Override
            public void hideLoadingDialog() {
                // TODO: hideLoadingDialog;
                hideProgressDialog();
                Log.d("TAG_", "hideLoadingDialog");
            }
        });
    }

    private void loginSuccessful(LoginResponse response) {
        Log.d("TAG_", "This is a successful response ");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tvSignup)
    public void clickSignUp() {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }
}
