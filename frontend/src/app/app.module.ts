import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MainPageComponent } from './main-page/main-page.component';
import { RegisterFormComponent } from './register-form/register-form.component';
import { MatInputModule } from '@angular/material/input';
import { ErrorStateMatcher } from '@angular/material';
import { ShowOnDirtyErrorStateMatcher } from '@angular/material';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { LoginFormComponent } from './login-form/login-form.component';
import { HomeViewComponent } from './home-view/home-view.component';
import { MatTableModule } from '@angular/material/table';
import { MatSelectModule} from '@angular/material/select';
import { ProfileComponent } from './profile/profile.component';
import { BeerComponent } from './beer/beer.component';
import { HttpClientModule } from '@angular/common/http';

const appRoutes: Routes = [
  { path: '', component: MainPageComponent },
  { path: 'login', component: LoginFormComponent},
  { path: 'home', component: HomeViewComponent},
  { path: 'profile', component: ProfileComponent},
  { path: 'beer', component: BeerComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    RegisterFormComponent,
    LoginFormComponent,
    HomeViewComponent,
    ProfileComponent,
    BeerComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    ),
    BrowserModule,
    HttpClientModule,
    MatToolbarModule,
    MatButtonModule,
    MatInputModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    MatTableModule,
    MatSelectModule,
  ],
  providers: [{provide: ErrorStateMatcher, useClass: ShowOnDirtyErrorStateMatcher}],
  bootstrap: [AppComponent]
})
export class AppModule { }
