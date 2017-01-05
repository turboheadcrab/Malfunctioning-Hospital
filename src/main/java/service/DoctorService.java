package service;


import model.Doctor;

import java.util.List;

public interface DoctorService {

    void delete(long id);

    Doctor find(long id);

    List<Doctor> findAll();

    long save(Doctor doctor);

    void update(Doctor doctor);

//    void setSpecialty(Doctor doctor, Specialty specialty);
}
