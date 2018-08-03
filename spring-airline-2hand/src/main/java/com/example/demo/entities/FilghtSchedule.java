package com.example.demo.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "filght_schedules", schema = "spring_airline", catalog = "")
public class FilghtSchedule {
    private int id;
    private Timestamp arrivalTime;
    private Timestamp departureTime;
    private int filghtNumber;
    private String otherDetails;
    private int airlineCode;
    private Airline airlinesByAirlineCode;
    private Collection<Reservation> reservationsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "arrival_time")
    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Basic
    @Column(name = "departure_time")
    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    @Basic
    @Column(name = "filght_number")
    public int getFilghtNumber() {
        return filghtNumber;
    }

    public void setFilghtNumber(int filghtNumber) {
        this.filghtNumber = filghtNumber;
    }

    @Basic
    @Column(name = "other_details")
    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    @Basic
    @Column(name = "airline_code")
    public int getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(int airlineCode) {
        this.airlineCode = airlineCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilghtSchedule that = (FilghtSchedule) o;
        return id == that.id &&
                filghtNumber == that.filghtNumber &&
                airlineCode == that.airlineCode &&
                Objects.equals(arrivalTime, that.arrivalTime) &&
                Objects.equals(departureTime, that.departureTime) &&
                Objects.equals(otherDetails, that.otherDetails);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, arrivalTime, departureTime, filghtNumber, otherDetails, airlineCode);
    }

    @ManyToOne
    @JoinColumn(name = "airline_code", referencedColumnName = "code", nullable = false , insertable = false , updatable = false)
    public Airline getAirlinesByAirlineCode() {
        return airlinesByAirlineCode;
    }

    public void setAirlinesByAirlineCode(Airline airlinesByAirlineCode) {
        this.airlinesByAirlineCode = airlinesByAirlineCode;
    }

    @OneToMany(mappedBy = "filghtSchedulesByScheduleId")
    public Collection<Reservation> getReservationsById() {
        return reservationsById;
    }

    public void setReservationsById(Collection<Reservation> reservationsById) {
        this.reservationsById = reservationsById;
    }
}
