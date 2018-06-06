import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import { AuthService } from '../auth.service';
import { CookieService } from 'ngx-cookie-service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  passwordFormControl = new FormControl('', [
    Validators.required,
  ]);

  matcher = new MyErrorStateMatcher();
  constructor(private authService: AuthService, private cookieService: CookieService, private router: Router) { }

  ngOnInit() {
  }

  login() {
    if (!this.emailFormControl.hasError('email') && !this.emailFormControl.hasError('required')
        && !this.passwordFormControl.hasError('required')) {
      this.authService.makeLogin(this.emailFormControl.value, this.passwordFormControl.value).subscribe(
        (value) => {
          console.log(value);
        },
        (err) => {
          if (err.status === 200) {
            localStorage.setItem('logged', 'true');
            localStorage.setItem('user', '{"id":1,"name":"' + this.emailFormControl.value + '","role":"USER"}');
            this.authService.getInfo();
            this.router.navigateByUrl('/home');
          }
        }
      );
    }
  }
}

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}
