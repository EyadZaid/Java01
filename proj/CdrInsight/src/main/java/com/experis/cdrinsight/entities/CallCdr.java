package com.experis.cdrinsight.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "calls")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CallCdr {
    @Id
    private String id;
    private LogItem logItem;
    private int duration;
    private String partyImsi;
    private String partyMsisdn;
}
