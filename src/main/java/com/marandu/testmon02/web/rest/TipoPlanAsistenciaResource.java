package com.marandu.testmon02.web.rest;

import com.marandu.testmon02.domain.TipoPlanAsistencia;
import com.marandu.testmon02.repository.TipoPlanAsistenciaRepository;
import com.marandu.testmon02.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional; 
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.marandu.testmon02.domain.TipoPlanAsistencia}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class TipoPlanAsistenciaResource {

    private final Logger log = LoggerFactory.getLogger(TipoPlanAsistenciaResource.class);

    private static final String ENTITY_NAME = "tipoPlanAsistencia";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TipoPlanAsistenciaRepository tipoPlanAsistenciaRepository;

    public TipoPlanAsistenciaResource(TipoPlanAsistenciaRepository tipoPlanAsistenciaRepository) {
        this.tipoPlanAsistenciaRepository = tipoPlanAsistenciaRepository;
    }

    /**
     * {@code POST  /tipo-plan-asistencias} : Create a new tipoPlanAsistencia.
     *
     * @param tipoPlanAsistencia the tipoPlanAsistencia to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new tipoPlanAsistencia, or with status {@code 400 (Bad Request)} if the tipoPlanAsistencia has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/tipo-plan-asistencias")
    public ResponseEntity<TipoPlanAsistencia> createTipoPlanAsistencia(@RequestBody TipoPlanAsistencia tipoPlanAsistencia) throws URISyntaxException {
        log.debug("REST request to save TipoPlanAsistencia : {}", tipoPlanAsistencia);
        if (tipoPlanAsistencia.getId() != null) {
            throw new BadRequestAlertException("A new tipoPlanAsistencia cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TipoPlanAsistencia result = tipoPlanAsistenciaRepository.save(tipoPlanAsistencia);
        return ResponseEntity.created(new URI("/api/tipo-plan-asistencias/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /tipo-plan-asistencias} : Updates an existing tipoPlanAsistencia.
     *
     * @param tipoPlanAsistencia the tipoPlanAsistencia to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated tipoPlanAsistencia,
     * or with status {@code 400 (Bad Request)} if the tipoPlanAsistencia is not valid,
     * or with status {@code 500 (Internal Server Error)} if the tipoPlanAsistencia couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/tipo-plan-asistencias")
    public ResponseEntity<TipoPlanAsistencia> updateTipoPlanAsistencia(@RequestBody TipoPlanAsistencia tipoPlanAsistencia) throws URISyntaxException {
        log.debug("REST request to update TipoPlanAsistencia : {}", tipoPlanAsistencia);
        if (tipoPlanAsistencia.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TipoPlanAsistencia result = tipoPlanAsistenciaRepository.save(tipoPlanAsistencia);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, tipoPlanAsistencia.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /tipo-plan-asistencias} : get all the tipoPlanAsistencias.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tipoPlanAsistencias in body.
     */
    @GetMapping("/tipo-plan-asistencias")
    public List<TipoPlanAsistencia> getAllTipoPlanAsistencias() {
        log.debug("REST request to get all TipoPlanAsistencias");
        return tipoPlanAsistenciaRepository.findAll();
    }

    /**
     * {@code GET  /tipo-plan-asistencias/:id} : get the "id" tipoPlanAsistencia.
     *
     * @param id the id of the tipoPlanAsistencia to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the tipoPlanAsistencia, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/tipo-plan-asistencias/{id}")
    public ResponseEntity<TipoPlanAsistencia> getTipoPlanAsistencia(@PathVariable Long id) {
        log.debug("REST request to get TipoPlanAsistencia : {}", id);
        Optional<TipoPlanAsistencia> tipoPlanAsistencia = tipoPlanAsistenciaRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(tipoPlanAsistencia);
    }

    /**
     * {@code DELETE  /tipo-plan-asistencias/:id} : delete the "id" tipoPlanAsistencia.
     *
     * @param id the id of the tipoPlanAsistencia to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/tipo-plan-asistencias/{id}")
    public ResponseEntity<Void> deleteTipoPlanAsistencia(@PathVariable Long id) {
        log.debug("REST request to delete TipoPlanAsistencia : {}", id);
        tipoPlanAsistenciaRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
