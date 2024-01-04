package com.tekup.gestion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.gestion.models.Bien;
public interface BienRepository extends JpaRepository<Bien, Long> {
    Optional<Bien> findByLabelle(String url);
    
}