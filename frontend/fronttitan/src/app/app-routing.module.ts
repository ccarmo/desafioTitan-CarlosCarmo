import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdicionarcarroComponent } from './adicionarcarro/adicionarcarro.component';
import { EditarcarroComponent } from './editarcarro/editarcarro.component';
import { FinalizarcarroComponent } from './finalizarcarro/finalizarcarro.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
   {path:'', redirectTo: 'adicionarcarro', pathMatch:'full'},
   {path:'login', component: LoginComponent},
   {path:'home', component: HomeComponent},
   {path: 'adicionarcarro', component: AdicionarcarroComponent},
   {path: 'editarcarro', component: EditarcarroComponent},
   {path: 'finalizarcarro', component: FinalizarcarroComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
