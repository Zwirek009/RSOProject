import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isLogged = false;

  logged(): boolean {
    return this.isLogged;
  }

  getLink(): [string] {
    if (this.isLogged) {
      return ['home'];
    } else {
      return [''];
    }
  }

  getLinkNot(): [string] {
    if (this.isLogged) {
      return [''];
    } else {
      return ['home'];
    }
  }

  logIn() {
    if (this.isLogged) {
      this.isLogged = false;
    } else {
      this.isLogged = true;
    }
  }

  value(): string {
    if (this.isLogged) {
      return 'Logout';
    } else {
      return 'Login';
    }
  }
}
