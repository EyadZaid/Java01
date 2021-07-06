package com.experis.cdrinsightclient.logic;


import com.experis.cdrinsightclient.model.Cdr;

public interface IDataFormat {

    Cdr inputParse(String line) throws IllegalDataFormatException;
}
