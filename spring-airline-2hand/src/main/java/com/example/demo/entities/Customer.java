package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customers", schema = "spring_airline_db", catalog = "")
public class Customer {
    private int id;
    private String customerName;
    private String otherDetails;
    private Set<Reservation> reservationsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "customer_name")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "other_details")
    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(customerName, customer.customerName) &&
                Objects.equals(otherDetails, customer.otherDetails);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, customerName, otherDetails);
    }

    @OneToMany(mappedBy = "customersByCustomerId")
    public Set<Reservation> getReservationsById() {
        return reservationsById;
    }

    public void setReservationsById(Set<Reservation> reservationsById) {
        this.reservationsById = reservationsById;
    }
}
