package com.tekup.gestion.service;

import java.util.List;

import com.tekup.gestion.dto.BienDto;
import com.tekup.gestion.models.Bien;

import jakarta.validation.Valid;

public interface BienService {

    List<BienDto> findAllBiens();
    Bien saveBien(BienDto bienDto) ;
    BienDto findBienById(Long BienId);
    void updateBien(@Valid BienDto bien);
    void delete(Long bienId);

    
}