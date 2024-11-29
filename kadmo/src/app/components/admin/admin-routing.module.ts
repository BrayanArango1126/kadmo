import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { GenerosComponent } from './pages/generos/generos.component';
import { AsideNavComponent } from './pages/aside-nav/aside-nav.component';
import { AdminComponent } from './admin.component';

const routes: Routes = [
  {path:'', component: AdminComponent},
  {path:'dashboard', component: DashboardComponent},
  {path:'generos', component: GenerosComponent},
  {path:'aside', component: AsideNavComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
