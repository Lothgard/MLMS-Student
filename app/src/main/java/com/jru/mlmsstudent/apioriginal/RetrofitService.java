package com.jru.mlmsstudent.apioriginal;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface RetrofitService {

    /* CHECKS */
    @GET("./")
    Call<ResponseBody> checkGoogle();

    /* Registration Module Endpoints */
    @POST("api/register")
    Call<ResponseHandlerRegistration> register(@Body SendRegistration registration);

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
