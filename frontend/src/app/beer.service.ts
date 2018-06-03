import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import * as config from './config';

@Injectable({
  providedIn: 'root'
})
export class BeerService {

  regions;
  beers;

  constructor(private http: HttpClient) { }

  getBeers(filter: Filter) {
    const enco: any = new HttpHeaders()
    .set('Content-Type', 'application/x-www-form-urlencoded')
    .set('X-Requested-With', 'XMLHttpRequest');
    const params = new HttpParams();
    this.http.get('http://localhost:3000/api/beer/find',
    { headers: enco, withCredentials: true, params: JSON.parse(filter.toJson()) }).subscribe(data => {
      this.beers = JSON.parse(data.toString());
      console.log(data);
    });
  }

  findRegionId(value: string): Number {
    let returned = 0;
    this.regions.forEach(element => {
      if (element.city.localeCompare(value) === 0) {
        returned = element.regionId;
      }
    });
    return returned;
  }

  getRegions() {
    const enco: any = new HttpHeaders()
    .set('Content-Type', 'application/x-www-form-urlencoded')
    .set('X-Requested-With', 'XMLHttpRequest');
    this.http.get('http://localhost:3000/api/region/get', { headers: enco, withCredentials: true }).subscribe(data => {
      this.regions = JSON.parse(data.toString());
      console.log(data);
    });
  }

  addBeer(beer: any) {
    const enco: any = new HttpHeaders()
      .set('Content-Type', 'application/x-www-form-urlencoded')
      .set('X-Requested-With', 'XMLHttpRequest');

    const body: any = new HttpParams()
      .set('userId', JSON.parse(localStorage.getItem('user')).id)
      .set('name', beer.name)
      .set('desc', beer.desc)
      .set('style', beer.style)
      .set('regionId', beer.region)
      .set('date', beer.date)
      .set('left', beer.left)
      .set('abv', beer.abv)
      .set('blg', beer.blg)
      .set('ibu', beer.ibu)
      .set('price', beer.price);
      console.log(body);
    return this.http.post('http://localhost:3000/api/beer/add',
      body.toString(),
      {
        headers: enco, withCredentials: true
      }
    );
  }
}

export class Filter {
  style: string;
  dateFrom: Number;
  dateTo: Number;
  userId: string;
  regionId: Number;

  constructor( style ?: string, dateFrom ?, dateTo ?, userId ?, regionId ?: Number ) {
    this.style = style || undefined;
    this.dateFrom = dateFrom || undefined;
    this.dateTo = dateTo || undefined;
    this.userId = userId || undefined;
    this.regionId = regionId || undefined;
  }

  toJson() {
    return JSON.stringify(this);
  }
}
