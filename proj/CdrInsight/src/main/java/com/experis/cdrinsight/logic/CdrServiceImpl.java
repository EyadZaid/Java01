package com.experis.cdrinsight.logic;

import com.experis.cdrinsight.entities.CallCdr;
import com.experis.cdrinsight.entities.DataCdr;
import com.experis.cdrinsight.entities.LogItem;
import com.experis.cdrinsight.entities.SmsCdr;
import com.experis.cdrinsight.layout.Cdr;
import com.experis.cdrinsight.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CdrServiceImpl implements CdrService {
    private final CallCdrRepository callRepository;
    private final SmsCdrRepository smsRepository;
    private final DataCdrRepository dataRepository;
    private final SubscriberRepository subscriberRepository;
    private final BillRepository billRepository;

    @Autowired
    public CdrServiceImpl(CallCdrRepository callRepository, SmsCdrRepository smsRepository,
                          DataCdrRepository dataRepository, BillRepository billRepository,
                          SubscriberRepository subscriberRepository) {
        this.callRepository = callRepository;
        this.smsRepository = smsRepository;
        this.dataRepository = dataRepository;
        this.subscriberRepository = subscriberRepository;
        this.billRepository = billRepository;
    }

    @Override
    public void insertCdr(Cdr cdr) {
        LogItem logItem = new LogItem(
                cdr.getMsisdn(),
                cdr.getUsageType(),
                cdr.getDate());

        switch (cdr.getUsageType()) {
            case MOC:
            case MTC:
            case U:
            case B:
            case X:
                insertCallCdr(cdr, logItem);
                break;

            case SMS_MO:
            case SMS_MT:
                insertSmsCdr(cdr, logItem);
                break;

            case D:
                insertDataCdr(cdr, logItem);
                break;
        }
    }

    private void insertCallCdr(Cdr cdr, LogItem logItem) {
        CallCdr callCdr = new CallCdr(
                cdr.getSequenceNum(),
                logItem,
                cdr.getDuration(),
                cdr.getPartyImsi(),
                cdr.getPartyMsisdn());

        callRepository.save(callCdr);
        /// To do: update bill and subscriber
    }

    private void insertSmsCdr(Cdr cdr, LogItem logItem) {
        SmsCdr smsCdr = new SmsCdr(
                cdr.getSequenceNum(),
                logItem);

        smsRepository.save(smsCdr);
        /// To do: update bill and subscriber
    }

    private void insertDataCdr(Cdr cdr, LogItem logItem) {
        DataCdr dataCdr = new DataCdr(
                cdr.getSequenceNum(),
                logItem,
                cdr.getBytesReceived(),
                cdr.getBytesTransmitted());

        dataRepository.save(dataCdr);
        /// To do: update bill and subscriber
    }
}
