package com.marandu.testmon02.repository;

import com.marandu.testmon02.domain.TipoPlanAsistencia;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TipoPlanAsistencia entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TipoPlanAsistenciaRepository extends JpaRepository<TipoPlanAsistencia, Long> {

}
