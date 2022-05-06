import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AgregarMercanciaComponent } from './component/agregar-mercancia/agregar-mercancia.component';
import { DetalleMercanciaComponent } from './component/detalle-mercancia/detalle-mercancia.component';
import { MercanciasComponent } from './component/mercancias/mercancias.component';

const routes: Routes = [
   
  {
    path:'usuario/mercancia/:id',    
    component:MercanciasComponent,
    
  },
  {
    path:'usuario/mercancia/addMercancia/:id',
    component:AgregarMercanciaComponent
  },
  {
    path:'usuario/mercancia/detalleMercancia/:id/:idUsuario',
    component:DetalleMercanciaComponent    
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
