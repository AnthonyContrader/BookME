import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UserLayoutComponent } from '../layout/user-layout/user-layout.component';
import { UsersComponent } from './users/users.component';
import { CategoryComponent } from './category/category.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';

const routes: Routes = [
    { path: 'user-dashboard', component: UserLayoutComponent, children:[
      { path: '', component: UserDashboardComponent},
      { path: 'users', component: UsersComponent},
      { path: 'category', component: CategoryComponent},
      { path: 'work-in-progress', component: WorkInProgressComponent}
    ]}
  ];
  
  @NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })
  export class UserRoutingModule { }