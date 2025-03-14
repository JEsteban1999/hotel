package com.prueba.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.prueba.hotel.entity.Room;
import com.prueba.hotel.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public List<Room> getRoomsByHotelAndType(Long hotelId, String type) {
        return roomRepository.findByHotelIdAndType(hotelId, type);
    }
}
