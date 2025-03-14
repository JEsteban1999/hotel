package com.prueba.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prueba.hotel.entity.Hotel;
import com.prueba.hotel.repository.HotelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public List<Hotel> getHotelsByCity(String city) {
        return hotelRepository.findByCity(city);
    }
}
