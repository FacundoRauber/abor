import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IRelevamiento } from 'app/shared/model/relevamiento.model';
import { RelevamientoService } from './relevamiento.service';
import { RelevamientoDeleteDialogComponent } from './relevamiento-delete-dialog.component';

@Component({
  selector: 'jhi-relevamiento',
  templateUrl: './relevamiento.component.html'
})
export class RelevamientoComponent implements OnInit, OnDestroy {
  relevamientos?: IRelevamiento[];
  eventSubscriber?: Subscription;

  constructor(
    protected relevamientoService: RelevamientoService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.relevamientoService.query().subscribe((res: HttpResponse<IRelevamiento[]>) => {
      this.relevamientos = res.body ? res.body : [];
    });
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInRelevamientos();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IRelevamiento): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInRelevamientos(): void {
    this.eventSubscriber = this.eventManager.subscribe('relevamientoListModification', () => this.loadAll());
  }

  delete(relevamiento: IRelevamiento): void {
    const modalRef = this.modalService.open(RelevamientoDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.relevamiento = relevamiento;
  }
}
