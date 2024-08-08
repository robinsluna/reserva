import { Component, OnInit } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { CommonModule } from '@angular/common';

import { Reserva } from '../../../models/reserva';
import { ReservaService } from '../../../services/reserva.service';

@Component({
  selector: 'reserva-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ReservaListComponent implements OnInit {

  view?: Reserva;
  data: Reserva[] = [];

  constructor(
    private spinner: NgxSpinnerService,
    private service: ReservaService
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
