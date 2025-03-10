package com.wora.citronix.repositories;

import com.wora.citronix.entities.Champ;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ChampRepository extends JpaRepository<Champ,Long> {
    @Query("SELECT COALESCE(SUM(c.superficie), 0.0) FROM Champ c WHERE c.ferme.id = :fermeId")
    double sumSuperficieByFerme(@Param("fermeId") Long fermeId);
    Page<Champ> findByFermeId(Long fermeId, Pageable pageable);
    @Query("SELECT COUNT(c) FROM Champ c WHERE c.ferme.id = :fermeId")
    long countByFerme(@Param("fermeId") Long fermeId);

}
