import { Component, OnInit } from '@angular/core';
import { User } from '../model/User';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  
  user : User = new User();

  constructor(private service : UserService, private route: Router) { }

  ngOnInit(): void {
      
  }

  async register(){

    try {
      const data = await this.service.registerUser(this.user);
      console.log(data);

      if(data != null){

      }
    }
    catch (error) {
      console.log('Error occurred during login:', error);
    }

    this.route.navigate(['/login']);

  }
}
