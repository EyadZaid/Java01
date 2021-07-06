package com.experis.cdrinsightclient.logic;

public interface IInputData {
    String readline();

    Boolean isEnd();

    void close();
}
