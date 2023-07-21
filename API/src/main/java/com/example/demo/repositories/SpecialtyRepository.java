package com.example.demo.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Specialty;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends JpaRepository <Specialty, Long> {
    List<Specialty> findByNameContaining(String name);
}
