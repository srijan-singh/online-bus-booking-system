import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../model/User';
import { Router } from '@angular/router';
import { firstValueFrom } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  user : User = new User();

  constructor(private service : UserService,  private route : Router) { }

  ngOnInit() {
  }

  async login() {
    /* 
    alert("login"
    + "\nemail: " + this.user.email
    + "\npassword: " + this.user.password); */
  
    try {
      const data = await firstValueFrom(this.service.loginUser(this.user));
      this.user = data;

      this.service.listUsers().subscribe(users => {
        console.log(users);
      });

      localStorage.setItem('userEmail', this.user.email);

      localStorage.setItem('userID', String(this.user.id));

      localStorage.setItem('userName', this.user.name);

      this.route.navigate(['/dashboard']);

    } catch (error) {
      console.log('Error occurred during login:', error);
    }
  }

}
