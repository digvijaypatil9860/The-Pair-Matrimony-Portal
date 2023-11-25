import { Component,OnInit } from '@angular/core';
import { PairService } from '../Pair.service';
import { Router, UrlSerializer } from '@angular/router';
import { UserDetails } from '../user-details';
@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})
export class UserlistComponent implements OnInit {
 
  users: UserDetails[] = [];
  // injected dependecy of service dependency
  constructor(private service:PairService, private router: Router){}

  ngOnInit(): void{
    this.getAllUsers();
  }

  private getAllUsers(){
    this.service.getApi().subscribe((data:any) =>{
      console.log(data);
     this. users = data;//subscribe is method use to fetch data and actually get value
  
    });
  }

  deleteUser(id: number) {
    this.service.deleteUser(id).subscribe(data =>{
     console.log(data);
      this.getAllUsers();
    });
}

updateUser(id: number) {
  this.router.navigate(['update-user', id]);
  
}
   
  }


  
    

  


