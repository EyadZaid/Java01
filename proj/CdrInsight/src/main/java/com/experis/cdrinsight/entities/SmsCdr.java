package com.experis.cdrinsight.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SmsCdr {
    @Id
    private String id;
    private LogItem logItem;
}
