import { Component, OnInit } from '@angular/core';
import { BeerService, Filter } from '../beer.service';
import {MatSnackBar} from '@angular/material';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  beer = {
    name: '',
    style: '',
    abv: '',
    ibu: '',
    blg: '',
    left: '',
    price: '',
    desc: '',
    region: '',
    date: 0,
  };

  dateBasic;
  region;

  constructor(private beerService: BeerService, public snackBar: MatSnackBar, public authService: AuthService) { }

  ngOnInit() {
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  add() {
    if (this.dateBasic !== undefined) {
      this.beer.date = this.dateBasic.toISOString().slice(0, 10);
    }
    if (this.region !== undefined) {
      this.beer.region = this.beerService.findRegionId(this.region).toString();
    }
    if (this.beer.name === '' || this.beer.style === '') {
      this.openSnackBar('Error', 'Name and Style cannot be empty');
      return;
    }
    this.beerService.addBeer(this.beer).subscribe(
      (data) => {
        this.openSnackBar('Beer Added', data.toString());
        this.clear();
      },
      (err) => {
        this.openSnackBar('Error', err.toString());
      });
  }

  remove() {
    this.authService.remove();
  }

  getUser(): string {
    const val = JSON.parse(localStorage.getItem('user'));
    return val.name;
  }

  clear() {
    this.beer.name = '';
    this.beer.style = '';
    this.beer.abv = '';
    this.beer.blg = '';
    this.beer.date = 0;
    this.beer.desc = '';
    this.beer.ibu = '';
    this.beer.left = '';
    this.beer.price = '';
    this.beer.region = '';
    this.dateBasic = undefined;
    this.region = undefined;
  }
}
