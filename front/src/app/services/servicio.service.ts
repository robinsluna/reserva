import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Servicio } from '../models/servicio';

@Injectable({
    providedIn: 'root',
})
export class ServicioService {

    constructor(private httpClient: HttpClient) { }

    findAll(): Observable<Servicio[]> {
        return this.httpClient.get<Servicio[]>(`${environment.API}/servicios`)
    }

    findById(id: any): Observable<Servicio> {
        return this.httpClient.get<Servicio>(`${environment.API}/servicios/${id}`)
    }

    save(data: Servicio): Observable<Servicio> {
        return this.httpClient.post<Servicio>(`${environment.API}/servicios`, data)
    }

    update(id: any, data: Servicio): Observable<Servicio> {
        return this.httpClient.put<Servicio>(`${environment.API}/servicios/${id}`, data);
    }
}
