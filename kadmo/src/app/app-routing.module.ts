import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { NotFoundComponent } from './components/error/not-found/not-found.component';

const routes: Routes = [
  // AUTENTIFICACION
  {path:'login', component: LoginComponent}, 
  {path:'register', component: RegisterComponent}, 
  // COMUNICACION CON OTROS MÓDULOS
  // {path:'admin', loadChildren: () => import('./components/admin/admin.module').then(m => m.AdminModule)},
  {path:'store', loadChildren: () => import('./components/store/store.module').then(m => m.StoreModule)},
  {path:'listas', loadChildren: () => import('./components/lists/lists.module').then(m => m.ListsModule)},
  {path:'suscripcion', loadChildren: () => import('./components/subscription/subscription.module').then(m => m.SubscriptionModule)},

  // RUTAS DE ESTE MODULO
  {path:'404', component: NotFoundComponent}, 
  {path:'', redirectTo: '/store', pathMatch: 'full'},
  {path:'**', redirectTo: '/404'}, 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
