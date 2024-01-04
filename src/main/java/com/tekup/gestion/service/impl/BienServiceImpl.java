package com.tekup.gestion.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tekup.gestion.dto.BienDto;
import com.tekup.gestion.models.Bien;
import com.tekup.gestion.repository.BienRepository;
import com.tekup.gestion.service.BienService;

import jakarta.validation.Valid;
import lombok.Builder;

@Builder
@Service
public class BienServiceImpl implements BienService{

    private BienRepository bienRepository;


    //@Autowired
    public BienServiceImpl(BienRepository bienRepository){
        this.bienRepository = bienRepository;
    }

    @Override
    public List<BienDto> findAllBiens() {
        List<Bien> biens = bienRepository.findAll();
        return biens.stream().map((bien) -> mapToBienDto(bien)).collect(Collectors.toList());
    }
/////////to display the list of properties on the frontend, without exposing unnecessary details
    private BienDto mapToBienDto(Bien bien){
        BienDto bienDto = BienDto.builder()
            .id(bien.getId())
            .labelle(bien.getLabelle())
            .louv(bien.getLouv())
            .nbpiece(bien.getNbpiece())
            .detail(bien.getDetail())
            .prix(bien.getPrix())
            .photourl(bien.getPhotourl())
            .build();
        return bienDto;

    }

    @Override
    public Bien saveBien(BienDto bienDto) {
        Bien bien = mapToBien(bienDto);
        return bienRepository.save(bien);
    }

    @Override
    public BienDto findBienById(Long BienId) {
        Bien bien=bienRepository.findById(BienId).get();
        return mapToBienDto(bien);
    }

    @Override
    public void updateBien(@Valid BienDto bientDto) {
    Bien bien =mapToBien(bientDto);
    bienRepository.save(bien);
    }

    private Bien mapToBien(BienDto bien){
        Bien bienDto=Bien.builder()
            .id(bien.getId())
            .labelle(bien.getLabelle())
            .louv(bien.getLouv())
            .nbpiece(bien.getNbpiece())
            .detail(bien.getDetail())
            .prix(bien.getPrix())
            .photourl(bien.getPhotourl())
            .build();
        return bienDto;
    }

    @Override
    public void delete(Long bienId) {
        bienRepository.deleteById(bienId);
    }

    



}
