import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { Testmono02TestModule } from '../../../test.module';
import { RelevamientoComponent } from 'app/entities/relevamiento/relevamiento.component';
import { RelevamientoService } from 'app/entities/relevamiento/relevamiento.service';
import { Relevamiento } from 'app/shared/model/relevamiento.model';

describe('Component Tests', () => {
  describe('Relevamiento Management Component', () => {
    let comp: RelevamientoComponent;
    let fixture: ComponentFixture<RelevamientoComponent>;
    let service: RelevamientoService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [Testmono02TestModule],
        declarations: [RelevamientoComponent],
        providers: []
      })
        .overrideTemplate(RelevamientoComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(RelevamientoComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(RelevamientoService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new Relevamiento(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.relevamientos && comp.relevamientos[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
