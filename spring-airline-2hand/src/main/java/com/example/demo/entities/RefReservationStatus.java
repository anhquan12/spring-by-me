package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ref_reservation_status", schema = "spring_airline_db", catalog = "")
public class RefReservationStatus {
    private int code;
    private String reservationStatusDescription;
    private Set<Reservation> reservationsByCode;

    @Id
    @Column(name = "code")
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Basic
    @Column(name = "reservation_status_description")
    public String getReservationStatusDescription() {
        return reservationStatusDescription;
    }

    public void setReservationStatusDescription(String reservationStatusDescription) {
        this.reservationStatusDescription = reservationStatusDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RefReservationStatus that = (RefReservationStatus) o;
        return code == that.code &&
                Objects.equals(reservationStatusDescription, that.reservationStatusDescription);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code, reservationStatusDescription);
    }

    @OneToMany(mappedBy = "refReservationStatusByReservationStatusCode")
    public Set<Reservation> getReservationsByCode() {
        return reservationsByCode;
    }

    public void setReservationsByCode(Set<Reservation> reservationsByCode) {
        this.reservationsByCode = reservationsByCode;
    }
}
