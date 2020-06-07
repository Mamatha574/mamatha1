import { Injectable } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BooksService {

  myURL = 'http://localhost:8080/librarymanagementsystemspringrest/';

  constructor(private formBuilder: FormBuilder, private http: HttpClient) {

  }

  registeration(userDetails) {
    return this.http.post<any>(`${this.myURL}addUser`, userDetails);
  }
  login(userDetails) {
    return this.http.post<any>(`${this.myURL}login`, userDetails);
  }
  postData(bookbean) {
    return this.http.post<any>(`${this.myURL}addBook`, bookbean);
  }
  deleteData(book) {
    return this.http.delete<any>(`${this.myURL}deleteBook/${book.bid}`);
  }
  getData() {
    return this.http.get<any>(`${this.myURL}getBooksInfo`);
  }
  requestData(bid) {
    return this.http.post<any>(`${this.myURL}requestBook`, bid);
  }
  issueData(book) {
    return this.http.post<any>(`${this.myURL}issueBook`, book);
  }
  returnBook(book) {
    return this.http.post<any>(`${this.myURL}returnBook`, book);
  }
  showIssuedBooks() {
    return this.http.get<any>(`${this.myURL}showIssuedBooks`);
  }
  showBorrows() {
    return this.http.get<any>(`${this.myURL}getBorrowedBooks`);
  }
  showRequests() {
    return this.http.get<any>(`${this.myURL}showRequests`);
  }


  getBorrowedData() {
    return this.http.get<any>(`${this.myURL}getBorrowedBooks`);
  }

  getUserData() {
    return this.http.get<any>(`${this.myURL}showUsers`);
  }
}
