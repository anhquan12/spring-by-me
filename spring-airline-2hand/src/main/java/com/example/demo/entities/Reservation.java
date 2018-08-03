package com.example.demo.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "reservations", schema = "spring_airline", catalog = "")
public class Reservation {
    private int id;
    private String customerName;
    private Timestamp dateOfFilght;
    private Timestamp dateReservationMade;
    private int ticketNumber;
    private int customerId;
    private int scheduleId;
    private int classNumber;
    private int paymentMethodCode;
    private int reservationStatusCode;
    private String otherDetails;
    private Customer customersByCustomerId;
    private FilghtSchedule filghtSchedulesByScheduleId;
    private RefClass refClassesByClassNumber;
    private RefPaymentMethod refPaymentMethodsByPaymentMethodCode;
    private RefReservationStatus refReservationStatusByReservationStatusCode;

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
    @Column(name = "date_of_filght")
    public Timestamp getDateOfFilght() {
        return dateOfFilght;
    }

    public void setDateOfFilght(Timestamp dateOfFilght) {
        this.dateOfFilght = dateOfFilght;
    }

    @Basic
    @Column(name = "date_reservation_made")
    public Timestamp getDateReservationMade() {
        return dateReservationMade;
    }

    public void setDateReservationMade(Timestamp dateReservationMade) {
        this.dateReservationMade = dateReservationMade;
    }

    @Basic
    @Column(name = "ticket_number")
    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Basic
    @Column(name = "customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "schedule_id")
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Basic
    @Column(name = "class_number")
    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    @Basic
    @Column(name = "payment_method_code")
    public int getPaymentMethodCode() {
        return paymentMethodCode;
    }

    public void setPaymentMethodCode(int paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }

    @Basic
    @Column(name = "reservation_status_code")
    public int getReservationStatusCode() {
        return reservationStatusCode;
    }

    public void setReservationStatusCode(int reservationStatusCode) {
        this.reservationStatusCode = reservationStatusCode;
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
        Reservation that = (Reservation) o;
        return id == that.id &&
                ticketNumber == that.ticketNumber &&
                customerId == that.customerId &&
                scheduleId == that.scheduleId &&
                classNumber == that.classNumber &&
                paymentMethodCode == that.paymentMethodCode &&
                reservationStatusCode == that.reservationStatusCode &&
                Objects.equals(customerName, that.customerName) &&
                Objects.equals(dateOfFilght, that.dateOfFilght) &&
                Objects.equals(dateReservationMade, that.dateReservationMade) &&
                Objects.equals(otherDetails, that.otherDetails);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, customerName, dateOfFilght, dateReservationMade, ticketNumber, customerId, scheduleId, classNumber, paymentMethodCode, reservationStatusCode, otherDetails);
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false , insertable = false , updatable = false)
    public Customer getCustomersByCustomerId() {
        return customersByCustomerId;
    }

    public void setCustomersByCustomerId(Customer customersByCustomerId) {
        this.customersByCustomerId = customersByCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "id", nullable = false , insertable = false , updatable = false)
    public FilghtSchedule getFilghtSchedulesByScheduleId() {
        return filghtSchedulesByScheduleId;
    }

    public void setFilghtSchedulesByScheduleId(FilghtSchedule filghtSchedulesByScheduleId) {
        this.filghtSchedulesByScheduleId = filghtSchedulesByScheduleId;
    }

    @ManyToOne
    @JoinColumn(name = "class_number", referencedColumnName = "class_number", nullable = false, insertable = false , updatable = false)
    public RefClass getRefClassesByClassNumber() {
        return refClassesByClassNumber;
    }

    public void setRefClassesByClassNumber(RefClass refClassesByClassNumber) {
        this.refClassesByClassNumber = refClassesByClassNumber;
    }

    @ManyToOne
    @JoinColumn(name = "payment_method_code", referencedColumnName = "code", nullable = false , insertable = false , updatable = false)
    public RefPaymentMethod getRefPaymentMethodsByPaymentMethodCode() {
        return refPaymentMethodsByPaymentMethodCode;
    }

    public void setRefPaymentMethodsByPaymentMethodCode(RefPaymentMethod refPaymentMethodsByPaymentMethodCode) {
        this.refPaymentMethodsByPaymentMethodCode = refPaymentMethodsByPaymentMethodCode;
    }

    @ManyToOne
    @JoinColumn(name = "reservation_status_code", referencedColumnName = "code", nullable = false, insertable = false , updatable = false)
    public RefReservationStatus getRefReservationStatusByReservationStatusCode() {
        return refReservationStatusByReservationStatusCode;
    }

    public void setRefReservationStatusByReservationStatusCode(RefReservationStatus refReservationStatusByReservationStatusCode) {
        this.refReservationStatusByReservationStatusCode = refReservationStatusByReservationStatusCode;
    }
}
