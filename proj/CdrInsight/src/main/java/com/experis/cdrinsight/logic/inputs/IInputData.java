package com.experis.cdrinsight.logic.inputs;

public interface IInputData {
    String readline();

    Boolean isEnd();

    void close();
}
