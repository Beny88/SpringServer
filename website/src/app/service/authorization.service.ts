import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthorizationService {

  constructor() { }

  public signIn(login: string, password: string): boolean {
    console.log('AuthorizationService -> logowanie', login, password);
    return false;
  }
}
