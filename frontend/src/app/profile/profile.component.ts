import { Component, OnInit } from '@angular/core';
import { BeerService } from '../beer.service';
import {MatSnackBar} from '@angular/material';

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
    region: '1',
    date: '',
  };

  constructor(private beerService: BeerService, public snackBar: MatSnackBar) { }

  ngOnInit() {
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

  add() {
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

  get() {
    this.beerService.getAllBeers('1');
  }

  getRegion() {
    this.beerService.getRegions();
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
  }
}
