import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { CategoryDTO } from 'src/dto/categorydto';
import { StoryDTO } from 'src/dto/storydto';
import { StoryService } from 'src/service/story.service';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Location } from '@angular/common';

@Component({
  selector: 'app-storyinsert',
  templateUrl: './storyinsert.component.html',
  styleUrls: ['./storyinsert.component.css']
})
export class StoryinsertComponent implements OnInit {

  // @Input()
  // set toggle(toggle: boolean) {
  //   this.toggle = toggle;
  // }

  // @Output() sendBack = new EventEmitter();

  
  storytoinsert: StoryDTO = new StoryDTO();

  constructor(private storyService: StoryService) { }

  ngOnInit() {
  }

  insertStory(){
    this.storytoinsert.user = JSON.parse(localStorage.getItem('currentUser'));
    this.storytoinsert.category = JSON.parse(localStorage.getItem('currentCategory'));
    // this.storytoinsert.category = this.category;
    // console.log(this.storytoinsert);
    this.storyService.insert(this.storytoinsert)
    .subscribe();
    // this.storytoinsert.category = JSON.parse(localStorage.getItem('currentCategory'));
    this.storytoinsert = new StoryDTO();
    // this.toggle=!this.toggle;
  }


}
