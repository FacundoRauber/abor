export interface IComunidad {
  id?: number;
  nombre?: string;
  estado?: boolean;
}

export class Comunidad implements IComunidad {
  constructor(public id?: number, public nombre?: string, public estado?: boolean) {
    this.estado = this.estado || false;
  }
}
