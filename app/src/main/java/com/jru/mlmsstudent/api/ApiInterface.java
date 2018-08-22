package com.jru.mlmsstudent.api;

import com.jru.mlmsstudent.api.request.LoginRequest;
import com.jru.mlmsstudent.api.request.QuizCreatorRequest;
import com.jru.mlmsstudent.api.request.SignUpRequest;
import com.jru.mlmsstudent.api.response.LoginResponse;
import com.jru.mlmsstudent.api.response.PersonalDetailsResponse;
import com.jru.mlmsstudent.api.response.QuizCreatorResponse;
import com.jru.mlmsstudent.api.response.QuizPreviewResponse;
import com.jru.mlmsstudent.apioriginal.ResponseHandlerGetQuiz;
import com.jru.mlmsstudent.apioriginal.ResponseHandlerGetQuizzes;
import com.jru.mlmsstudent.apioriginal.ResponseHandlerQuizAnswers;
import com.jru.mlmsstudent.apioriginal.SendQuizAnswers;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("oauth/token")
    Call<LoginResponse> login(@Body LoginRequest request);

    @POST("api/register")
    Call<Void> signup(@Body SignUpRequest request);

    @GET("api/me")
    Call<PersonalDetailsResponse> personalDetails();

    @POST("api/teacher/quizzes")
    Call<QuizCreatorResponse> createQuiz(@Body QuizCreatorRequest request);

    @GET("api/teacher/quizzes")
    Call<QuizPreviewResponse> quizPreview();

    /* Attendance Module Endpoints */

    @POST("someEndpoint")
    void confirmAttendance();

    /* GetQuiz Module Endpoints */

    @GET("api/student/quizzes")
    Call<ResponseHandlerGetQuizzes> getQuizzes();

    @GET("api/quizzes/{quiz}")
    Call<ResponseHandlerGetQuiz> getQuiz(@Query("quiz") long quizId);

    @PUT("api/student/quizzes/{id}")
    Call<ResponseHandlerQuizAnswers> sendQuizAnswers(@Query("id") long quizId,
                                                     @Body SendQuizAnswers sendQuizAnswers);
}
