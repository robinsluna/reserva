import { Routes } from '@angular/router';
import { ServicioListComponent } from './pages/servicio/list/list.component';
import { ServicioFormComponent } from './pages/servicio/form/form.component';
import { ReservaListComponent } from './pages/reserva/list/list.component';
import { ReservaFormComponent } from './pages/reserva/form/form.component';

export const routes: Routes = [
    {
        path: 'servicios',
        component: ServicioListComponent
    },
    {
        path: 'servicios/add',
        component: ServicioFormComponent
    },
    {
        path: 'servicios/:id/edit',
        component: ServicioFormComponent
    },
    {
        path: 'reservas',
        component: ReservaListComponent
    },
    {
        path: 'reservas/add',
        component: ReservaFormComponent
    },
    {
        path: 'reservas/:id/edit',
        component: ReservaFormComponent
    }
];
