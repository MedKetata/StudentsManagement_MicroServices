import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentComponent } from './student/student/student.component';
import { AddressComponent } from './address/address/address.component';


const routes: Routes = [

  {
    path:'',
    pathMatch:'full',
    redirectTo:'student'
  },
  {
    path:'student',
    pathMatch:'full',
    component:StudentComponent

  },
 
  {
    path:'address',
    pathMatch:'full',
    component:AddressComponent

  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
