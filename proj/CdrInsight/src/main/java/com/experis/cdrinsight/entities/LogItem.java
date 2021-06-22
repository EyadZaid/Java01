package com.experis.cdrinsight.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogItem {
    private String msisdn;
    private UsageType usageType;
    private Date date;
}
