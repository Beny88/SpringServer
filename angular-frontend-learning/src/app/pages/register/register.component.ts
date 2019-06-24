import { Component, OnInit } from '@angular/core';
import {AuthorizationService} from "../../service/authorization.service";
import {Router} from "@angular/router";
import {equal} from "assert";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  login;
  password;
  rePassword;

  login_error = '';

  constructor(
    private authService: AuthorizationService,
    private router: Router
  ) {}

  ngOnInit() {
    this.login_error = window.localStorage.getItem('login_error');
    window.localStorage.setItem('login_error', '');
  }

  public registerIn() {
    //wiedziec co uzytkownik wpisal w tych dwoch polach

    console.log('login', this.login);
    console.log('password', this.password);
    console.log('rePassword', this.rePassword);
    console.log('Akcja rejestracja sie');
    //Tu bedziemy cos wysylali
    //ale  najperiw  musimy wiedziec co mamy wyslac

    const isLogged = this.authService.signIn(this.login, this.password);

    this.router.navigate(['']);

    //Czyscimy !
    this.login = '';
    this.password = '';
    this.rePassword = '';
  }

  public returnToMain(){
    this.router.navigate(['']);
  }

}
