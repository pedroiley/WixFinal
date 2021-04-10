package com.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediator.RESTMediator;
import com.model.*;
import com.model.formulas.Not;
import com.operators.Operator;
import com.resultsModel.ResultValue;

import javax.xml.transform.Result;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        RESTMediator RM = new RESTMediator();
        String output = RM.getUrlContents("https://www.wix.com/_serverless/hiring-task-spreadsheet-evaluator/jobs?fbclid=IwAR2yC4QgoguJvgObm-d2vH0ptG9SCeWV3CZzV0ZKpUIkxLTsa1IDd8-Z7_0");

        ObjectMapper objectMapper = new ObjectMapper();
        ResponseBody responseBody = objectMapper.readValue(output, ResponseBody.class);
        List<Job> jobs = new ArrayList<>();
        jobs.addAll(responseBody.getJobs());
        System.out.println(jobs);
        List<List<List<Data>>> datas = new ArrayList<>();
        //For jobs.arraylenght add jobs.get(i).getData()
//        datas.add(jobs.get(19).getData());
//        System.out.println(datas);
        for (Job job: jobs) {
            datas.add(job.getData());
        }
        System.out.println(datas);
//        System.out.println(datas.get(0).get(0).get(0));
        Values arrValues[][][] = new Values[21][100][100];
        Values spreadsheet[][] = new Values[100][100];
        List<Double> listOfDoubles = new ArrayList<>();
        List<Boolean> listOfBooleans = new ArrayList<>();
        List<String> listOfText = new ArrayList<>();

        for (List<List<Data>> data: datas ) {

            int i = 0;
            int j = 0;
            int k = datas.indexOf(data);


            for (i = 0; i<20; i++){
                if(data.get(i).get(j) != null){
                    if(data.get(i).get(j).getValue() != null){
                        if(data.get(i).get(j).getValue().getNumber() != null){
                            arrValues[k][i][j] = data.get(i).get(j).getValue();
                            listOfDoubles.add(data.get(i).get(j).getValue().getNumber());
                            i--;
                            j++;
                        }else if(data.get(i).get(j).getValue().getValueBoolean() != null){
                            arrValues[k][i][j] = data.get(i).get(j).getValue();
                            listOfBooleans.add(data.get(i).get(j).getValue().getValueBoolean());
                            i--;
                            j++;
                        }else if(data.get(i).get(j).getValue().getText() != null){
                            arrValues[k][i][j] = data.get(i).get(j).getValue();
                            listOfText.add(data.get(i).get(j).getValue().getText());
                            i--;
                            j++;
                        }

                    }
                    else if(data.get(i).get(j).getFormula()!= null){
                        if(data.get(i).get(j).getFormula().getSum() != null){
                            if(listOfDoubles != null && (listOfBooleans.isEmpty() && listOfText.isEmpty())){

                                sumValues(listOfDoubles);
                                Double resultHolder = sumValues(listOfDoubles);
                                ResultValue result = null;
                                result.setNumber(resultHolder);
                            }else{
                                String errorString = "Types do not match";
                                ResultValue errorResult = null;
                                errorResult.setError(errorString);
                            }

                        }

                    }
                }


            }

        }

        //Aqui tendremos una lista de todos los datas. Siguiente paso es meter esos datas, individuales, en un
        //array de dos dimensiones para poder localizar a cada data individual por su coordenada. for datas.get(i).get(j)
        // if datas.get(i).get(j) != null ----- j++ y i-- y anadir datas.get(i).get(j) en array ij
        // asi cuando sume a i luego, pues como hemos restado seguira en el mismo con una j mas
        // else datas.get(i).get(j) == null pues j=0 asi suma a i uno mas y empieza j de cero
        // una vez se encuentra el objeto con su "i" y su "j", se añade el objeto al array con ese mismo
        // "i" y "j" --- Array arr[i][j] = objectCreated
        //o que anada los objetos cuando son de value a una lista y cuando el siguiente objeto sea formula
        // haga la formula con la lista. Luego borras todos los items de la lista y va al siguiente
        //el resultado se guarda en una lista tb y en un objeto de resultado?



//        System.out.println(datas.get(0).get(0));
//        System.out.println(datas.get(0).get(0).get(0));

//        //Print job 3
//        System.out.println(jobs.get(3).getData());
//        //Print values from job 3
//        System.out.println(jobs.get(3).getData().get(0).get(0).getValue().getNumber());
//        System.out.println( jobs.get(3).getData().get(0).get(1).getValue().getNumber());
//        //Print references from job 3
//        System.out.println(jobs.get(3).getData().get(0).get(2).getFormula().getSum().get(0).getReference());
//        System.out.println(jobs.get(3).getData().get(0).get(2).getFormula().getSum().get(1).getReference());
//
//        Double result = jobs.get(3).getData().get(0).get(0).getValue().getNumber() + jobs.get(3).getData().get(0).get(1).getValue().getNumber();
//       List<Not> sum =jobs.get(3).getData().get(0).get(2).getFormula().getSum();
////        System.out.println(sum.get(0) + " and " +  sum.get(1));
////        System.out.println(sum);
//
//        //Initiate a value 0 double variable to save results
//        Double result00 = 0.0;
//
//        //Initiate variables with saved values1 and value2 from job3
//        Double testValue = jobs.get(3).getData().get(0).get(0).getValue().getNumber();
//        Double testValue1 = jobs.get(3).getData().get(0).get(1).getValue().getNumber();
//
//
//
//        List<Double> resultList = new ArrayList<>();
//        if(jobs.get(3).getData().get(0).get(2).getFormula().getSum() != null){
//            System.out.println("suma");
//            Operator op = new Operator("suma");
//            if(op.getOperator() == "suma"){
//
//                  result00 = testValue + testValue1;
//                 resultList.add(result00);
////                System.out.println(result0);
//
//            }
//        }

//        int i = 0;
//        int j = 0;
//        int k = 0;
//        for(i =0 ;i<20; i++){
//        if(jobs.get(i).getData() != null){
//
//            for(j =0 ;j<20; j++){
//            if(jobs.get(i).getData().get(j) != null){
//
//            for(k =0 ;k<20; k++){
//                if(jobs.get(i).getData().get(j).get(k).getValue().getNumber() != null){
//                    Double testTestValue = jobs.get(i).getData().get(j).get(k).getValue().getNumber();
//                }else if(jobs.get(i).getData().get(j).get(k+1).getValue().getNumber() != null){
//                    Double testTestValue2 = jobs.get(i).getData().get(j).get(k+1).getValue().getNumber();
//                }
//            }
//
//            }
//        }}}

//        Double sumResolution = null;
//
//        for (Job job: jobs) {
//            if (job.getData().get(0).get(0).getFormula().getSum() !=null){
//               sumResolution = sumValues(job.getData().get(0).get(0).getValue().getNumber(), job.getData().get(0).get(1).getValue().getNumber());
//
//            }
//
//        }

//        System.out.println(sumResolution);
//
//        if(jobs.get(i).getData().get(j).get(k).getFormula().getSum() != null){
//            System.out.println("suma");
//            Operator op = new Operator("suma");
//            if(op.getOperator() == "suma"){
//
//                result00 = testValue + testValue1;
//                resultList.add(result00);
////                System.out.println(result0);
//
//            }
//        }


//        System.out.println(resultList.get(0));
////
////     double result1 = jobs.get(3).getData().get(0).get(0).getFormula().getTheFormula(result, result2);
////        System.out.println(result1);
//
//        ResultValue resultValue1 = new ResultValue(result00);
//        Double arrDouble[][] = new Double[10][10];
//        arrDouble[0][0] = result00;
//
//
//
//        System.out.println(Arrays.deepToString(arrDouble));



//        Double testValue = jobs.get(3).getData().get(0).get(0).getValue().getNumber();
//        Double testValue1 = jobs.get(3).getData().get(0).get(1).getValue().getNumber();
//        System.out.println(jobs.get(3).getData());
//        System.out.println(testValue);
//        System.out.println(testValue1);
//        System.out.println(testValue + testValue1);

//        System.out.println(jobs);

//        for(int i = 0; i<21 ; i ++){
//          List<List<List<Data>>> dataTest = new ArrayList<>();
//            if (!jobs.get(i).getData().isEmpty()) {
//
//                dataTest.add(jobs.get(i).getData());
//
//            }
//            System.out.println(dataTest);
//            for(int j = 0; j<21 ; j ++){
//                List<Values> valueTest = new ArrayList<>();
//                List<Formula> formulaTest = new ArrayList<>();
//
//                if (!jobs.get(j).getData().isEmpty()) {
//
//                    dataTest.add(jobs.get(j).getData());
//
//                }
//                System.out.println(dataTest);
//            }
//        }





//        System.out.println(jobs);


//        System.out.println(responseBody.getSubmissionURL());
//        System.out.println(responseBody.getJobs());
//        System.out.println(jobs.get(0).getID());
//        System.out.println(jobs.get(1).getData().get(0).get(0).getValue().getNumber());
//        System.out.println(jobs.get(17).getData());


    }

    private static Double sumValues(List<Double> numberArray) {
        Double result = null;
        for (Double number: numberArray) {
            result = +number;

        }
        return result;
    }

    //iterar por los jobs hasta que encuentre el que tiene sum
    // del que tiene sum que extraiga todos los values y los meta en una lista
    //utilizar dicha lista para el metodo sumValues


}

