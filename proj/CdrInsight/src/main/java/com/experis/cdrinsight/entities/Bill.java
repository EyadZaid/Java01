package com.experis.cdrinsight.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bills")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    @Id
    private String msisdn;
    private int voiceOut;
    private int voiceIn;
    private int dataOut;
    private int dataIn;
    private int smsOut;
    private int smsIn;
}
