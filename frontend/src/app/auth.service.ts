import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login () {
    return this.http.post('', {

    })
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
