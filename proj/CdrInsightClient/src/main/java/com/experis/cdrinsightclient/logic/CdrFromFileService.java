package com.experis.cdrinsightclient.logic;

import com.experis.cdrinsightclient.model.Cdr;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class CdrFromFileService {

    public void insertCdrsToDB(String fileName, IDataFormat dataFormat) throws FileNotFoundException {
        IInputData inputData = new FileRead(fileName);
        String line;
        Cdr cdr = null;

        inputData.readline();
        if (inputData.isEnd()){
            return;
        }
        line = inputData.readline();
        while (!inputData.isEnd()){
            try {
                cdr = dataFormat.inputParse(line);
            } catch (IllegalDataFormatException e) {
                e.printStackTrace();
            }
            if (cdr != null){
                System.out.println(cdr);
            }
            line = inputData.readline();
        }
        inputData.close();
    }
}
