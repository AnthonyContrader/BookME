import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CategoryComponent } from 'src/app/user/category/category.component';
import { StoryinsertComponent } from './storyinsert/storyinsert.component';
import { StoriesComponent } from './stories/stories.component';

const routes: Routes = [
  { path: '/category/:id', redirectTo: '/category/:id/stories', pathMatch: 'full' },
  { path: 'category/:id', component: CategoryComponent, children:[
    { path: 'stories', component: StoriesComponent},
    { path: 'storyinsert', component: StoryinsertComponent}
  ]}
  ];
  
  @NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
  })
  export class CategoryRoutingModule { }