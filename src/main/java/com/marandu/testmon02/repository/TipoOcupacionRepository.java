package com.marandu.testmon02.repository;

import com.marandu.testmon02.domain.TipoOcupacion;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TipoOcupacion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TipoOcupacionRepository extends JpaRepository<TipoOcupacion, Long> {

}
