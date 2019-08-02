import { Component, OnInit, Input } from '@angular/core';
import { StoryService } from 'src/service/story.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/service/category.service';
import { CategoryDTO } from 'src/dto/categorydto';
import { StoryDTO } from 'src/dto/storydto';
import { SharedService } from '../sharedservice/shared.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-stories',
  templateUrl: './stories.component.html',
  styleUrls: ['./stories.component.css']
})
export class StoriesComponent implements OnInit {

  stories: StoryDTO[] = [];
  subscription: Subscription;
 

  constructor(private storyService: StoryService, private sharedService: SharedService) {
    this.subscription = this.sharedService.$categorySource.subscribe(
      category => this.getStories(category)
    );

     }

  ngOnInit() {
  }

  getStories(category: CategoryDTO) {
 
    this.storyService.getAllByCategory(category)
      .subscribe(stories=>this.stories=stories);
    
  }

}
