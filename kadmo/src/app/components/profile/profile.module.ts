import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileComponent } from './profile.component';
import { UserInfoComponent } from './pages/user-info/user-info.component';



@NgModule({
  declarations: [
    ProfileComponent,
    UserInfoComponent,
  ],
  imports: [
    CommonModule
  ],
  exports: [
  ]
})
export class ProfileModule { }
