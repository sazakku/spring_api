package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Specialty;
import com.example.demo.repositories.SpecialtyRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SpecialtyController {
    @Autowired
    SpecialtyRepository specialtyRepository;

    @GetMapping("/specialties")
    public ResponseEntity<List<Specialty>> getAllSpecialties(@RequestParam(required = false) String title) {
        try {
            List<Specialty> specialties = new ArrayList<Specialty>();

            if (title == null)
                specialtyRepository.findAll().forEach(specialties::add);
            else
                specialtyRepository.findByNameContaining(title).forEach(specialties::add);

            if (specialties.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(specialties, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/specialties/{id}")
    public ResponseEntity<Specialty> getSpecialtyById(@PathVariable("id") long id) {
        Optional<Specialty> specialtyData = specialtyRepository.findById(id);

        if (specialtyData.isPresent()) {
            return new ResponseEntity<>(specialtyData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/specialties")
    public ResponseEntity<Specialty> createSpecialty(@RequestBody Specialty specialty) {
        try {
            Specialty _specialty = specialtyRepository
                    .save(new Specialty(specialty.getName()));
            return new ResponseEntity<>(_specialty, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/specialties/{id}")
    public ResponseEntity<Specialty> updateSpecialty(@PathVariable("id") long id, @RequestBody Specialty specialty) {
        Optional<Specialty> specialtyData = specialtyRepository.findById(id);

        if (specialtyData.isPresent()) {
            Specialty _specialty = specialtyData.get();
            _specialty.setName(specialty.getName());
            return new ResponseEntity<>(specialtyRepository.save(_specialty), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/specialties/{id}")
    public ResponseEntity<HttpStatus> deleteSpecialty(@PathVariable("id") long id) {
        try {
            specialtyRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/specialties")
    public ResponseEntity<HttpStatus> deleteAllSpecialties() {
        try {
            specialtyRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
