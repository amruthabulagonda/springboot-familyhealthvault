package com.health.familyhealthvault.entity;

import com.google.cloud.Timestamp;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Record {
    private String documentId;
    private String name;
    private String reason;
    private Date date;
}
