import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CategoryComponent } from 'src/app/user/category/category.component';
import { StoryinsertComponent } from './storyinsert/storyinsert.component';
import { StoriesComponent } from './stories/stories.component';

const routes: Routes = [
  // { path: '', redirectTo: '/stories', pathMatch: 'full' },
    // { path: 'stories', component: StoriesComponent, children:[
    //   { path: 'storyinsert', component: StoryinsertComponent},
    // ]}
  ];
  
  @NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })
  export class UserRoutingModule { }