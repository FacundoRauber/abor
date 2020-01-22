import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';

import { IRelevamiento, Relevamiento } from 'app/shared/model/relevamiento.model';
import { RelevamientoService } from './relevamiento.service';

@Component({
  selector: 'jhi-relevamiento-update',
  templateUrl: './relevamiento-update.component.html'
})
export class RelevamientoUpdateComponent implements OnInit {
  isSaving = false;
  fechaDp: any;

  editForm = this.fb.group({
    id: [],
    fecha: [],
    escuela: [],
    puestoSalud: [],
    estado: []
  });

  constructor(protected relevamientoService: RelevamientoService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ relevamiento }) => {
      this.updateForm(relevamiento);
    });
  }

  updateForm(relevamiento: IRelevamiento): void {
    this.editForm.patchValue({
      id: relevamiento.id,
      fecha: relevamiento.fecha,
      escuela: relevamiento.escuela,
      puestoSalud: relevamiento.puestoSalud,
      estado: relevamiento.estado
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const relevamiento = this.createFromForm();
    if (relevamiento.id !== undefined) {
      this.subscribeToSaveResponse(this.relevamientoService.update(relevamiento));
    } else {
      this.subscribeToSaveResponse(this.relevamientoService.create(relevamiento));
    }
  }

  private createFromForm(): IRelevamiento {
    return {
      ...new Relevamiento(),
      id: this.editForm.get(['id'])!.value,
      fecha: this.editForm.get(['fecha'])!.value,
      escuela: this.editForm.get(['escuela'])!.value,
      puestoSalud: this.editForm.get(['puestoSalud'])!.value,
      estado: this.editForm.get(['estado'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IRelevamiento>>): void {
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
}
