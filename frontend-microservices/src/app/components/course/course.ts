import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { toSignal } from '@angular/core/rxjs-interop';

import { CourseService } from '../../services/course';

@Component({
  selector: 'app-course',
  standalone: true,

  imports: [CommonModule],

  templateUrl: './course.html',
  styleUrl: './course.css'
})

export class CourseComponent {

  private courseService = inject(CourseService);

  courses = toSignal(this.courseService.getCourses(), { initialValue: [] });

}