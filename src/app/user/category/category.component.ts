import { Component, OnInit } from '@angular/core';
import { CategoryDTO } from 'src/dto/categorydto';
import { CategoryService } from 'src/service/category.service';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { StoryService } from 'src/service/story.service';
import { StoryDTO } from 'src/dto/storydto';


@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  category: CategoryDTO = new CategoryDTO();
  stories: StoryDTO[] = [];
  toggle: boolean = true;

  constructor(private storyService: StoryService, private categoryService: CategoryService, private route: ActivatedRoute) { }

 
  ngOnInit() {

    this.route.params.subscribe(routeParams => 
      this.getCategory(routeParams.id));

    
  }

  getCategory(id: number): void {
    this.categoryService.read(id)
      .subscribe(category => {
        this.category = category;
        localStorage.setItem('currentCategory', JSON.stringify(this.category));
        this.storyService.getAllByCategory(this.category)
      .subscribe(stories=>this.stories=stories);
      });
  }

  toggleComponent(){
    this.toggle = !this.toggle;
  }

}
