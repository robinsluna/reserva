import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { NgxSpinnerService } from 'ngx-spinner';
import { ServicioService } from '../../../services/servicio.service';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router } from '@angular/router';
import { ReservaService } from '../../../services/reserva.service';
import { Servicio } from '../../../models/servicio';
import { Reserva } from '../../../models/reserva';

@Component({
  selector: 'reserva-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class ReservaFormComponent implements OnInit {

  servicios: Servicio[] = [];
  id?: any;

  form = new FormGroup({
    servicioId: new FormControl('', Validators.required),
    desde: new FormControl('', Validators.required),
    hasta: new FormControl('', [Validators.required]),
    tomador: new FormControl('', [Validators.required]),
  });

  constructor(
    private servicioService: ServicioService,
    private service: ReservaService,
    private spinner: NgxSpinnerService,
    private toastr: ToastrService,
    private route: ActivatedRoute,
    private router: Router
  ) {

  }


  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.spinner.show();
    this.servicioService.findAll().subscribe({
      next: (data: any) => {
        this.spinner.hide();
        this.servicios = data;
      },
      error: (error) => {
        this.spinner.hide();
        this.toastr.error(error.error?.message, 'error');
        console.error(error)
      },
    });

    if (this.id) {
      this.spinner.show();
      this.service.findById(this.id).subscribe({
        next: (data: any) => {
          this.spinner.hide();
          this.form.patchValue({
            ...data,
            servicioId: data.servicio?.id,
            desde: this.formatDate(data.desde),
            hasta: this.formatDate(data.hasta)
          });
        },
        error: (error) => {
          this.spinner.hide();
          this.toastr.error(error.error?.message, 'error');
          this.router.navigate(['/reservas'])
          console.error(error)
        },
      });
    }
  }

  save() {
    const element: Reserva = {
      servicioId: parseInt(this.form.value.servicioId!),
      hasta: new Date(this.form.value.hasta!),
      desde: new Date(this.form.value.desde!),
      tomador: this.form.value.tomador!
    };

    const observer = this.id ? this.service.update(this.id, element) : this.service.save(element);

    this.spinner.show();

    observer.subscribe({
      next: (data: any) => {
        this.spinner.hide();
        this.toastr.success('Elemento guardado', 'exito');
        this.router.navigate(['/reservas'])
      },
      error: (error) => {
        this.spinner.hide();
        this.toastr.error(error.error?.message, 'error');
        this.router.navigate(['/reservas'])
        console.error(error)
      },
    });
  }


  private formatDate(date: string) {
    const d = new Date(date);
    let month = '' + (d.getMonth() + 1);
    let day = '' + d.getDate();
    const year = d.getFullYear();
    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;
    return [year, month, day].join('-');
  }

}

