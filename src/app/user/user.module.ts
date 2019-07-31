import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserRoutingModule } from './user-routing.module';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { CategoryComponent } from './category/category.component';
import { StoryinsertComponent } from './storyinsert/storyinsert.component';


/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [UserDashboardComponent, UsersComponent, WorkInProgressComponent, CategoryComponent, StoryinsertComponent],
  imports: [
    CommonModule,
    UserRoutingModule,
    FormsModule
  ]
})
export class UserModule { }
