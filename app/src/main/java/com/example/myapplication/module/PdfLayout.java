package com.example.myapplication.module;

import java.util.ArrayList;
import java.util.List;

public class PdfLayout {

    private NewsDescription newsDescription;
    private List<NewsDetail> newsDetails;


    public void addNewsDetail(NewsDetail newsDetail){
        if (newsDetail == null){
            return;
        }

        if (newsDetails == null){
            newsDetails = new ArrayList<>();
        }

        newsDetails.add(newsDetail);
    }

    public NewsDescription getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(NewsDescription newsDescription) {
        this.newsDescription = newsDescription;
    }

    public List<NewsDetail> getNewsDetails() {
        return newsDetails;
    }

    public void setNewsDetails(List<NewsDetail> newsDetails) {
        this.newsDetails = newsDetails;
    }
}
