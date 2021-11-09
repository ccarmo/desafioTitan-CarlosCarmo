import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { DatePipe } from '@angular/common'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AdicionarcarroComponent } from './adicionarcarro/adicionarcarro.component';
import { EditarcarroComponent } from './editarcarro/editarcarro.component';
import { FinalizarcarroComponent } from './finalizarcarro/finalizarcarro.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { NgBootstrapFormValidationModule } from 'ng-bootstrap-form-validation';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    AdicionarcarroComponent,
    EditarcarroComponent,
    FinalizarcarroComponent
  ],
  imports: [
    BrowserModule,
    FontAwesomeModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgBootstrapFormValidationModule.forRoot(),
    NgBootstrapFormValidationModule
  
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
