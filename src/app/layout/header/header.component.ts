import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { CategoryDTO } from 'src/dto/categorydto';
import { CategoryService } from 'src/service/category.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  categories: CategoryDTO[];
  user: UserDTO = new UserDTO();
  constructor(private categoryService: CategoryService, private router: Router) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.updateCategories();
  }

  updateCategories() {
    this.categoryService.getAll().subscribe( categories => this.categories = categories );
  }

  logout() {
    localStorage.clear();
  }
}
