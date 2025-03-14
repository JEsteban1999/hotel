package com.prueba.hotel.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.hotel.entity.Reservation;

import jakarta.persistence.LockModeType;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE) // Bloqueo pesimista
    @Query("SELECT r FROM Reservation r WHERE r.room.id = :roomId AND r.checkInDate <= :checkOutDate AND r.checkOutDate >= :checkInDate")
    List<Reservation> findConflictingReservations(
        @Param("roomId") Long roomId,
        @Param("checkInDate") LocalDate checkInDate,
        @Param("checkOutDate") LocalDate checkOutDate);
}
