import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import * as config from './config';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  makeLogin(user, pass: string): Observable<any> {
    const enco: any = new HttpHeaders()
      .set('Content-Type', 'application/x-www-form-urlencoded')
      .set('X-Requested-With', 'XMLHttpRequest');

    const body: any = new HttpParams()
      .set('username', user)
      .set('password', pass);
    return this.http.post('http://localhost:3000/api/sessions',
      body.toString(),
      {
        headers: enco, withCredentials: true
      }
    );
  }

  getInfo() {
    const enco: any = new HttpHeaders()
      .set('Content-Type', 'application/x-www-form-urlencoded')
      .set('X-Requested-With', 'XMLHttpRequest');
    this.http.get('http://localhost:3000/api/users/current', { headers: enco, withCredentials: true }).subscribe(data => {
      console.log(data);
      localStorage.setItem('logged', 'true');
      localStorage.setItem('user', String(data));
    });
  }
}
