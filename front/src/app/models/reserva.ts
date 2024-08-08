import { Servicio } from "./servicio";

export interface Reserva {
    id?: number;
    desde: Date;
    hasta?: Date;
    tomador: string;
    servicioId?: number;
    servicio?: Servicio;
}