package com.marandu.testmon02.config;

import java.time.Duration;

import org.ehcache.config.builders.*;
import org.ehcache.jsr107.Eh107Configuration;

import org.hibernate.cache.jcache.ConfigSettings;
import io.github.jhipster.config.JHipsterProperties;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        JHipsterProperties.Cache.Ehcache ehcache = jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
                .build());
    }

    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(javax.cache.CacheManager cacheManager) {
        return hibernateProperties -> hibernateProperties.put(ConfigSettings.CACHE_MANAGER, cacheManager);
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            createCache(cm, com.marandu.testmon02.repository.UserRepository.USERS_BY_LOGIN_CACHE);
            createCache(cm, com.marandu.testmon02.repository.UserRepository.USERS_BY_EMAIL_CACHE);
            createCache(cm, com.marandu.testmon02.domain.User.class.getName());
            createCache(cm, com.marandu.testmon02.domain.Authority.class.getName());
            createCache(cm, com.marandu.testmon02.domain.User.class.getName() + ".authorities");
            createCache(cm, com.marandu.testmon02.domain.VinculoFamiliar.class.getName());
            createCache(cm, com.marandu.testmon02.domain.TipoPlanAsistencia.class.getName());
            createCache(cm, com.marandu.testmon02.domain.Nacionalidad.class.getName());
            createCache(cm, com.marandu.testmon02.domain.NivelEducativo.class.getName());
            createCache(cm, com.marandu.testmon02.domain.TipoOcupacion.class.getName());
            createCache(cm, com.marandu.testmon02.domain.Integrante.class.getName());
            createCache(cm, com.marandu.testmon02.domain.Comunidad.class.getName());
            createCache(cm, com.marandu.testmon02.domain.OrigenEnergia.class.getName());
            createCache(cm, com.marandu.testmon02.domain.OrigenAgua.class.getName());
            createCache(cm, com.marandu.testmon02.domain.TipoVivienda.class.getName());
            createCache(cm, com.marandu.testmon02.domain.TipoServicio.class.getName());
            createCache(cm, com.marandu.testmon02.domain.TipoTratamientoBasura.class.getName());
            createCache(cm, com.marandu.testmon02.domain.Relevamiento.class.getName());
            createCache(cm, com.marandu.testmon02.domain.Relevamiento.class.getName() + ".integrantes");
            createCache(cm, com.marandu.testmon02.domain.Relevamiento.class.getName() + ".origenenergias");
            createCache(cm, com.marandu.testmon02.domain.Relevamiento.class.getName() + ".origenaguas");
            createCache(cm, com.marandu.testmon02.domain.Relevamiento.class.getName() + ".tiposervicios");
            // jhipster-needle-ehcache-add-entry
        };
    }

    private void createCache(javax.cache.CacheManager cm, String cacheName) {
        javax.cache.Cache<Object, Object> cache = cm.getCache(cacheName);
        if (cache != null) {
            cm.destroyCache(cacheName);
        }
        cm.createCache(cacheName, jcacheConfiguration);
    }

}
