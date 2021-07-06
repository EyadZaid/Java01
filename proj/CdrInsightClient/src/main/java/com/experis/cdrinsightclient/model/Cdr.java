package com.experis.cdrinsightclient.model;

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
    private int bytesReceived;
    private int bytesTransmitted;
    private String partyImsi;
    private String partyMsisdn;
}

