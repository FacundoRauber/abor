package com.marandu.testmon02.repository;

import com.marandu.testmon02.domain.OrigenAgua;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the OrigenAgua entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrigenAguaRepository extends JpaRepository<OrigenAgua, Long> {

}
