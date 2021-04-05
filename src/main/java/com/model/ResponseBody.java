package com.model;

import java.util.ArrayList;
import java.util.List;

public class ResponseBody {

    private String submissionUrl;
    private List<Item> jobs = new ArrayList<>();

    public String getSubmissionUrl() {
        return submissionUrl;
    }

    public void setSubmissionUrl(String submissionUrl) {
        this.submissionUrl = submissionUrl;
    }

    public List<Item> getJobs() {
        return jobs;
    }

    public void setJobs(List<Item> jobs) {
        this.jobs = jobs;
    }
}
