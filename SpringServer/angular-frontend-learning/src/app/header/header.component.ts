import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() { }

  jakasZmienna = 'jakas Zmienna';

  ngOnInit() {
  }

  public getJakisText(): string {
    return 'jakis string z funkcji';
  }
}
