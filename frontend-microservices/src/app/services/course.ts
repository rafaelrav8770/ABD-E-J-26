import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CourseService {

  private apiUrl = 'http://localhost:8080/api/course/all';

  constructor(private http: HttpClient) { }

  getCourses(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

}