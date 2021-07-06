package com.experis.cdrinsight.logic;

import com.experis.cdrinsight.entities.Bill;
import com.experis.cdrinsight.layout.Cdr;

import java.util.Optional;

public interface CdrService {
    void insertCdr(Cdr cdr);

    Optional<Bill> getBill(String msisdn);
}
