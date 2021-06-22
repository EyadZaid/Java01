package com.experis.cdrinsight.logic.fileInput;

public interface IInputData {
    String readline();

    Boolean isEnd();

    void close();
}
