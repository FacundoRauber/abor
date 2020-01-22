package com.marandu.testmon02.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A Relevamiento.
 */
@Entity
@Table(name = "relevamiento")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Relevamiento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "escuela")
    private Boolean escuela;

    @Column(name = "puesto_salud")
    private Boolean puestoSalud;

    @Column(name = "estado")
    private Boolean estado;

    @OneToMany(mappedBy = "integra")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Integrante> integrantes = new HashSet<>();

    @OneToMany(mappedBy = "relevamiento")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<OrigenEnergia> origenenergias = new HashSet<>();

    @OneToMany(mappedBy = "relevamiento")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<OrigenAgua> origenaguas = new HashSet<>();

    @OneToMany(mappedBy = "relevamiento")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<TipoServicio> tiposervicios = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Relevamiento fecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Boolean isEscuela() {
        return escuela;
    }

    public Relevamiento escuela(Boolean escuela) {
        this.escuela = escuela;
        return this;
    }

    public void setEscuela(Boolean escuela) {
        this.escuela = escuela;
    }

    public Boolean isPuestoSalud() {
        return puestoSalud;
    }

    public Relevamiento puestoSalud(Boolean puestoSalud) {
        this.puestoSalud = puestoSalud;
        return this;
    }

    public void setPuestoSalud(Boolean puestoSalud) {
        this.puestoSalud = puestoSalud;
    }

    public Boolean isEstado() {
        return estado;
    }

    public Relevamiento estado(Boolean estado) {
        this.estado = estado;
        return this;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Set<Integrante> getIntegrantes() {
        return integrantes;
    }

    public Relevamiento integrantes(Set<Integrante> integrantes) {
        this.integrantes = integrantes;
        return this;
    }

    public Relevamiento addIntegrante(Integrante integrante) {
        this.integrantes.add(integrante);
        integrante.setIntegra(this);
        return this;
    }

    public Relevamiento removeIntegrante(Integrante integrante) {
        this.integrantes.remove(integrante);
        integrante.setIntegra(null);
        return this;
    }

    public void setIntegrantes(Set<Integrante> integrantes) {
        this.integrantes = integrantes;
    }

    public Set<OrigenEnergia> getOrigenenergias() {
        return origenenergias;
    }

    public Relevamiento origenenergias(Set<OrigenEnergia> origenEnergias) {
        this.origenenergias = origenEnergias;
        return this;
    }

    public Relevamiento addOrigenenergia(OrigenEnergia origenEnergia) {
        this.origenenergias.add(origenEnergia);
        origenEnergia.setRelevamiento(this);
        return this;
    }

    public Relevamiento removeOrigenenergia(OrigenEnergia origenEnergia) {
        this.origenenergias.remove(origenEnergia);
        origenEnergia.setRelevamiento(null);
        return this;
    }

    public void setOrigenenergias(Set<OrigenEnergia> origenEnergias) {
        this.origenenergias = origenEnergias;
    }

    public Set<OrigenAgua> getOrigenaguas() {
        return origenaguas;
    }

    public Relevamiento origenaguas(Set<OrigenAgua> origenAguas) {
        this.origenaguas = origenAguas;
        return this;
    }

    public Relevamiento addOrigenagua(OrigenAgua origenAgua) {
        this.origenaguas.add(origenAgua);
        origenAgua.setRelevamiento(this);
        return this;
    }

    public Relevamiento removeOrigenagua(OrigenAgua origenAgua) {
        this.origenaguas.remove(origenAgua);
        origenAgua.setRelevamiento(null);
        return this;
    }

    public void setOrigenaguas(Set<OrigenAgua> origenAguas) {
        this.origenaguas = origenAguas;
    }

    public Set<TipoServicio> getTiposervicios() {
        return tiposervicios;
    }

    public Relevamiento tiposervicios(Set<TipoServicio> tipoServicios) {
        this.tiposervicios = tipoServicios;
        return this;
    }

    public Relevamiento addTiposervicio(TipoServicio tipoServicio) {
        this.tiposervicios.add(tipoServicio);
        tipoServicio.setRelevamiento(this);
        return this;
    }

    public Relevamiento removeTiposervicio(TipoServicio tipoServicio) {
        this.tiposervicios.remove(tipoServicio);
        tipoServicio.setRelevamiento(null);
        return this;
    }

    public void setTiposervicios(Set<TipoServicio> tipoServicios) {
        this.tiposervicios = tipoServicios;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Relevamiento)) {
            return false;
        }
        return id != null && id.equals(((Relevamiento) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Relevamiento{" +
            "id=" + getId() +
            ", fecha='" + getFecha() + "'" +
            ", escuela='" + isEscuela() + "'" +
            ", puestoSalud='" + isPuestoSalud() + "'" +
            ", estado='" + isEstado() + "'" +
            "}";
    }
}
