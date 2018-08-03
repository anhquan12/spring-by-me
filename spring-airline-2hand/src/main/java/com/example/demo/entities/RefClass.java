package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ref_classes", schema = "spring_airline", catalog = "")
public class RefClass {
    private int classNumber;
    private String classNumberDescription;
    private Collection<Reservation> reservationsByClassNumber;

    @Id
    @Column(name = "class_number")
    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    @Basic
    @Column(name = "class_number_description")
    public String getClassNumberDescription() {
        return classNumberDescription;
    }

    public void setClassNumberDescription(String classNumberDescription) {
        this.classNumberDescription = classNumberDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RefClass refClass = (RefClass) o;
        return classNumber == refClass.classNumber &&
                Objects.equals(classNumberDescription, refClass.classNumberDescription);
    }

    @Override
    public int hashCode() {

        return Objects.hash(classNumber, classNumberDescription);
    }

    @OneToMany(mappedBy = "refClassesByClassNumber")
    public Collection<Reservation> getReservationsByClassNumber() {
        return reservationsByClassNumber;
    }

    public void setReservationsByClassNumber(Collection<Reservation> reservationsByClassNumber) {
        this.reservationsByClassNumber = reservationsByClassNumber;
    }
}
