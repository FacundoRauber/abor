package com.marandu.testmon02.repository;

import com.marandu.testmon02.domain.TipoServicio;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TipoServicio entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TipoServicioRepository extends JpaRepository<TipoServicio, Long> {

}
