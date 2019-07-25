import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { StoryDTO } from 'src/dto/storydto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StoryService extends AbstractService<StoryDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'story';
  }

}
