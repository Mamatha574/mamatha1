import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddbookComponent } from './addbook/addbook.component';
import { AdminComponent } from './admin/admin.component';
import { ShowborrowComponent } from './showborrow/showborrow.component';
import { BooksComponent } from './books/books.component';
import { DeletebookComponent } from './deletebook/deletebook.component';
import { HomeComponent } from './home/home.component';
import { IssusebookComponent } from './issusebook/issusebook.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { RequestbookComponent } from './requestbook/requestbook.component';
import { ReturnbookComponent } from './returnbook/returnbook.component';
import { ShowrequestsComponent } from './showrequests/showrequests.component';
import { ShowusersComponent } from './showusers/showusers.component';
import { StudentComponent } from './student/student.component';
import { HeaderComponent } from './header/header.component';
import { SearchbookPipe } from './searchbook.pipe';
import { SearchUsersPipe } from './search-users.pipe';

@NgModule({
  declarations: [
    AppComponent,
    AddbookComponent,
    AdminComponent,
    ShowborrowComponent,
    BooksComponent,
    DeletebookComponent,
    HomeComponent,
    IssusebookComponent,
    LoginComponent,
    RegisterComponent,
    RequestbookComponent,
    ReturnbookComponent,
    ShowrequestsComponent,
    ShowusersComponent,
    StudentComponent,
    HeaderComponent,
    SearchbookPipe,
    SearchUsersPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
