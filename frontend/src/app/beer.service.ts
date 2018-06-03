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

  getBeer(beerId: string) {
    const enco: any = new HttpHeaders()
    .set('Content-Type', 'application/x-www-form-urlencoded')
    .set('X-Requested-With', 'XMLHttpRequest');
    this.http.get('http://localhost:3000/api/beer/get/' + beerId, { headers: enco, withCredentials: true }).subscribe(data => {
      console.log(data);
    });
  }

  getAllBeers(userId: string) {
    const enco: any = new HttpHeaders()
    .set('Content-Type', 'application/x-www-form-urlencoded')
    .set('X-Requested-With', 'XMLHttpRequest');
    this.http.get('http://localhost:3000/api/beer/get_by_user/' + userId, { headers: enco, withCredentials: true }).subscribe(data => {
      this.beers = JSON.parse(data.toString());
      console.log(data);
    });
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

  getByRegion(regionId: string) {
    const enco: any = new HttpHeaders()
    .set('Content-Type', 'application/x-www-form-urlencoded')
    .set('X-Requested-With', 'XMLHttpRequest');
    this.http.get('http://localhost:3000/api/beer/get_by_region/' + regionId, { headers: enco, withCredentials: true }).subscribe(data => {
      console.log(data);
    });
  }

  getByUser(userId: string) {
    const enco: any = new HttpHeaders()
    .set('Content-Type', 'application/x-www-form-urlencoded')
    .set('X-Requested-With', 'XMLHttpRequest');
    this.http.get('http://localhost:3000/api/beer/get_by_user/' + userId, { headers: enco, withCredentials: true }).subscribe(data => {
      console.log(data);
    });
  }

  getByStyle(style: string) {
    const enco: any = new HttpHeaders()
    .set('Content-Type', 'application/x-www-form-urlencoded')
    .set('X-Requested-With', 'XMLHttpRequest');
    this.http.get('http://localhost:3000/api/beer/get_by_style/' + style, { headers: enco, withCredentials: true }).subscribe(data => {
      console.log(data);
    });
  }

  getYounger() {

  }

  getOlder () {

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
