package com.experis.cdrinsight.logic.fileInput;

import com.experis.cdrinsight.entities.UsageType;
import com.experis.cdrinsight.layout.Cdr;
import com.experis.cdrinsight.logic.IllegalDataFormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class InputParser implements IDataFormat {

    @Override
    public Cdr inputParse(String line) throws IllegalDataFormatException {

        String[] details = line.split("\\|");
        if (details.length != 12){
            throw new IllegalDataFormatException("Invalid file format");
        }

        String SequenceNum = details[0];
        String imsi = details[1];
        String imei = details[2];
        UsageType usageType = UsageType.valueOf(details[3]);
        String msisdn = details[4];

        // --------------  To do: Function
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss", Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));

        String dateInString = details[5] + details[6];
        Date date = null;
        try {
            date = formatter.parse(dateInString);
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
