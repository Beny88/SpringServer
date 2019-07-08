import { Component, OnInit } from '@angular/core';
import {AuthorizationService} from '../../service/authorization.service';

@Component({
  selector: 'app-small-login',
  templateUrl: './small-login.component.html',
  styleUrls: ['./small-login.component.css']
})
export class SmallLoginComponent implements OnInit {

  login: string;
  password: string;

  constructor(
    private authService: AuthorizationService,
  ) { }

  ngOnInit() {
  }

  public signIn() {
    this.authService.signIn(this.login, this.password);
  }

  register() {
  }
}
