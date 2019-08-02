import { Injectable } from '@angular/core';
import { Subject }    from 'rxjs';
import { CategoryDTO } from 'src/dto/categorydto';
import { StoryDTO } from 'src/dto/storydto';

@Injectable(
  // {providedIn: 'root'}
  )
export class SharedService {

  private categorySource = new Subject<CategoryDTO>();
  private categoryUpdated = new Subject<any>();

  $categorySource = this.categorySource.asObservable();
  $categoryUpdated = this.categoryUpdated.asObservable();

  categoryUpdate(category: CategoryDTO){
    this.categorySource.next(category);
  }

  reloadCategory(){
    this.categoryUpdated.next(null);
  }

  constructor() { }
}
