import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { NotFoundComponent } from './components/error/not-found/not-found.component';
import { authGuard } from './guards/auth.guard';
import { ProfileComponent } from './components/profile/profile.component';

const routes: Routes = [
  // AUTENTIFICACION
  {path:'login', component: LoginComponent}, 
  {path:'register', component: RegisterComponent}, 
  // COMUNICACION CON OTROS MÓDULOS
  {path:'admin', loadChildren: () => import('./components/admin/admin.module').then(m => m.AdminModule), canActivate: [authGuard], data: {ValidateRol: 1}},
  {path:'store', loadChildren: () => import('./components/store/store.module').then(m => m.StoreModule)},
  {path:'listas', loadChildren: () => import('./components/lists/lists.module').then(m => m.ListsModule)},
  {path:'suscripcion', loadChildren: () => import('./components/subscription/subscription.module').then(m => m.SubscriptionModule)},
  
  // RUTAS DE ESTE MODULO
  {path:'profile', component: ProfileComponent, canActivate: [authGuard], data: {ValidateRol: 2}},
  {path:'404', component: NotFoundComponent}, 
  {path:'', redirectTo: '/store', pathMatch: 'full'},
  {path:'**', redirectTo: '/404'}, 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
