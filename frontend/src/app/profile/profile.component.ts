import { Component, OnInit } from '@angular/core';
import { BeerService, Filter } from '../beer.service';
import {MatSnackBar, ErrorStateMatcher} from '@angular/material';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

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
    date: '',
  };

  dateBasic;
  region;

  constructor(private beerService: BeerService, public snackBar: MatSnackBar, public authService: AuthService, public router: Router) { }

  ngOnInit() {
    if (localStorage.getItem('logged') === 'false') {
      this.router.navigateByUrl('');
    }
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
    if (this.beer.name === '' || this.beer.style === '' || this.beer.region === '' || this.beer.date === '' ) {
      this.openSnackBar('Error', 'Name, Style, Region and Production Date cannot be empty');
      return;
    }
    if (isNaN(Number(this.beer.abv)) || isNaN(Number(this.beer.ibu)) || isNaN(Number(this.beer.blg))
      || isNaN(Number(this.beer.left)) || isNaN(Number(this.beer.price))) {
      this.openSnackBar('Error', 'ABV, BLG, IBU, price and Quantity must be a number');
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
    this.router.navigateByUrl('');
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
    this.beer.date = '';
    this.beer.desc = '';
    this.beer.ibu = '';
    this.beer.left = '';
    this.beer.price = '';
    this.beer.region = '';
    this.dateBasic = undefined;
    this.region = undefined;
  }
}
