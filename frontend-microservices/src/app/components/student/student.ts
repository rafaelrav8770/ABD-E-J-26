import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { toSignal } from '@angular/core/rxjs-interop';

import { StudentService } from '../../services/student';

@Component({
  selector: 'app-student',
  standalone: true,

  imports: [CommonModule],

  templateUrl: './student.html',
  styleUrl: './student.css'
})

export class StudentComponent {

  private studentService = inject(StudentService);

  students = toSignal(this.studentService.getStudents(), { initialValue: [] });

}