import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { NotFoundComponent } from './components/error/not-found/not-found.component';
import { BooksComponent } from './components/store/books/books.component';
import { StoreComponent } from './components/store/store.component';

const routes: Routes = [
// {path:'admin', loadChildren: () => import('./components/admin/admin.module').then(m => m.AdminModule)},
{path:'login', component: LoginComponent}, 
{path:'register', component: RegisterComponent}, 
{path:'store', loadChildren: () => import('./components/store/store.module').then(m => m.StoreModule)},
{path:'', redirectTo: '/store', pathMatch: 'full'},
{path:'404', component: NotFoundComponent}, 
{path:'**', redirectTo: '/404'}, 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
