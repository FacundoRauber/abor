package com.marandu.testmon02.web.rest;

import com.marandu.testmon02.domain.Relevamiento;
import com.marandu.testmon02.repository.RelevamientoRepository;
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
 * REST controller for managing {@link com.marandu.testmon02.domain.Relevamiento}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class RelevamientoResource {

    private final Logger log = LoggerFactory.getLogger(RelevamientoResource.class);

    private static final String ENTITY_NAME = "relevamiento";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final RelevamientoRepository relevamientoRepository;

    public RelevamientoResource(RelevamientoRepository relevamientoRepository) {
        this.relevamientoRepository = relevamientoRepository;
    }

    /**
     * {@code POST  /relevamientos} : Create a new relevamiento.
     *
     * @param relevamiento the relevamiento to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new relevamiento, or with status {@code 400 (Bad Request)} if the relevamiento has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/relevamientos")
    public ResponseEntity<Relevamiento> createRelevamiento(@RequestBody Relevamiento relevamiento) throws URISyntaxException {
        log.debug("REST request to save Relevamiento : {}", relevamiento);
        if (relevamiento.getId() != null) {
            throw new BadRequestAlertException("A new relevamiento cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Relevamiento result = relevamientoRepository.save(relevamiento);
        return ResponseEntity.created(new URI("/api/relevamientos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /relevamientos} : Updates an existing relevamiento.
     *
     * @param relevamiento the relevamiento to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated relevamiento,
     * or with status {@code 400 (Bad Request)} if the relevamiento is not valid,
     * or with status {@code 500 (Internal Server Error)} if the relevamiento couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/relevamientos")
    public ResponseEntity<Relevamiento> updateRelevamiento(@RequestBody Relevamiento relevamiento) throws URISyntaxException {
        log.debug("REST request to update Relevamiento : {}", relevamiento);
        if (relevamiento.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Relevamiento result = relevamientoRepository.save(relevamiento);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, relevamiento.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /relevamientos} : get all the relevamientos.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of relevamientos in body.
     */
    @GetMapping("/relevamientos")
    public List<Relevamiento> getAllRelevamientos() {
        log.debug("REST request to get all Relevamientos");
        return relevamientoRepository.findAll();
    }

    /**
     * {@code GET  /relevamientos/:id} : get the "id" relevamiento.
     *
     * @param id the id of the relevamiento to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the relevamiento, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/relevamientos/{id}")
    public ResponseEntity<Relevamiento> getRelevamiento(@PathVariable Long id) {
        log.debug("REST request to get Relevamiento : {}", id);
        Optional<Relevamiento> relevamiento = relevamientoRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(relevamiento);
    }

    /**
     * {@code DELETE  /relevamientos/:id} : delete the "id" relevamiento.
     *
     * @param id the id of the relevamiento to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/relevamientos/{id}")
    public ResponseEntity<Void> deleteRelevamiento(@PathVariable Long id) {
        log.debug("REST request to delete Relevamiento : {}", id);
        relevamientoRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
