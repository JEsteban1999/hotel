package com.prueba.hotel.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.hotel.entity.Room;
import com.prueba.hotel.service.RoomService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public List<Room> getRoomsByHotelAndType(@RequestParam Long hotelId, @RequestParam String type) {
        return roomService.getRoomsByHotelAndType(hotelId, type);
    }
}
