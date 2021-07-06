package com.experis.cdrinsight.logic;

import com.experis.cdrinsight.layout.Cdr;
import com.experis.cdrinsight.logic.fileInput.FileRead;
import com.experis.cdrinsight.logic.fileInput.IDataFormat;
import com.experis.cdrinsight.logic.fileInput.IInputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class CdrFromFileService {

    @Autowired
    private CdrService cdrService;

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
                cdrService.insertCdr(cdr);
            }
            line = inputData.readline();
        }
        inputData.close();
    }

}
