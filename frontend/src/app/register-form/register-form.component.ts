import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {ErrorStateMatcher} from '@angular/material/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})

export class RegisterFormComponent implements OnInit {

  emailFormControl = new FormControl('', [
    Validators.required,
    Validators.email,
  ]);

  name;
  last;

  passwordFormControl = new FormControl('', [
    Validators.required,
  ]);

  matcher = new MyErrorStateMatcher();
  constructor(private authService: AuthService, private router: Router, public snackBar: MatSnackBar) { }

  ngOnInit() {
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  register() {
    if (!this.emailFormControl.hasError('email') && !this.emailFormControl.hasError('required')
    && !this.passwordFormControl.hasError('required')) {
  this.authService.register(this.emailFormControl.value, this.passwordFormControl.value).subscribe(
    (value) => {
      console.log(value);
      this.passwordFormControl.setValue(undefined);
      this.emailFormControl.setValue(undefined);
      this.emailFormControl.setErrors(undefined);
      this.passwordFormControl.setErrors(undefined);
      this.name = undefined;
      this.last = undefined;
      this.openSnackBar('You are registered', 'Now you can log in');
    },
    (err) => {
      console.log(err);
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
