import { IRelevamiento } from 'app/shared/model/relevamiento.model';

export interface IOrigenAgua {
  id?: number;
  nombre?: string;
  estado?: boolean;
  relevamiento?: IRelevamiento;
}

export class OrigenAgua implements IOrigenAgua {
  constructor(public id?: number, public nombre?: string, public estado?: boolean, public relevamiento?: IRelevamiento) {
    this.estado = this.estado || false;
  }
}
