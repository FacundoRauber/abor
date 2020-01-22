package com.marandu.testmon02.repository;

import com.marandu.testmon02.domain.TipoTratamientoBasura;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TipoTratamientoBasura entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TipoTratamientoBasuraRepository extends JpaRepository<TipoTratamientoBasura, Long> {

}
