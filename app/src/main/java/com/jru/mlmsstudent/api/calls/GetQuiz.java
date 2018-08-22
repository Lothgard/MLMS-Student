package com.jru.mlmsstudent.api.calls;

import com.jru.mlmsstudent.apioriginal.ResponseHandlerGetQuiz;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetQuiz extends BaseRequest {

    public static void request(long quizId, final RequestListener listener) {
        listener.showLoadingDialog();
        Call<ResponseHandlerGetQuiz> call = getApi().getQuiz(quizId);
        call.enqueue(new Callback<ResponseHandlerGetQuiz>() {
            @Override
            public void onResponse(Call<ResponseHandlerGetQuiz> call, Response<ResponseHandlerGetQuiz> response) {
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
            public void onFailure(Call<ResponseHandlerGetQuiz> call, Throwable t) {
                listener.hideLoadingDialog();
                listener.onFailure(t.toString());
            }
        });
    }


    public interface RequestListener extends BaseListener {
        void isSuccessful(ResponseHandlerGetQuiz response);
    }
}
