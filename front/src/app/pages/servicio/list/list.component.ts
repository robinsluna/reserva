import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgxSpinnerService } from 'ngx-spinner';
import { ServicioService } from '../../../services/servicio.service';
import { Servicio } from '../../../models/servicio';

@Component({
  selector: 'servicio-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ServicioListComponent implements OnInit {

  view?: Servicio;
  data: Servicio[] = [];

  constructor(
    private spinner: NgxSpinnerService,
    private service: ServicioService
  ) {

  }

  ngOnInit(): void {
    this.spinner.show();
    this.service.findAll().subscribe({
      next: (data) => {
        this.data = data;
        this.spinner.hide();
      },
      error: (error) => {
        this.spinner.hide();
        console.error(error)
      },
    });
  }


}
