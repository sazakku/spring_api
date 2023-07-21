package com.example.demo.services;

import com.example.demo.models.Doctor;
import com.example.demo.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(long id) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        return optionalDoctor.orElse(null);
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(long id, Doctor updatedDoctor) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            doctor.setName(updatedDoctor.getName());
            doctor.setLastName(updatedDoctor.getLastName());
            doctor.setSpecialities(updatedDoctor.getSpecialities());
            doctor.setOffice(updatedDoctor.getOffice());
            doctor.setContactEmail(updatedDoctor.getContactEmail());
            return doctorRepository.save(doctor);
        } else {
            return null;
        }
    }

    public boolean deleteDoctor(long id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

