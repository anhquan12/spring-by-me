package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ref_payment_methods", schema = "spring_airline_db", catalog = "")
public class RefPaymentMethod {
    private int code;
    private int paymentMethodDescription;
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
    @Column(name = "payment_method_description")
    public int getPaymentMethodDescription() {
        return paymentMethodDescription;
    }

    public void setPaymentMethodDescription(int paymentMethodDescription) {
        this.paymentMethodDescription = paymentMethodDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RefPaymentMethod that = (RefPaymentMethod) o;
        return code == that.code &&
                paymentMethodDescription == that.paymentMethodDescription;
    }

    @Override
    public int hashCode() {

        return Objects.hash(code, paymentMethodDescription);
    }

    @OneToMany(mappedBy = "refPaymentMethodsByPaymentMethodCode")
    public Set<Reservation> getReservationsByCode() {
        return reservationsByCode;
    }

    public void setReservationsByCode(Set<Reservation> reservationsByCode) {
        this.reservationsByCode = reservationsByCode;
    }
}
