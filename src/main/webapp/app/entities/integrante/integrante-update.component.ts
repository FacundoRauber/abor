import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { IIntegrante, Integrante } from 'app/shared/model/integrante.model';
import { IntegranteService } from './integrante.service';
import { IRelevamiento } from 'app/shared/model/relevamiento.model';
import { RelevamientoService } from 'app/entities/relevamiento/relevamiento.service';

@Component({
  selector: 'jhi-integrante-update',
  templateUrl: './integrante-update.component.html'
})
export class IntegranteUpdateComponent implements OnInit {
  isSaving = false;

  relevamientos: IRelevamiento[] = [];
  fechaNacimientoDp: any;

  editForm = this.fb.group({
    id: [],
    dni: [null, [Validators.required]],
    apelllido: [null, [Validators.required]],
    nombre: [null, [Validators.required]],
    fechaNacimiento: [],
    edad: [null, [Validators.min(0), Validators.max(140)]],
    sexo: [],
    estado: [],
    integra: []
  });

  constructor(
    protected integranteService: IntegranteService,
    protected relevamientoService: RelevamientoService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ integrante }) => {
      this.updateForm(integrante);

      this.relevamientoService
        .query()
        .pipe(
          map((res: HttpResponse<IRelevamiento[]>) => {
            return res.body ? res.body : [];
          })
        )
        .subscribe((resBody: IRelevamiento[]) => (this.relevamientos = resBody));
    });
  }

  updateForm(integrante: IIntegrante): void {
    this.editForm.patchValue({
      id: integrante.id,
      dni: integrante.dni,
      apelllido: integrante.apelllido,
      nombre: integrante.nombre,
      fechaNacimiento: integrante.fechaNacimiento,
      edad: integrante.edad,
      sexo: integrante.sexo,
      estado: integrante.estado,
      integra: integrante.integra
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const integrante = this.createFromForm();
    if (integrante.id !== undefined) {
      this.subscribeToSaveResponse(this.integranteService.update(integrante));
    } else {
      this.subscribeToSaveResponse(this.integranteService.create(integrante));
    }
  }

  private createFromForm(): IIntegrante {
    return {
      ...new Integrante(),
      id: this.editForm.get(['id'])!.value,
      dni: this.editForm.get(['dni'])!.value,
      apelllido: this.editForm.get(['apelllido'])!.value,
      nombre: this.editForm.get(['nombre'])!.value,
      fechaNacimiento: this.editForm.get(['fechaNacimiento'])!.value,
      edad: this.editForm.get(['edad'])!.value,
      sexo: this.editForm.get(['sexo'])!.value,
      estado: this.editForm.get(['estado'])!.value,
      integra: this.editForm.get(['integra'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IIntegrante>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: IRelevamiento): any {
    return item.id;
  }
}
