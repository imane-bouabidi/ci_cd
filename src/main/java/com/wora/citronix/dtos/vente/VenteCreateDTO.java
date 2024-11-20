package com.wora.citronix.dtos.vente;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class VenteCreateDTO {
    @NotNull(message = "La date de vente est obligatoire.")
    private LocalDate dateVente;

    @Positive(message = "Le montant total doit être positif.")
    private double montantTotal;

    @NotNull(message = "L'identifiant de la récolte est obligatoire.")
    private UUID recolteId;
}

