package com.experis.cdrinsightclient.logic;

import com.experis.cdrinsightclient.model.Cdr;
import com.experis.cdrinsightclient.model.UsageType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputParser implements IDataFormat {

    @Override
    public Cdr inputParse(String line) throws IllegalDataFormatException {

        String[] details = line.split("\\|", -1);
        if (details.length != 12){
            throw new IllegalDataFormatException("Invalid file format");
        }

        String SequenceNum = details[0];
        String imsi = details[1];
        String imei = details[2];

        UsageType usageType;
        switch (details[3]) {
            case "SMS-MT": usageType = UsageType.SMS_MT;
            break;

            case "SMS-O": usageType = UsageType.SMS_MO;
            break;

            default: usageType = UsageType.valueOf(details[3]);
        }

        String msisdn = details[4];

        // --------------  To do: Function
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String dateInString = details[5] + " " + details[6];
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //----------------------------------------------

        int duration = Integer.parseInt(details[7]);
        int bytesReceived = Integer.parseInt(details[8]);
        int bytesTransmitted = Integer.parseInt(details[9]);;
        String partyImsi = details[10];
        String partyMsisdn = details[11];

        return new Cdr(SequenceNum, imsi, imei, usageType, msisdn, date, duration, bytesReceived, bytesTransmitted,
                partyImsi, partyMsisdn);
    }
}
