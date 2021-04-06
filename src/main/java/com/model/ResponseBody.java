package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ResponseBody {
    private String submissionURL;
    private List<Job> jobs;

    @JsonProperty("submissionUrl")
    public String getSubmissionURL() { return submissionURL; }
    @JsonProperty("submissionUrl")
    public void setSubmissionURL(String value) { this.submissionURL = value; }

    @JsonProperty("jobs")
    public List<Job> getJobs() { return jobs; }
    @JsonProperty("jobs")
    public void setJobs(List<Job> value) { this.jobs = value; }

    @Override
    public String toString() {
        return "ResponseBody{" +
                "submissionURL='" + submissionURL + '\'' +
                ", jobs=" + jobs +
                '}';
    }
}
