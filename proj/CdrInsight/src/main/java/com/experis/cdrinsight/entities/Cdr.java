package com.experis.cdrinsight.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cdrs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cdr {
    @Id
    private String id;
    private Subscriber subscriber;
    private UsageType usageType;
    private String date;
    private String time;
    private int duration;
    private int bytesReceived;
    private int bytesTransmitted;
    private String partyImsi;
    private String partyMsisdn;
}
