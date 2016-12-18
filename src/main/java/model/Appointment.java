package model;

import dao.Identifiable;

import java.time.LocalDate;

/**
 * Created by Apraxin Vladimir on 15.12.16.
 */
public class Appointment implements Identifiable<Long> {

    private final Long id;
    private final User user;
    private final Doctor doctor;
    private final int roomNumber;
    private final LocalDate fromDate;
    private final LocalDate toDate;

    public class Builder {

        private Long id;
        private User user;
        private Doctor doctor;
        private int roomNumber;
        private LocalDate fromDate;
        private LocalDate toDate;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        public Builder user(User user) {
            this.user = user;
            return this;
        }
        public Builder doctor(Doctor doctor) {
            this.doctor = doctor;
            return this;
        }
        public Builder roomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }
        public Builder fromDate(LocalDate fromDate) {
            this.fromDate = fromDate;
            return this;
        }
        public Builder toDate(LocalDate toDate) {
            this.toDate = toDate;
            return this;
        }


        public Appointment build() {
            return new Appointment(this);
        }
    }

    private Appointment(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.doctor = builder.doctor;
        this.roomNumber = builder.roomNumber;
        this.fromDate = builder.fromDate;
        this.toDate = builder.toDate;
    }

    @Override
    public Long getPrimaryKey() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public LocalDate getFromDate() {
        return fromDate;
    }
    public LocalDate getToDate() {
        return toDate;
    }
}
