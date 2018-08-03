package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ref_payment_methods", schema = "spring_airline", catalog = "")
public class RefPaymentMethod {
    private int code;
    private int paymentMethodDescription;
    private Collection<Reservation> reservationsByCode;

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
    public Collection<Reservation> getReservationsByCode() {
        return reservationsByCode;
    }

    public void setReservationsByCode(Collection<Reservation> reservationsByCode) {
        this.reservationsByCode = reservationsByCode;
    }
}
