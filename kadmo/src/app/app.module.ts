import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { NotFoundComponent } from './components/error/not-found/not-found.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProfileModule } from './components/profile/profile.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptorsService } from './services/token-interceptors.service';
import { NgxPaginationModule } from 'ngx-pagination';
import { initializeApp, provideFirebaseApp } from '@angular/fire/app';
import { getAuth, provideAuth } from '@angular/fire/auth';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    NotFoundComponent,
    HeaderComponent,
    FooterComponent,    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    ProfileModule,
    BrowserAnimationsModule,
    NgxPaginationModule
],
  providers: [provideHttpClient(withInterceptorsFromDi()),
    { 
      provide: HTTP_INTERCEPTORS, 
      useClass: TokenInterceptorsService, multi: true 
    }, 
    provideFirebaseApp(() => initializeApp({
      "projectId":"kadmo-cc35d",
      "appId":"1:1067168185027:web:fb4f6832d1fad241ecc076",
      "storageBucket":"kadmo-cc35d.firebasestorage.app",
      "apiKey":"AIzaSyBVID3j7U6AOUNwgaabhDsVK-2CpwLym1E",
      "authDomain":"kadmo-cc35d.firebaseapp.com",
      "messagingSenderId":"1067168185027",
      "measurementId":"G-ZG5V09EXGS"
    })), 
    provideAuth(() => getAuth())],
  bootstrap: [AppComponent]
})
export class AppModule { }
