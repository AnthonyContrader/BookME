import { Component, OnInit } from '@angular/core';
import { StoryService } from 'src/service/story.service';
import { StoryDTO } from 'src/dto/storydto';
import { UserDTO } from 'src/dto/userdto';
import { CategoryDTO } from 'src/dto/categorydto';
import { NovelDTO } from 'src/dto/novelsdto';

@Component({
  selector: 'app-stories',
  templateUrl: './stories.component.html',
  styleUrls: ['./stories.component.css']
})
export class StoriesComponent implements OnInit {

  stories: StoryDTO[] = [];
  storytoinsert: StoryDTO = new StoryDTO();
  user: UserDTO;

  constructor(private service: StoryService) { }

  ngOnInit() {
    this.getStories();
    this.user = JSON.parse(localStorage.getItem('currentUser'));
  }

  getStories(){
    this.service.getAll().subscribe
    (
      (stories) => this.stories = stories 
    );
  }

  insertStory(){
    this.storytoinsert.user = this.user;
    this.service.insert(this.storytoinsert).subscribe
    (
      () => {
              this.getStories();
              this.storytoinsert = new StoryDTO();
            }
    )
  }

  delete(story: StoryDTO){      
    this.service.delete(story.idStory).subscribe
    (
      () => this.getStories()
    );
  }
}
