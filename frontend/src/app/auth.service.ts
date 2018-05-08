import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import * as config from './config';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login () {
    const body = new FormData();
    body.set('username', 'user');
    body.set('password', 'user');
    return this.http.post('http://localhost:3000/api/sessions', body)
      .subscribe(
        res => {
          console.log(res);
        },
        err => {
          console.log('Error occured', err);
        }
      );
  }

  getInfo() {
    this.http.get('').subscribe(data => {
      console.log(data);
    });
  }
}
