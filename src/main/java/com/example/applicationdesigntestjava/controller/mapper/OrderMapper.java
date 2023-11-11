package com.example.applicationdesigntestjava.controller.mapper;

import com.example.applicationdesigntestjava.controller.model.OrderDto;
import com.example.applicationdesigntestjava.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order mapDtoToEntity(OrderDto orderDto) {
        return Order.builder()
                .email(orderDto.getEmail())
                .room(orderDto.getRoom())
                .from(orderDto.getFrom())
                .to(orderDto.getTo())
                .build();
    }

}
