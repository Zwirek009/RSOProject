declare var require: any
import { Component, OnInit } from '@angular/core';
const data = require('../../assets/beer_mock.json');

@Component({
  selector: 'app-home-view',
  templateUrl: './home-view.component.html',
  styleUrls: ['./home-view.component.css']
})
export class HomeViewComponent implements OnInit {
  displayedColumns = ['name', 'style', 'abv', 'blg', 'ibu', 'date', 'left', 'price'];
  dataSource = ELEMENT_DATA;
  cities = ['Warsaw', 'Wroclaw', 'Gdansk', 'Poznan', 'Lodz'];
  constructor() { }

  ngOnInit() {
  }

}

export class TableBasicExample {
  displayedColumns = ['name', 'style', 'abv', 'blg', 'ibu', 'date', 'left', 'price'];
  dataSource = ELEMENT_DATA;
}

export interface Element {
  name: string;
  style: string;
  abv: number;
  blg: number;
  ibu: number;
  date: string;
  left: number;
  price: number;
}

const ELEMENT_DATA: Element[] = data;
