import { Component, OnInit } from '@angular/core';
import { BeerService } from '../beer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-beer',
  templateUrl: './beer.component.html',
  styleUrls: ['./beer.component.css']
})
export class BeerComponent implements OnInit {

  constructor(public beerService: BeerService, private router: Router) { }

  ngOnInit() {
    if (localStorage.getItem('logged') === 'false') {
      this.router.navigateByUrl('');
    }
  }

}
