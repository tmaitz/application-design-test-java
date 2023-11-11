package com.example.applicationdesigntestjava.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String email;
    private Room room;
    private Date from;
    private Date to;
}
