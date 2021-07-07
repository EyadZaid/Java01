package com.experis.cdrinsightclient.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

