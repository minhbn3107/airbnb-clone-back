package fr.codecake.airbnb_clone_back.booking.repository;

import fr.codecake.airbnb_clone_back.booking.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
