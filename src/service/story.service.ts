import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { StoryDTO } from 'src/dto/storydto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CategoryDTO } from 'src/dto/categorydto';

@Injectable({
  providedIn: 'root'
})
export class StoryService extends AbstractService<StoryDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'story';
  }

  getAllByCategory(category: CategoryDTO): Observable<StoryDTO[]> {
    return this.http.post<any>('http://localhost:8080/' + this.type + '/getbycategory', category);
  }
}
