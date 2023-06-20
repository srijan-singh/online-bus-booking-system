import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Email } from '../model/Email';
import { EmailAPI } from './API';

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  email : Email = new Email();

  emailAPI : EmailAPI = new EmailAPI();

  constructor(private http : HttpClient) { }

  sendEmail(email : Email){
    return this.http.post<Email>(this.emailAPI.sendEmail(), email
    );
  }

}

