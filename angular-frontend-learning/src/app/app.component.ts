import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-frontend-learning';
  tomson = 'Tomson114234sdefs';

  public nazwaMetody() {
    this.tomson = 'nazwaMetody';
  }

  public nazwaMetody2() {
    this.tomson = 'nazwaMetody2';
  }
}
