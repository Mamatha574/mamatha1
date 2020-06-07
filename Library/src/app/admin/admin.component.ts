import { Component, OnInit } from '@angular/core';
import { BooksService } from '../books.service';
import { FormBuilder, NgForm } from '@angular/forms';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  message: string;
  constructor(private per:FormBuilder, private bookService : BooksService) { }


  ngOnInit(): void {
  }

  postBook(form: NgForm){
    this.bookService.postData(form.value).subscribe(response =>{
      console.log(response);
      form.reset();
      if(!response.error){
        this.message = 'Book added successfully';
      }
    },error =>{
      console.log(error);
    });
   }
}
