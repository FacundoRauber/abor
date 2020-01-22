import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'vinculo-familiar',
        loadChildren: () => import('./vinculo-familiar/vinculo-familiar.module').then(m => m.Testmono02VinculoFamiliarModule)
      },
      {
        path: 'tipo-plan-asistencia',
        loadChildren: () => import('./tipo-plan-asistencia/tipo-plan-asistencia.module').then(m => m.Testmono02TipoPlanAsistenciaModule)
      },
      {
        path: 'nacionalidad',
        loadChildren: () => import('./nacionalidad/nacionalidad.module').then(m => m.Testmono02NacionalidadModule)
      },
      {
        path: 'nivel-educativo',
        loadChildren: () => import('./nivel-educativo/nivel-educativo.module').then(m => m.Testmono02NivelEducativoModule)
      },
      {
        path: 'tipo-ocupacion',
        loadChildren: () => import('./tipo-ocupacion/tipo-ocupacion.module').then(m => m.Testmono02TipoOcupacionModule)
      },
      {
        path: 'integrante',
        loadChildren: () => import('./integrante/integrante.module').then(m => m.Testmono02IntegranteModule)
      },
      {
        path: 'comunidad',
        loadChildren: () => import('./comunidad/comunidad.module').then(m => m.Testmono02ComunidadModule)
      },
      {
        path: 'origen-energia',
        loadChildren: () => import('./origen-energia/origen-energia.module').then(m => m.Testmono02OrigenEnergiaModule)
      },
      {
        path: 'origen-agua',
        loadChildren: () => import('./origen-agua/origen-agua.module').then(m => m.Testmono02OrigenAguaModule)
      },
      {
        path: 'tipo-vivienda',
        loadChildren: () => import('./tipo-vivienda/tipo-vivienda.module').then(m => m.Testmono02TipoViviendaModule)
      },
      {
        path: 'tipo-servicio',
        loadChildren: () => import('./tipo-servicio/tipo-servicio.module').then(m => m.Testmono02TipoServicioModule)
      },
      {
        path: 'tipo-tratamiento-basura',
        loadChildren: () =>
          import('./tipo-tratamiento-basura/tipo-tratamiento-basura.module').then(m => m.Testmono02TipoTratamientoBasuraModule)
      },
      {
        path: 'relevamiento',
        loadChildren: () => import('./relevamiento/relevamiento.module').then(m => m.Testmono02RelevamientoModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class Testmono02EntityModule {}
