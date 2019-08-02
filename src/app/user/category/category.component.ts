import { Component, OnInit } from '@angular/core';
import { CategoryDTO } from 'src/dto/categorydto';
import { CategoryService } from 'src/service/category.service';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { StoryService } from 'src/service/story.service';
import { StoryDTO } from 'src/dto/storydto';
import { SharedService } from './sharedservice/shared.service';


@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css'],
  providers: [ SharedService ]
})
export class CategoryComponent implements OnInit {

  category: CategoryDTO = new CategoryDTO();

  constructor(private sharedService: SharedService, private categoryService: CategoryService, private route: ActivatedRoute)
   {
     sharedService.$categoryUpdated.subscribe(()=>this.notifyCategoryChange(this.category));
    }

  
  ngOnInit() {
    
    this.route.params.subscribe(routeParams =>
      this.getCategory(routeParams.id));
    }

    notifyCategoryChange(category: CategoryDTO) {
      this.sharedService.categoryUpdate(category);
    }
    
  getCategory(id: number): void {
    this.categoryService.read(id)
      .subscribe(category => {
        this.category = category;
        localStorage.setItem('currentCategory', JSON.stringify(category));
        this.notifyCategoryChange(category);
      });
  }

}
