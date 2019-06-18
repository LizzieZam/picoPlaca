import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AutoFormComponent } from './auto-form/auto-form.component';
import { ConsultaFormComponent } from './consulta-form/consulta-form.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/registro',
    pathMatch: 'full',
},
{ path: 'registro',  component: AutoFormComponent,},
{ path: 'consulta',    component: ConsultaFormComponent,},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
