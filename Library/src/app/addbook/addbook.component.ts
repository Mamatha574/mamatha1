import { Component, OnInit } from '@angular/core';
import { NgForm, FormBuilder } from '@angular/forms';
import { BooksService } from '../books.service';

@Component({
  selector: 'app-addbook',
  templateUrl: './addbook.component.html',
  styleUrls: ['./addbook.component.css']
})
export class AddbookComponent implements OnInit {

 
  message: string;
  error: any;
  constructor(private per:FormBuilder, private bookService : BooksService) { }


  ngOnInit(): void {
  }

  postBook(form: NgForm){
    this.bookService.postData(form.value).subscribe(response =>{
      console.log(response);
      form.reset();
      if(!response.error){
        this.message = 'Book added successfully';
         setTimeout(() => {
          this.error = null;
        }, 5000);
      }
    },error =>{
      console.log(error);
    });
   }


}
