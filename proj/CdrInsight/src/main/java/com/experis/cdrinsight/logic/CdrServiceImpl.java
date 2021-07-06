package com.experis.cdrinsight.logic;

import com.experis.cdrinsight.entities.*;
import com.experis.cdrinsight.layout.Cdr;
import com.experis.cdrinsight.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Optional<Bill> getBill(String msisdn) {
        return billRepository.findById(msisdn);
    }

    private void insertCallCdr(Cdr cdr, LogItem logItem) {
        CallCdr callCdr = new CallCdr(
                cdr.getSequenceNum(),
                logItem,
                cdr.getDuration(),
                cdr.getPartyImsi(),
                cdr.getPartyMsisdn());

        callRepository.save(callCdr);
        updateSubscriber(cdr);

        var opBill = billRepository.findById(cdr.getMsisdn());
        var bill = opBill.orElseGet(Bill::new);

        if (cdr.getUsageType() == UsageType.MOC) {
            bill.setVoiceOut(bill.getVoiceOut() + cdr.getDuration());
        }
        else {
            if (cdr.getUsageType() == UsageType.MTC) {
                bill.setVoiceIn(bill.getVoiceIn() + cdr.getDuration());
            }
        }
        bill.setMsisdn(cdr.getMsisdn());
        billRepository.save(bill);
    }

    private void insertSmsCdr(Cdr cdr, LogItem logItem) {
        SmsCdr smsCdr = new SmsCdr(
                cdr.getSequenceNum(),
                logItem);

        smsRepository.save(smsCdr);
        updateSubscriber(cdr);

        var opBill = billRepository.findById(cdr.getMsisdn());
        var bill = opBill.orElseGet(Bill::new);

        if (cdr.getUsageType() == UsageType.SMS_MO) {
            bill.setSmsOut(bill.getSmsOut() + 1);
        }
        else {
            if (cdr.getUsageType() == UsageType.MTC) {
                bill.setSmsIn(bill.getSmsIn() + 1);
            }
        }
        bill.setMsisdn(cdr.getMsisdn());
        billRepository.save(bill);
    }

    private void insertDataCdr(Cdr cdr, LogItem logItem) {
        DataCdr dataCdr = new DataCdr(
                cdr.getSequenceNum(),
                logItem,
                cdr.getBytesReceived(),
                cdr.getBytesTransmitted());

        dataRepository.save(dataCdr);
        updateSubscriber(cdr);

        var opBill = billRepository.findById(cdr.getMsisdn());
        var bill = opBill.orElseGet(Bill::new);

        if (cdr.getUsageType() == UsageType.D) {
            bill.setDataIn(bill.getDataIn() + cdr.getBytesReceived());
            bill.setDataOut(bill.getDataOut() + cdr.getBytesTransmitted());
        }
        bill.setMsisdn(cdr.getMsisdn());
        billRepository.save(bill);
    }

    private void updateSubscriber(Cdr cdr) {
        if (! subscriberRepository.findById(cdr.getMsisdn()).isPresent()) {
            Subscriber subscriber = new Subscriber(
                    cdr.getMsisdn(),
                    cdr.getImsi(),
                    cdr.getImei());
            subscriberRepository.save(subscriber);
        }
    }
}
