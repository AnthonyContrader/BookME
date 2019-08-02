import { Injectable } from '@angular/core';
import { Subject }    from 'rxjs';
import { CategoryDTO } from 'src/dto/categorydto';
import { StoryDTO } from 'src/dto/storydto';

@Injectable(
  // {providedIn: 'root'}
  )
export class SharedService {

  private categorySource = new Subject<CategoryDTO>();
  // private storyInserted = new Subject<StoryDTO>();

  $categorySource = this.categorySource.asObservable();

  categoryUpdate(category: CategoryDTO){
    this.categorySource.next(category);
  }

  constructor() { }
}
