package com.jru.mlmsstudent.apioriginal;

import com.google.gson.annotations.SerializedName;

public class ResponseHandlerGetQuizzes {

    @SerializedName("current_page")
    private int currentPage;

    private QuizData data;

    @SerializedName("first_page_url")
    private String firstPageUrl;

    private int from;

    @SerializedName("last_page")
    private int lastPage;

    @SerializedName("last_page_url")
    private String lastPageUrl;

    @SerializedName("next_page_url")
    private String nextPageUrl;

    private String path;

    @SerializedName("per_page")
    private int perPage;

    @SerializedName("prev_page_url")
    private String prevPageUrl;

    private int to;

    private int total;

    public ResponseHandlerGetQuizzes(int currentPage, QuizData data, String firstPageUrl, int from, int lastPage, String lastPageUrl, String nextPageUrl, String path, int perPage, String prevPageUrl, int to, int total) {
        this.currentPage = currentPage;
        this.data = data;
        this.firstPageUrl = firstPageUrl;
        this.from = from;
        this.lastPage = lastPage;
        this.lastPageUrl = lastPageUrl;
        this.nextPageUrl = nextPageUrl;
        this.path = path;
        this.perPage = perPage;
        this.prevPageUrl = prevPageUrl;
        this.to = to;
        this.total = total;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public QuizData getData() {
        return data;
    }

    public String getFirstPageUrl() {
        return firstPageUrl;
    }

    public int getFrom() {
        return from;
    }

    public int getLastPage() {
        return lastPage;
    }

    public String getLastPageUrl() {
        return lastPageUrl;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public String getPath() {
        return path;
    }

    public int getPerPage() {
        return perPage;
    }

    public String getPrevPageUrl() {
        return prevPageUrl;
    }

    public int getTo() {
        return to;
    }

    public int getTotal() {
        return total;
    }
}
