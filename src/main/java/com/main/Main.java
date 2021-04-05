package com.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediator.RESTMediator;
import com.model.Item;
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
        List<Item> items = new ArrayList<>();
        items.addAll(responseBody.getJobs());




        System.out.println(responseBody.getSubmissionUrl());
        System.out.println(responseBody.getJobs());
        System.out.println(items.get(0).getId());
        System.out.println(items.get(1).getData().get(0).get(0).get("value").get("number"));


    }
}
