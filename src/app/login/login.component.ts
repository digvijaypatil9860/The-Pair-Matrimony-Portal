import { Component } from '@angular/core';
import { UserDetails } from '../user-details';
import { PairService } from '../Pair.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  
  user: any = {}; // Assuming you have a 'user' object to store form data
  selectedGender: string = ''; // Variable to store the selected gender

  // injected dependecy of service dependency
  constructor(private service:PairService, private router: Router){}
  onSubmit() {
    this.submitForm();
  }

  submitForm() {
    this.service.addUser(this.user).subscribe((response: any) => {
      console.log(response);
      console.log('Form submitted!');
  
      if (this.selectedGender === 'female') {
        this.router.navigate(['/yourgroom']);
      } else if (this.selectedGender === 'male') {
        this.router.navigate(['/yourbride']);
      } else {
        console.error("Select gender");
      }
      // this.router.navigate(['/yourgroom']);
    });
  }
 
  
}
