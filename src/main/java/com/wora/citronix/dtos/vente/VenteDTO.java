package com.wora.citronix.dtos.vente;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class VenteDTO {
    private UUID id;
    private LocalDate dateVente;
    private double montantTotal;
    private RecolteEmbeddedDTO recolte;
}

