import { Component, OnInit } from '@angular/core';
import {AuthorizationService} from "../../service/authorization.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login;
  password;

  constructor(
    private authService: AuthorizationService,
    private router: Router
  ) {}

  ngOnInit() {
  }

  public signIn() {
    //wiedziec co uzytkownik wpisal w tych dwoch polach

    console.log('login', this.login);
    console.log('password', this.password);
    console.log('Akcja zaloguj sie');

    //Tu bedziemy cos wysylali
    //ale  najperiw  musimy wiedziec co mamy wyslac

    const isLogged = this.authService.signIn(this.login, this.password);
    if (isLogged == false) {
      window.localStorage.setItem('login_error', 'You have been redirected from login page');
      this.router.navigate(['register']);
    }
    else {
      //Czyscimy !
      this.login = '';
      this.password = '';
      this.router.navigate(['']);
    }
  }
}
