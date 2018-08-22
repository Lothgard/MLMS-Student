package com.jru.mlmsstudent.api.calls;

import com.jru.mlmsstudent.apioriginal.ResponseHandlerGetQuizzes;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetQuizList extends BaseRequest {

    public static void request(final RequestListener listener) {
        listener.showLoadingDialog();;
        Call<ResponseHandlerGetQuizzes> call = getApi().getQuizzes();
        call.enqueue(new Callback<ResponseHandlerGetQuizzes>() {
            @Override
            public void onResponse(Call<ResponseHandlerGetQuizzes> call, Response<ResponseHandlerGetQuizzes> response) {
                listener.hideLoadingDialog();;
                if (response.isSuccessful()) {
                    listener.isSuccessful(response.body());
                } else {
                    try {
                        listener.onFailure(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseHandlerGetQuizzes> call, Throwable t) {
                listener.hideLoadingDialog();
                listener.onFailure(t.toString());
            }
        });
    }

    public interface RequestListener extends BaseListener {
        void isSuccessful(ResponseHandlerGetQuizzes response);
    }

}
