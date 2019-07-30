import { Component, OnInit } from '@angular/core';
import { CategoryDTO } from 'src/dto/categorydto';
import { CategoryService } from 'src/service/category.service';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { StoryService } from 'src/service/story.service';
import { StoryDTO } from 'src/dto/storydto';


@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  category: CategoryDTO = new CategoryDTO();
  stories: StoryDTO[] = [];

  constructor(private storyService: StoryService, private categoryService: CategoryService, private route: ActivatedRoute) { }

 
  ngOnInit() {
    // this.category$ = this.route.paramMap.pipe(
    //   switchMap((params: ParamMap) =>
    //     this.service.getHero(params.get('id')))
    // );
    
    this.route.params.subscribe(routeParams => 
      this.getCategory(routeParams.id));
    
    
    // this.getCategory();
    
  }

  getCategory(id: number): void {
    // const id = +this.route.snapshot.paramMap.get('id');
    this.categoryService.read(id)
      .subscribe(category => {
        this.category = category;
        this.storyService.getAllByCategory(this.category)
      .subscribe(stories=>this.stories=stories);
      });
  }

  // getAllCategories() {
  //   this.categoryService.getAll().subscribe(categories => this.categories = categories);
  // }

  // delete(categorytodelete: CategoryDTO) {
  //   this.categoryService.delete(categorytodelete.idCategory).subscribe
  //   (
  //     () => this.getAllCategories()
  //   );
  // }

//   insert(categorytoinsert: CategoryDTO) {
//     this.categoryService.insert(categorytoinsert).subscribe
//     (
//       () => this.getAllCategories()
//     );
// }

// clear() {
//   this.categorytoinsert = new CategoryDTO();
// }

}
