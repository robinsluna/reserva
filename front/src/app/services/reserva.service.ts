import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

import { Reserva } from '../models/reserva';

@Injectable({
  providedIn: 'root'
})
export class ReservaService {

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Reserva[]> {
    return this.httpClient.get<Reserva[]>(`${environment.API}/reservas`)
  }

  findById(id: any): Observable<Reserva> {
    return this.httpClient.get<Reserva>(`${environment.API}/reservas/${id}`)
  }

  save(data: Reserva): Observable<Reserva> {
    return this.httpClient.post<Reserva>(`${environment.API}/reservas`, data)
  }

  update(id: any, data: Reserva): Observable<Reserva> {
    return this.httpClient.put<Reserva>(`${environment.API}/reservas/${id}`, data);
  }
}
