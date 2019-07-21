import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import {FormsModule} from '@angular/forms';
import { RegisterComponent } from './pages/register/register.component';
import { ForherComponent } from './pages/forher/forher.component';
import { SmallLoginComponent } from './components/small-login/small-login.component';
import { HttpClientModule} from '@angular/common/http';
import {ProductService} from "./service/product.service";
import { PagesComponent } from './pages/pages.component';
import { CreateProductComponent } from './pages/create-product/create-product.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    ForherComponent,
    SmallLoginComponent,
    PagesComponent,
    CreateProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    ProductService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
