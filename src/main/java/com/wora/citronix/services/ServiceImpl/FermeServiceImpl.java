package com.wora.citronix.services.ServiceImpl;

import com.wora.citronix.Mappers.FermeMapper;
import com.wora.citronix.dtos.ferme.FermeCreateDTO;
import com.wora.citronix.dtos.ferme.FermeDTO;
import com.wora.citronix.dtos.ferme.FermeUpdateDTO;
import com.wora.citronix.entities.Ferme;
import com.wora.citronix.repositories.FermeRepository;
import com.wora.citronix.services.ServiceInerf.FermeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FermeServiceImpl implements FermeService {
    private final FermeMapper fermeMapper;
    private final FermeRepository fermeRepo;

    public FermeDTO save(FermeCreateDTO createDto){
        Ferme ferme = fermeMapper.toEntity(createDto);
        return fermeMapper.toDTO(fermeRepo.save(ferme));
    }

    @Override
    public FermeDTO update(FermeUpdateDTO updateDto, Long id) {
        Ferme ferme = fermeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("ferme not found"));
        if (ferme != null) {
        ferme.setNom(updateDto.getNom());
        ferme.setSuperficie(updateDto.getSuperficie());
        ferme.setLocalisation(updateDto.getLocalisation());
        ferme.setDateCreation(updateDto.getDateCreation());
            ferme = fermeRepo.save(ferme);
        }
        return fermeMapper.toDTO(ferme);
    }
}
