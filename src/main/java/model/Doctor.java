package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * POJO врача
 */

@Entity
@Table(name = "doctors")
public class Doctor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id", unique = true, nullable = false)
    private Integer doctorId;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "patronymic", nullable = false, length = 50)
    private String patronymic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "specialty_id", nullable = false)
    private Specialty specialty;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "doctor")
    private Set<Appointment> appointments = new HashSet<>(0);

    public Doctor() {
    }

    public Doctor(Integer doctorId, String lastName, String firstName, String patronymic, Specialty specialty) {
        this.doctorId = doctorId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.specialty = specialty;
    }

    public Doctor(Integer doctorId, String lastName, String firstName, String patronymic, Specialty specialty,
                  Set<Appointment> appointments) {
        this.doctorId = doctorId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.specialty = specialty;
        this.appointments = appointments;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + getDoctorId() +
                ", lastName='" + getLastName() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", patronymic='" + getPatronymic() + '\'' +
                ", specialty=" + getSpecialty() +
                ", appointments=" + getAppointments() +
                '}';
    }
}
