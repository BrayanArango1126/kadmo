import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { GenerosComponent } from './pages/generos/generos.component';

const routes: Routes = [
  {path:'dashboard', component: DashboardComponent},
  {path:'generos', component: GenerosComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
