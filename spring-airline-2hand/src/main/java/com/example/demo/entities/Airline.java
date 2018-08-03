package com.example.demo.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "airlines", schema = "spring_airline_db", catalog = "")
public class Airline {
    private int code;
    private String name;
    private String otherDetails;
    private Set<FilghtSchedule> filghtSchedulesByCode;

    @Id
    @Column(name = "code")
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Airline airline = (Airline) o;
        return code == airline.code &&
                Objects.equals(name, airline.name) &&
                Objects.equals(otherDetails, airline.otherDetails);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code, name, otherDetails);
    }

    @OneToMany(mappedBy = "airlinesByAirlineCode")
    public Set<FilghtSchedule> getFilghtSchedulesByCode() {
        return filghtSchedulesByCode;
    }

    public void setFilghtSchedulesByCode(Set<FilghtSchedule> filghtSchedulesByCode) {
        this.filghtSchedulesByCode = filghtSchedulesByCode;
    }
}
