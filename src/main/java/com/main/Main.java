package com.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediator.RESTMediator;
import com.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        //After running our code, the first thing we are doing is getting the data from URL indicated by Wix
        // with the help of the RESTMediator RM --> foldr "mediator"
        RESTMediator RM = new RESTMediator();
        String output = RM.getUrlContents("https://www.wix.com/_serverless/hiring-task-spreadsheet-evaluator/jobs?fbclid=IwAR2yC4QgoguJvgObm-d2vH0ptG9SCeWV3CZzV0ZKpUIkxLTsa1IDd8-Z7_0");
        //Lately we are parsing the Json file with the classes we created --> Can find them in the folder "model"
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseBody responseBody = objectMapper.readValue(output, ResponseBody.class);

        //We will store all our jobs in a list of Job - for easier manipulation of the data.
        List<Job> jobs = new ArrayList<>();
        jobs.addAll(responseBody.getJobs());
        System.out.println(jobs);

        //We will also store all the data objects in a list
        List<List<List<Data>>> datas = new ArrayList<>();

        for (Job job : jobs) {
            datas.add(job.getData());
        }
        System.out.println(datas);


        Values spreadsheet[][] = new Values[10][26];

        // Through the following SOUT, we check how we can go through the different getters to get the info we want
        System.out.println(datas.get(0));
        System.out.println(datas.get(1).get(0).get(0));
        System.out.println(datas.get(1).get(0).get(0).getValue().getNumber());

        //Here we create the logic needed to access every object and be able to make operations with them
        for (List<List<Data>> data : datas) {
            System.out.println(data);
            int k = datas.indexOf(data);
            if (data.isEmpty()) {
                System.out.println("this Object is null");
            }
            if (!data.isEmpty()) {
                System.out.println("This object is not empty");
                System.out.println(k);
                System.out.println(data.size());


                for (int i = 0; i < data.size(); i++) {
                    List<Double> listOfDoubles = new ArrayList<>();
                    List<Boolean> listOfBooleans = new ArrayList<>();
                    List<String> listOfText = new ArrayList<>();
                    System.out.println("I am in the first loop");
                    for (int j = 0; j < data.get(i).size(); j++) {
                        System.out.println("I am in the second loop");
                        System.out.println(data.get(i).get(j));

                        if (data.get(i).get(j).getValue() != null) {
                            if (data.get(i).get(j).getValue().getNumber() != null) {
                                //we store the value in a spreadsheet and we add the number to a list
                                spreadsheet[i][j] = data.get(i).get(j).getValue();
                                listOfDoubles.add(data.get(i).get(j).getValue().getNumber());
                                System.out.println(listOfDoubles);

                            }
                            if (data.get(i).get(j).getValue().getValueBoolean() != null) {
                            }
                            if (data.get(i).get(j).getValue().getText() != null) {
                            }

                        }
                        if (data.get(i).get(j).getFormula() != null) {
                            //When the formula exists, it will use the list for making the operations
                            if (data.get(i).get(j).getFormula().getSum() != null) {
                                sumValues(listOfDoubles);


                            }

                        }
                    }
                }


            }

        }

    }


    private static Double sumValues(List<Double> listOfDoubles) {
        double result = 0;
        for (double number : listOfDoubles) {
            result = result + number;

        }
        System.out.println("this is the result " + result);
        return result;

    }


}


