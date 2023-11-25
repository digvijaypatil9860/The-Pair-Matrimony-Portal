import { Component } from '@angular/core';
import { PairService } from '../Pair.service';
import { Router } from '@angular/router';
import { UserDetails } from '../user-details';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  // user: UserDetails = {
  //   // id: '',
  //   // fullname: '',
  //   // email: '',
  //   // gender: '',
  //   // contact: '',
  //   // password: '',
  //   // oldPassword: '',
  // };
  user: UserDetails = new UserDetails();
  
  // injected dependecy of service dependency
  constructor(private service:PairService, private router: Router){}
    
  submitForm(){
    this.service.addUser(this.user).subscribe((response:any) =>{
      console.log(response);
      console.log('Form submitted!');
  this.router.navigate(['/login']);
    });  //subscribe is method use to fetch data and actually get value
  }
 
}
