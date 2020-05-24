package carRent.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = false, nullable = false)
    private LocalDateTime startDate;

    @Column(unique = false, nullable = false)
    private LocalDateTime endDate;

    @Column(name = "state", nullable = false)
    private RequestState state;

    @Column(name = "place", nullable = false)
    private String place;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @ElementCollection
    private List<Long> cars = new ArrayList<>();

    @Column(name = "loaner", nullable = false)
    private Long loaner;

    public Booking() {

    }

    public Booking(LocalDateTime startDate, LocalDateTime endDate, RequestState requestState, String place, LocalDateTime created, Long car, Long user) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = requestState;
        this.place = place;
        this.created = created;
        this.cars.add(car);
        this.loaner = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public RequestState getState() {
        return state;
    }

    public void setState(RequestState requestState) {
        this.state = requestState;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public List<Long> getCars() {
        return cars;
    }

    public void setCars(List<Long> cars) {
        this.cars = cars;
    }

    public Long getLoaner() {
        return loaner;
    }

    public void setLoaner(Long loaner) {
        this.loaner = loaner;
    }
}
