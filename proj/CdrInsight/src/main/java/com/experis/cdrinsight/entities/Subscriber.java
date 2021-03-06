package com.experis.cdrinsight.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subscribers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subscriber {
    @Id
    private String msisdn;
    private String imsi;
    private String imei;

}
