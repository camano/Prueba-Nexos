import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MercanciasComponent } from './component/mercancias/mercancias.component';
import { NavComponent } from './component/nav/nav.component';
import { DetalleMercanciaComponent } from './component/detalle-mercancia/detalle-mercancia.component';
import { AgregarMercanciaComponent } from './component/agregar-mercancia/agregar-mercancia.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
    MercanciasComponent,
    NavComponent,
    DetalleMercanciaComponent,
    AgregarMercanciaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
