import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { AboutComponent } from './about/about.component';
import { RegisterComponent } from './register/register.component';
import { UserlistComponent } from './userlist/userlist.component';
import { LoginComponent } from './login/login.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { ContactComponent } from './contact/contact.component';
import { YourGroomComponent } from './your-groom/your-groom.component';
import { YourBrideComponent } from './your-bride/your-bride.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch:'full' },
  {
    component: RegisterComponent,
    path: 'register',
  },
  {
    component: IndexComponent,
    path: 'home',
  },
  {
    component: AboutComponent,
    path: 'about',
  },
  {
    component: ContactComponent,
    path: 'contact',
  },
  
  {
    component: LoginComponent,
    path: 'login',
  },
  
  {
    component: UserlistComponent,
    path: 'UserList',
  },
  {
    component: UpdateUserComponent,
    path: 'update-user/:id',
  },
  {
    component: YourGroomComponent,
    path: 'yourgroom',
  },
  {
    component: YourBrideComponent,
    path: 'yourbride',
  },
 
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
