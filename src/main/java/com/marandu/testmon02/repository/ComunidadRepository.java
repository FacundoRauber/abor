package com.marandu.testmon02.repository;

import com.marandu.testmon02.domain.Comunidad;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Comunidad entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ComunidadRepository extends JpaRepository<Comunidad, Long> {

}
