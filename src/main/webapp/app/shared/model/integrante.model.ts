import { Moment } from 'moment';
import { IRelevamiento } from 'app/shared/model/relevamiento.model';
import { Sexo } from 'app/shared/model/enumerations/sexo.model';

export interface IIntegrante {
  id?: number;
  dni?: number;
  apelllido?: string;
  nombre?: string;
  fechaNacimiento?: Moment;
  edad?: number;
  sexo?: Sexo;
  estado?: boolean;
  integra?: IRelevamiento;
}

export class Integrante implements IIntegrante {
  constructor(
    public id?: number,
    public dni?: number,
    public apelllido?: string,
    public nombre?: string,
    public fechaNacimiento?: Moment,
    public edad?: number,
    public sexo?: Sexo,
    public estado?: boolean,
    public integra?: IRelevamiento
  ) {
    this.estado = this.estado || false;
  }
}
