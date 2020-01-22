import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IIntegrante } from 'app/shared/model/integrante.model';
import { IntegranteService } from './integrante.service';
import { IntegranteDeleteDialogComponent } from './integrante-delete-dialog.component';

@Component({
  selector: 'jhi-integrante',
  templateUrl: './integrante.component.html'
})
export class IntegranteComponent implements OnInit, OnDestroy {
  integrantes?: IIntegrante[];
  eventSubscriber?: Subscription;

  constructor(protected integranteService: IntegranteService, protected eventManager: JhiEventManager, protected modalService: NgbModal) {}

  loadAll(): void {
    this.integranteService.query().subscribe((res: HttpResponse<IIntegrante[]>) => {
      this.integrantes = res.body ? res.body : [];
    });
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInIntegrantes();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IIntegrante): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInIntegrantes(): void {
    this.eventSubscriber = this.eventManager.subscribe('integranteListModification', () => this.loadAll());
  }

  delete(integrante: IIntegrante): void {
    const modalRef = this.modalService.open(IntegranteDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.integrante = integrante;
  }
}
