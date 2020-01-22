import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { Testmono02TestModule } from '../../../test.module';
import { IntegranteComponent } from 'app/entities/integrante/integrante.component';
import { IntegranteService } from 'app/entities/integrante/integrante.service';
import { Integrante } from 'app/shared/model/integrante.model';

describe('Component Tests', () => {
  describe('Integrante Management Component', () => {
    let comp: IntegranteComponent;
    let fixture: ComponentFixture<IntegranteComponent>;
    let service: IntegranteService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [Testmono02TestModule],
        declarations: [IntegranteComponent],
        providers: []
      })
        .overrideTemplate(IntegranteComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(IntegranteComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(IntegranteService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new Integrante(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.integrantes && comp.integrantes[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
