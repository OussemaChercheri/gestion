package com.tekup.gestion.dto;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
//design patter builder pour créer une instance de tel façon setting ykoun ll properties li nst7a9ouhom for a particular instance
public class BienDto {
    private Long id;
    @NotEmpty(message = "Le champ 'labelle' du bien ne peut pas être vide.")
    private String labelle;
    @NotEmpty(message = "Le champ 'photourl' du bien ne peut pas être vide")
    private String photourl;
    @NotEmpty(message = "Le champ 'detail' du bien ne peut pas être vide")
    private String detail;
    @NotEmpty(message = "Le champ 'prix' du bien ne peut pas être vide")
    private String prix;
    private String type;
    @NotNull
    private int nbpiece;
    @NotEmpty(message = "Le choix de vendre ou louer du bien ne peut pas être vide")
    private String louv;//pour dire à louer ou à vendre
}
