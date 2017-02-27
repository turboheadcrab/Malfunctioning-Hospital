package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * POJO специальности врача
 */

@Entity
@Table(name = "specialties")
public class Specialty implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialty_id", unique = true, nullable = false)
    private Integer specialtyId;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "specialty")
    private Set<Doctor> doctors = new HashSet<>(0);

    public Specialty() {
    }

    public Integer getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "specialtyId=" + getSpecialtyId() +
                ", name='" + getName() + '\'' +
                ", doctors=" + getDoctors() +
                '}';
    }
}
