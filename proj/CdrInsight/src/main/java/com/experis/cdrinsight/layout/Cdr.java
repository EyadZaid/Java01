package com.experis.cdrinsight.layout;

import com.experis.cdrinsight.entities.UsageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cdr {
    private String SequenceNum;
    private String imsi;
    private String imei;
    private UsageType usageType;
    private String msisdn;
    private Date date;
    private int duration;
    private long bytesReceived;
    private long bytesTransmitted;
    private String partyImsi;
    private String partyMsisdn;
}
