import { Component, OnInit, Input } from '@angular/core';
import { StoryService } from 'src/service/story.service';
import { ActivatedRoute } from '@angular/router';
import { CategoryService } from 'src/service/category.service';
import { CategoryDTO } from 'src/dto/categorydto';
import { StoryDTO } from 'src/dto/storydto';

@Component({
  selector: 'app-stories',
  templateUrl: './stories.component.html',
  styleUrls: ['./stories.component.css']
})
export class StoriesComponent implements OnInit {

  stories: StoryDTO[] = [];

  @Input()
  set category(category: CategoryDTO) {
    if(category != null && category != undefined){
      this.getStories(category);
    }
  }
 

  constructor(private categoryService: CategoryService, private storyService: StoryService, private route: ActivatedRoute) { }

  ngOnInit() {
  }

  getStories(category: CategoryDTO) {
 
    this.storyService.getAllByCategory(category)
      .subscribe(stories=>this.stories=stories);
    
  }

}
