package com.marandu.testmon02.repository;

import com.marandu.testmon02.domain.NivelEducativo;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the NivelEducativo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NivelEducativoRepository extends JpaRepository<NivelEducativo, Long> {

}
