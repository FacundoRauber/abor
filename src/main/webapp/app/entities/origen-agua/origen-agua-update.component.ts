import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { IOrigenAgua, OrigenAgua } from 'app/shared/model/origen-agua.model';
import { OrigenAguaService } from './origen-agua.service';
import { IRelevamiento } from 'app/shared/model/relevamiento.model';
import { RelevamientoService } from 'app/entities/relevamiento/relevamiento.service';

@Component({
  selector: 'jhi-origen-agua-update',
  templateUrl: './origen-agua-update.component.html'
})
export class OrigenAguaUpdateComponent implements OnInit {
  isSaving = false;

  relevamientos: IRelevamiento[] = [];

  editForm = this.fb.group({
    id: [],
    nombre: [null, [Validators.required]],
    estado: [],
    relevamiento: []
  });

  constructor(
    protected origenAguaService: OrigenAguaService,
    protected relevamientoService: RelevamientoService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ origenAgua }) => {
      this.updateForm(origenAgua);

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

  updateForm(origenAgua: IOrigenAgua): void {
    this.editForm.patchValue({
      id: origenAgua.id,
      nombre: origenAgua.nombre,
      estado: origenAgua.estado,
      relevamiento: origenAgua.relevamiento
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const origenAgua = this.createFromForm();
    if (origenAgua.id !== undefined) {
      this.subscribeToSaveResponse(this.origenAguaService.update(origenAgua));
    } else {
      this.subscribeToSaveResponse(this.origenAguaService.create(origenAgua));
    }
  }

  private createFromForm(): IOrigenAgua {
    return {
      ...new OrigenAgua(),
      id: this.editForm.get(['id'])!.value,
      nombre: this.editForm.get(['nombre'])!.value,
      estado: this.editForm.get(['estado'])!.value,
      relevamiento: this.editForm.get(['relevamiento'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IOrigenAgua>>): void {
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
