import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-showusers',
  templateUrl: './showusers.component.html',
  styleUrls: ['./showusers.component.css']
})
export class ShowusersComponent implements OnInit {
  searchText;
  fieldName ="firstName";
  userbean;
  constructor(private bookService: BooksService, private router: Router) {
    this.getUserDetails();
  }

  ngOnInit(): void {
  }

  getUserDetails() {
    this.bookService.getUserData().subscribe(response => {
      console.log(response);
      this.userbean = response.usersInfo;
    }, error => {
      console.log(error);
    }
    );
  }

}
