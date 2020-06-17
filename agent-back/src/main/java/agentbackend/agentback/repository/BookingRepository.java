package agentbackend.agentback.repository;

import agentbackend.agentback.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    ArrayList<Booking> findAllByLoaner(Long id);
    ArrayList<Booking> findAllByAd(Long id);
}
