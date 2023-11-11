package com.example.applicationdesigntestjava.controller.model;

import com.example.applicationdesigntestjava.entity.Room;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class OrderDto {
    private String email;
    private Room room;
    private Date from;
    private Date to;
}
