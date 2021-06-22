package com.experis.cdrinsight.logic.fileInput;

import com.experis.cdrinsight.layout.Cdr;
import com.experis.cdrinsight.logic.IllegalDataFormatException;

public interface IDataFormat {

    Cdr inputParse(String line) throws IllegalDataFormatException;
}
