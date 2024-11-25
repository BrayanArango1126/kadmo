import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StoreComponent } from './components/store/store.component';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { NotFoundComponent } from './components/error/not-found/not-found.component';

const routes: Routes = [
// {path:'admin', loadChildren: () => import('./components/admin/admin.module').then(m => m.AdminModule)},
{path:'', component: StoreComponent},
{path:'login', component: LoginComponent}, 
{path:'register', component: RegisterComponent}, 
{path:'404', component: NotFoundComponent}, 
{path:'**', redirectTo: '/404'}, 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
