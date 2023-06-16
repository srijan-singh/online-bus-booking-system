import { Injectable } from '@angular/core';
import { User } from '../model/User';

import { HttpClient } from '@angular/common/http';
import { UserAPI } from './API';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  users : User[] = []

  userAPI : UserAPI = new UserAPI();

  constructor(private http : HttpClient) { }

  registerUser(user : User){
    this.http.post<User>(this.userAPI.registerUser(), user).subscribe(data => {
      this.users.push(data);
    })
  }

  loginUser(user : User){
    return this.http.post<User>(this.userAPI.loginUser(), user);
  }

  listUsers(){
    return this.http.get<User []>(this.userAPI.getAllUsers())
  }

  logoutUser(){
    localStorage.removeItem('userID');
  }
}
