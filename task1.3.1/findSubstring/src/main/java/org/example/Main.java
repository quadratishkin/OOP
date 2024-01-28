package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    public static void main(String[] args)
    {
        boolean isFound = false;
        long place = 0;
        String filePath = "C:\\Users\\nikit\\IdeaProjects\\findSubstring\\src\\main\\resources\\test.txt";
        BufferedReader br;
        String inputSearch = "car";
        String line = "";

        try {
            br = new BufferedReader(new FileReader(filePath));
            try {
                while(((line = br.readLine()) != null) && (isFound == false))
                {
                    if (line.contains(inputSearch)) {
                        isFound = true;
                        place += line.indexOf(inputSearch);
                    }else{
                        place += line.length();
                    }
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(isFound){
            System.out.println("Word found at--"+place);
        }else{
            System.out.println("nothing is found ");
        }

    }
}