import { Component } from '@angular/core';

import { StudentComponent } from './components/student/student';
import { CourseComponent } from './components/course/course';

@Component({
  selector: 'app-root',
  standalone: true,

  imports: [StudentComponent, CourseComponent],

  templateUrl: './app.html',
  styleUrl: './app.css'
})

export class App {
}