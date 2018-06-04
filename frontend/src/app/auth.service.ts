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

  register(user, pass: string) {
    const enco: any = new HttpHeaders()
      .set('Content-Type', 'application/x-www-form-urlencoded')
      .set('X-Requested-With', 'XMLHttpRequest');

    const body: any = new HttpParams()
      .set('name', user)
      .set('password', pass)
      .set('role', 'USER');
    return this.http.post('http://localhost:3000/api/users',
      body.toString(),
      {
        headers: enco
      }
    );
  }

  remove() {
    const enco: any = new HttpHeaders()
      .set('Content-Type', 'application/x-www-form-urlencoded')
      .set('X-Requested-With', 'XMLHttpRequest');
    this.http.delete('http://localhost:3000/api/users/current', { headers: enco, withCredentials: true }).subscribe(data => {
      localStorage.setItem('logged', 'false');
      localStorage.setItem('user', undefined);
      deleteAllCookies();
    });
  }

  logout() {
    const enco: any = new HttpHeaders()
      .set('Content-Type', 'application/x-www-form-urlencoded')
      .set('X-Requested-With', 'XMLHttpRequest');
      this.http.delete('http://localhost:3000/api/sessions', { headers: enco, withCredentials: true }).subscribe(data => {
      console.log(data);
      deleteAllCookies();
    });
  }
}

function deleteAllCookies() {
  const cookies = document.cookie.split(';');

  for (let i = 0; i < cookies.length; i++) {
      const cookie = cookies[i];
      const eqPos = cookie.indexOf('=');
      const name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
      document.cookie = name + '=;expires=Thu, 01 Jan 1970 00:00:00 GMT';
  }
}
