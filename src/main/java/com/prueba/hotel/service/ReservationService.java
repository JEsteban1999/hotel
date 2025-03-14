package com.prueba.hotel.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import com.prueba.hotel.entity.Reservation;
import com.prueba.hotel.entity.Room;
import com.prueba.hotel.repository.ReservationRepository;
import com.prueba.hotel.repository.RoomRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    @Transactional
    public Reservation createReservation(Reservation reservation) {
        // Verifica que el objeto Room esté presente en la reserva
        if (reservation.getRoom() == null || reservation.getRoom().getId() == null) {
            throw new IllegalArgumentException("La habitación no puede ser nula.");
        }

        // Busca la habitación en la base de datos
        Room room = roomRepository.findById(reservation.getRoom().getId())
            .orElseThrow(() -> new IllegalArgumentException("Habitación no encontrada."));

        // Asigna la habitación a la reserva
        reservation.setRoom(room);

        // Verifica la disponibilidad de la habitación
        List<Reservation> conflictingReservations = reservationRepository.findConflictingReservations(
            room.getId(),
            reservation.getCheckInDate(),
            reservation.getCheckOutDate()
        );

        if (!conflictingReservations.isEmpty()) {
            throw new RuntimeException("La habitación no está disponible en las fechas seleccionadas.");
        }

        // Guarda la reserva
        return reservationRepository.save(reservation);
    }
}
