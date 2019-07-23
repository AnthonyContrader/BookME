import { Component, OnInit } from '@angular/core';
import { CategoryDTO } from 'src/dto/categorydto';
import { CategoryService } from 'src/service/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  categories: CategoryDTO[];
  categorytoinsert: CategoryDTO = new CategoryDTO();

  constructor(private service: CategoryService) { }

  ngOnInit() {
    // this.getCategories();
  }

  getCategories() {
    this.service.getAll().subscribe(categories => this.categories = categories);
  }

  delete(category: CategoryDTO) {
    this.service.delete(category.id).subscribe(() => this.getCategories());
  }

  update(category: CategoryDTO) {
    this.service.update(category).subscribe(() => this.getCategories());
  }

  insert(category: CategoryDTO) {
    this.service.insert(category).subscribe(() => this.getCategories());
  }

  clear() {
    this.categorytoinsert = new CategoryDTO();
  }

}
