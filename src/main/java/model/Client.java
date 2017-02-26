package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * POJO пациента
 */

@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", unique = true, nullable = false)
    private Integer clientId;

    @Column(name = "username", unique = true, nullable = false, length = 20)
    private String username;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "patronymic", nullable = false, length = 50)
    private String patronymic;

    @Column(name = "health_insurance", unique = true, nullable = false, length = 16)
    private String healthInsurance;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    private Set<Appointment> appointments = new HashSet<>(0);

    public Client() {
    }

    public Client(String username, String password, String lastName, String firstName,
                  String patronymic, String healthInsurance) {
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.healthInsurance = healthInsurance;
    }

    public Client(Integer clientId, String username, String password, String lastName, String firstName,
                  String patronymic, String healthInsurance, Set<Appointment> appointments) {
        this.clientId = clientId;
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.healthInsurance = healthInsurance;
        this.appointments = appointments;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(String healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + getClientId() +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", patronymic='" + getPatronymic() + '\'' +
                ", healthInsurance='" + getHealthInsurance() + '\'' +
                ", appointments=" + getAppointments() +
                '}';
    }
}
