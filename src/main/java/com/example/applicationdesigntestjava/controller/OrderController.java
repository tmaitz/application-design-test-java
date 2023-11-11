package com.example.applicationdesigntestjava.controller;

import com.example.applicationdesigntestjava.controller.mapper.OrderMapper;
import com.example.applicationdesigntestjava.controller.model.OrderDto;
import com.example.applicationdesigntestjava.entity.Order;
import com.example.applicationdesigntestjava.exception.DateFromToException;
import com.example.applicationdesigntestjava.exception.RoomNotAvailableException;
import com.example.applicationdesigntestjava.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/orders")
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    public Order create(@RequestBody OrderDto orderDto) throws DateFromToException, RoomNotAvailableException {
        log.debug("Get create request with params {}", orderDto);
        if (!orderDto.getFrom().before(orderDto.getTo())) {
            log.error("Error while creating new order, from date must be before to date");
            throw new DateFromToException("Error while creating new order, from date must be before to date");
        }
        return orderService.createOrder(orderMapper.mapDtoToEntity(orderDto));
    }

    @GetMapping
    public List<Order> getMappings(@RequestParam(name = "email") String email) {
        return orderService.getOrders(email);
    }

}
