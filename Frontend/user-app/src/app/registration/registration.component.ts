import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  
  name: string = "";
  email: string = "";
  password: string = "";

  constructor() { }

  ngOnInit(): void {
      
  }

  register(){
    alert("register"
    + "\nname: " + this.name
    + "\nemail: " + this.email
    + "\npassword: " + this.password)
  }
}
