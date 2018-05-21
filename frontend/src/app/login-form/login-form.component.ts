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
      console.log(this.emailFormControl.value);
      console.log(this.passwordFormControl.value);
       this.authService.makeLogin().subscribe();
       this.authService.getInfo();
      localStorage.setItem('logged', 'true');
      localStorage.setItem('user', this.emailFormControl.value);
      this.router.navigateByUrl('/home');
    }
  }

}

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}
