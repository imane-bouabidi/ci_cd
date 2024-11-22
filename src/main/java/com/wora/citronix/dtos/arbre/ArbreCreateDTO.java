package com.wora.citronix.dtos.arbre;

import com.wora.citronix.dtos.champ.ChampEmbeddedDTO;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.Period;

@Data
public class ArbreCreateDTO {
    @NotNull(message = "La date de plantation est obligatoire.")
    private LocalDate datePlantation;

    @NotNull(message = "L'identifiant du champ est obligatoire.")
    private Long champId;

    @NotNull
    @Min(0)
    @Max(20)
    private Integer age;

    private boolean productif;

    public void setAge(LocalDate datePlantation) {
        this.datePlantation = datePlantation;
        if (this.datePlantation != null) {
            LocalDate today = LocalDate.now();
            this.age = Period.between(this.datePlantation, today).getYears();
        }
    }

}

