import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UserLayoutComponent } from '../layout/user-layout/user-layout.component';
import { UsersComponent } from './users/users.component';
import { CategoryComponent } from 'src/app/user/category/category.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { StoryinsertComponent } from './storyinsert/storyinsert.component';

const routes: Routes = [
    { path: 'user-dashboard', component: UserLayoutComponent, children:[
      { path: '', component: UserDashboardComponent},
      { path: 'users', component: UsersComponent},
      { path: 'category/:id', component: CategoryComponent},
      { path: 'storyinsert', component: StoryinsertComponent},
      { path: 'category', component: CategoryComponent},
      { path: 'work-in-progress', component: WorkInProgressComponent}
    ]}
    // { path: 'category/:idCategory', component: CategoryComponent },
    
  ];
  
  @NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })
  export class UserRoutingModule { }