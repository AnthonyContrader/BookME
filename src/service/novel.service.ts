import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { NovelDTO } from 'src/dto/novelsdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NovelService extends AbstractService<NovelDTO>{

  constructor(http: HttpClient) { 
    super(http);
    this.type = 'novel';
  }
}
