import { Injectable, EventEmitter } from '@angular/core';
import { AbstractService } from './abstractservice';
import { CategoryDTO } from 'src/dto/categorydto';
import { HttpClient } from '@angular/common/http';
import { Observable, of, Subject, BehaviorSubject } from 'rxjs';

/**
 * I service sono decorati da @Injectable.
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class CategoryService extends AbstractService<CategoryDTO> {


  constructor(http: HttpClient) {
    super(http);
    this.type = 'category';
  }


}
