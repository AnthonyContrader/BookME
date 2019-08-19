import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Usertype } from 'src/dto/usertype';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  userDTO: UserDTO = new UserDTO();

  constructor(private service: UserService, private router: Router) { }

  ngOnInit() {
  }
  insert() {
    
    this.userDTO.authorities = 'ROLE_USER';
    

    this.service.insert(this.userDTO).subscribe(() => {
          
            localStorage.setItem('currentUser', JSON.stringify(this.userDTO));
            this.router.navigate(['/user-dashboard']);
        });
  }

  

}
