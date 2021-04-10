package com.spreadsheet;

import com.model.Formula;

import java.lang.reflect.Array;

public class Spreadsheet {
    private int[][] spreadSheet;

    public int[][] getSpreadSheet() {
        return spreadSheet;
    }

    public void setSpreadSheet(int[][] spreadSheet) {
        this.spreadSheet = spreadSheet;
    }

    public void getPositionSpreadSheet(String x, String y){
        int xPos = 0;
        int yPos = 0;
        String abcd = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "1234567890";
        Formula reference = new Formula();
        String referenceValue = reference.getReference();

            for (int i = 0; i < abcd.length(); i++) {
                if(referenceValue.equals(abcd)){
                    xPos = i + xPos;
                    for (int j = 0; j < numbers.length(); j++) {
                        if(referenceValue.equals(numbers)){
                            yPos = i + yPos;
                }
            }
        }
    }  int [][] spreadsheetTemplate = new int[xPos][yPos];
}
}

