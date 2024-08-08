import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { ToastrService } from 'ngx-toastr';

import { ServicioService } from '../../../services/servicio.service';
import { Servicio } from '../../../models/servicio';

@Component({
  selector: 'servicio-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class ServicioFormComponent implements OnInit {

  id?: any;

  form = new FormGroup({
    nombre: new FormControl('', Validators.required),
    descripcion: new FormControl(''),
    precio: new FormControl('', [Validators.required]),
  });

  constructor(
    private service: ServicioService,
    private spinner: NgxSpinnerService,
    private toastr: ToastrService,
    private route: ActivatedRoute,
    private router: Router
  ) {

  }


  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    if (this.id) {
      this.spinner.show();
      this.service.findById(this.id).subscribe({
        next: (data: any) => {
          this.spinner.hide();
          this.form.patchValue(data);
        },
        error: (error) => {
          this.spinner.hide();
          this.toastr.error(error.error?.message, 'error');
          this.router.navigate(['/servicios'])
          console.error(error)
        },
      });
    }
  }

  save() {
    const element: Servicio = {
      nombre: this.form.value.nombre!,
      descripcion: this.form.value.descripcion!,
      precio: parseFloat(this.form.value.precio!)
    };

    const observer = this.id ? this.service.update(this.id, element) : this.service.save(element);

    this.spinner.show();

    observer.subscribe({
      next: (data: any) => {
        this.spinner.hide();
        this.toastr.success('Elemento guardado', 'exito');
        this.router.navigate(['/servicios'])
      },
      error: (error) => {
        this.spinner.hide();
        this.toastr.error(error.error?.message, 'error');
        this.router.navigate(['/servicios'])
        console.error(error)
      },
    });
  }


}
