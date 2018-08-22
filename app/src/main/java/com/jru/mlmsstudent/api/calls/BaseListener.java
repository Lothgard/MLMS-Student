package com.jru.mlmsstudent.api.calls;

public interface BaseListener {
    void onFailure(String errorMessage);

    void showLoadingDialog();

    void hideLoadingDialog();
}
