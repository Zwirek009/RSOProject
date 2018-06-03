declare var require: any;
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { BeerService } from '../beer.service';

@Component({
  selector: 'app-home-view',
  templateUrl: './home-view.component.html',
  styleUrls: ['./home-view.component.css']
})
export class HomeViewComponent implements OnInit {
  displayedColumns = ['name', 'style', 'abv', 'blg', 'ibu', 'date', 'left', 'price'];
  cities = [];
  router: Router;
  constructor(router: Router, private beerService: BeerService) {
    this.router = router;
  }

  ngOnInit() {
    this.beerService.getRegions();
    this.beerService.getAllBeers('1');
  }

  check(value: string) {
    this.router.navigateByUrl('/beer');
    console.log(value);
  }

}
