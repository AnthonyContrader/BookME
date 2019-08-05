import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { CategoryDTO } from 'src/dto/categorydto';
import { StoryDTO } from 'src/dto/storydto';
import { StoryService } from 'src/service/story.service';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Location } from '@angular/common';
import { SharedService } from '../sharedservice/shared.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-storyinsert',
  templateUrl: './storyinsert.component.html',
  styleUrls: ['./storyinsert.component.css']
})
export class StoryinsertComponent implements OnInit {


  storytoinsert: StoryDTO = new StoryDTO();
  subscription: Subscription;

  constructor(private storyService: StoryService, private sharedService: SharedService) { 
    // this.subscription = this.sharedService.$categorySource.subscribe(
    //   category => this.storytoinsert.category = category
    // );
  }

  ngOnInit() {
  }

  insertStory(){
    this.storytoinsert.user = JSON.parse(localStorage.getItem('currentUser'));
    this.storytoinsert.category = JSON.parse(localStorage.getItem('currentCategory'));
    this.storyService.insert(this.storytoinsert)
    .subscribe();
    this.sharedService.reloadCategory();
    // this.storytoinsert = new StoryDTO();
  }


}
