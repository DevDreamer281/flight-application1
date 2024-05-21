package by.javaguru.je.jdbc.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Ticket {
    private Long id;
    private String passportNumber;
    private String passengerName;
    private Long flightId;
    private String seatNumber;
    private BigDecimal cost;

    public Ticket() {
    }

    public Ticket(
            Long id,
            String passportNumber,
            String passengerName,
            Long flightId,
            String seatNumber,
            BigDecimal cost) {
        this.id = id;
        this.passportNumber = passportNumber;
        this.passengerName = passengerName;
        this.flightId = flightId;
        this.seatNumber = seatNumber;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        return Objects.equals(getId(), ticket.getId()) && Objects.equals(getPassportNumber(), ticket.getPassportNumber()) && Objects.equals(getPassengerName(), ticket.getPassengerName()) && Objects.equals(getFlightId(), ticket.getFlightId()) && Objects.equals(getSeatNumber(), ticket.getSeatNumber()) && Objects.equals(getCost(), ticket.getCost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPassportNumber(), getPassengerName(), getFlightId(), getSeatNumber(), getCost());
    }

    @Override
    public String toString() {
        return "Ticket{" +
               "id=" + id +
               ", passportNumber='" + passportNumber + '\'' +
               ", passengerName='" + passengerName + '\'' +
               ", flightId=" + flightId +
               ", seatNumber='" + seatNumber + '\'' +
               ", cost=" + cost +
               '}';
    }
}
