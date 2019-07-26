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

  constructor(private categoryService: CategoryService) { }

 
  ngOnInit() {
    this.getAllCategories();
  }

  getAllCategories() {
    this.categoryService.getAll().subscribe(categories => this.categories = categories);
  }

  delete(categorytodelete: CategoryDTO) {
    this.categoryService.delete(categorytodelete.id).subscribe
    (
      () => this.getAllCategories()
    );
  }

  insert(categorytoinsert: CategoryDTO) {
    this.categoryService.insert(categorytoinsert).subscribe
    (
      () => this.getAllCategories()
    );
}

clear() {
  this.categorytoinsert = new CategoryDTO();
}

}
