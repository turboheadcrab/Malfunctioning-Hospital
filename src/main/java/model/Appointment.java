package model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * POJO приёма пациента у врача
 */

@Entity
@Table(name = "appointments")
public class Appointment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id", unique = true, nullable = false)
    private Integer appointmentId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(name = "room_number", nullable = false)
    private Integer roomNumber;

    @Column(name = "from_date_time")
    private LocalDateTime fromDateTime;

    @Column(name = "to_date_time")
    private LocalDateTime toDateTime;

    public Appointment() {
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDateTime getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(LocalDateTime fromDate) {
        this.fromDateTime = fromDate;
    }

    public LocalDateTime getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(LocalDateTime toDate) {
        this.toDateTime = toDate;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + getAppointmentId() +
                ", client=" + getClient() +
                ", doctor=" + getDoctor() +
                ", roomNumber=" + getRoomNumber() +
                ", fromDateTime=" + getFromDateTime() +
                ", toDateTime=" + getToDateTime() +
                '}';
    }
}
