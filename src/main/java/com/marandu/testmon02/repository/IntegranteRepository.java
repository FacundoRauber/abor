package com.marandu.testmon02.repository;

import com.marandu.testmon02.domain.Integrante;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Integrante entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IntegranteRepository extends JpaRepository<Integrante, Long> {

}
