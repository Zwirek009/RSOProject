import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isLogged = false;

  constructor(private router: Router, private authService: AuthService, private cookieService: CookieService) {

  }

  logged(): boolean {
    if (localStorage.getItem('logged') === 'true') {
      return true;
    } else {
      return false;
    }
  }

  getLink(): [string] {
    if (localStorage.getItem('logged') === 'true')  {
      return ['home'];
    } else {
      return [''];
    }
  }

  getLinkNot(): [string] {
    if (localStorage.getItem('logged') === 'true')  {
      return [''];
    } else {
      return ['login'];
    }
  }

  logIn() {
    if (localStorage.getItem('logged') === 'true') {
      localStorage.setItem('logged', 'false');
      localStorage.setItem('user', undefined);
      this.authService.logout();
      this.router.navigateByUrl('');
    }
  }

  value(): string {
    if (localStorage.getItem('logged') === 'true')  {
      return 'Logout';
    } else {
      return 'Login';
    }
  }

  getUser(): string {
    const val = JSON.parse(localStorage.getItem('user'));
    return val.name;
  }
}
