package com.marandu.testmon02.repository;

import com.marandu.testmon02.domain.VinculoFamiliar;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the VinculoFamiliar entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VinculoFamiliarRepository extends JpaRepository<VinculoFamiliar, Long> {

}
