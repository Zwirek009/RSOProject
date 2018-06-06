declare var require: any;
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { BeerService, Filter } from '../beer.service';

@Component({
  selector: 'app-home-view',
  templateUrl: './home-view.component.html',
  styleUrls: ['./home-view.component.css']
})
export class HomeViewComponent implements OnInit {
  displayedColumns = ['name', 'style', 'abv', 'blg', 'ibu', 'date', 'left', 'price'];
  cities = [];
  router: Router;

  filterDateFrom;
  filterDateTo;
  filterRegion;
  filterStyle;

  constructor(router: Router, public beerService: BeerService) {
    this.router = router;
  }

  ngOnInit() {
    if (localStorage.getItem('logged') === 'false') {
      this.router.navigateByUrl('');
    }
    this.beerService.getRegions();
    this.beerService.getBeers(new Filter());
  }

  check(value: any) {
    this.beerService.beer = value;
    this.router.navigateByUrl('/beer');
    console.log(value);
  }

  filter() {
    const filterObj = new Filter();
    if (this.filterRegion !== undefined) {
      filterObj.regionId = this.beerService.findRegionId(this.filterRegion);
    }
    if (this.filterStyle !== undefined) {
      filterObj.style = this.filterStyle;
    }
    if (this.filterDateTo !== undefined) {
      filterObj.dateTo = this.filterDateTo.getTime();
    }
    if (this.filterDateFrom !== undefined) {
      filterObj.dateFrom = this.filterDateFrom.getTime();
    }
    this.beerService.getBeers(filterObj);
  }

  clear() {
    this.filterDateFrom = undefined;
    this.filterDateTo = undefined;
    this.filterRegion = undefined;
    this.filterStyle = undefined;
  }

}
