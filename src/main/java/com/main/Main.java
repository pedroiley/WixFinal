package com.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediator.RESTMediator;
import com.model.Job;
import com.model.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        RESTMediator RM = new RESTMediator();
        String output = RM.getUrlContents("https://www.wix.com/_serverless/hiring-task-spreadsheet-evaluator/jobs?fbclid=IwAR2yC4QgoguJvgObm-d2vH0ptG9SCeWV3CZzV0ZKpUIkxLTsa1IDd8-Z7_0");

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseBody responseBody = objectMapper.readValue(output, ResponseBody.class);
        List<Job> jobs = new ArrayList<>();
        jobs.addAll(responseBody.getJobs());




        System.out.println(responseBody.getSubmissionURL());
        System.out.println(responseBody.getJobs());
        System.out.println(jobs.get(0).getID());
        System.out.println(jobs.get(1).getData().get(0).get(0).getValue().getNumber());
        System.out.println(jobs.get(17).getData().get(0).get(0));


    }
}
