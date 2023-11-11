package com.example.applicationdesigntestjava.service;

import com.example.applicationdesigntestjava.entity.Order;
import com.example.applicationdesigntestjava.entity.Room;
import com.example.applicationdesigntestjava.exception.RoomNotAvailableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class OrderService {

    private final Map<Room, Boolean> roomAvailabilityMap = new EnumMap<>(Room.class);
    private final List<Order> orders = new ArrayList<>();

    public OrderService() {
        roomAvailabilityMap.put(Room.economy, true);
        roomAvailabilityMap.put(Room.standard, true);
        roomAvailabilityMap.put(Room.lux, true);
    }

    public Order createOrder(Order order) throws RoomNotAvailableException {
        if (!roomAvailabilityMap.get(order.getRoom())) {
            log.warn("There is no available room with type {}", order.getRoom());
            throw new RoomNotAvailableException("There is no available room with type " + order.getRoom());
        }
        orders.add(order);
        return order;
    }

    public List<Order> getOrders(String email) {
        final List<Order> result = new ArrayList<>();
        for (Order order : orders) {
            if (order.getEmail().equalsIgnoreCase(email)) {
                result.add(order);
            }
        }
        return result;
    }

}
