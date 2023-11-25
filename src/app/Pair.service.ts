import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserDetails } from './user-details';
@Injectable({
  providedIn: 'root'
})
export class PairService {
  
  
  private baseurl = 'http://localhost:1010/api/v1';
  private url = "http://localhost:1010/api/v1/allUsers";
 
  constructor(private http: HttpClient) {} // injected denpendency

  getApi():Observable<any>{
    return this.http.get(this.url);
  }

  addUser(user:UserDetails):Observable<Object>{
    return this.http.post(`${this.baseurl}/register`, user);
  }
  
  deleteUser(id:number):Observable<Object>{
    return this.http.delete(`${this.baseurl}/register/${id}`);
  }

  updateUser(id: number, user: UserDetails): Observable<Object>{
    return this.http.put(`${this.baseurl}/register/${id}`, user);
  }

  getUserById(id: number): Observable<UserDetails> {
    return this.http.get<UserDetails>(`${this.baseurl}/register/${id}`);
  }
  
}
