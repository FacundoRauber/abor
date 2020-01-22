package com.marandu.testmon02.repository;

import com.marandu.testmon02.domain.TipoVivienda;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TipoVivienda entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TipoViviendaRepository extends JpaRepository<TipoVivienda, Long> {

}
