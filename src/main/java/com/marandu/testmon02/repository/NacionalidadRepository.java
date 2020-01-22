package com.marandu.testmon02.repository;

import com.marandu.testmon02.domain.Nacionalidad;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Nacionalidad entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NacionalidadRepository extends JpaRepository<Nacionalidad, Long> {

}
