import { Component, OnInit } from '@angular/core';
import Editorial from '../../../../interfaces/editoriales';
import { EditorialesService } from '../../../../services/editoriales.service';

@Component({
  selector: 'app-editoriales',
  templateUrl: './editoriales.component.html',
  styleUrls: ['./editoriales.component.css']
})
export class EditorialesComponent implements OnInit {

  editorial: Editorial[] = [];
  
  constructor(private editorialService: EditorialesService) { }

  ngOnInit(): void {
    this.editorialService.getAllEditoriales().subscribe(data => {
      this.editorial = data;
    })
  }

}
