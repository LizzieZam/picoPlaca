import { Component, OnInit } from '@angular/core';
import { FormControl, Validators, FormBuilder, FormGroup, AbstractControl } from '@angular/forms';
import { AutoServiceService } from '../auto-service.service';


@Component({
  selector: 'app-consulta-form',
  templateUrl: './consulta-form.component.html',
  styleUrls: ['./consulta-form.component.css']
})
export class ConsultaFormComponent implements OnInit {
  consultaForm:FormGroup;
  placa:AbstractControl;
  fecha: AbstractControl;
  minDate: Date;
  

   

  
  constructor(private fb: FormBuilder,private autoService: AutoServiceService) { 
  
  
    this.minDate=new Date();
    
  }

  ngOnInit() {
    this.consultaForm = this.fb.group({
      placa: new FormControl('',Validators.compose( [
        Validators.required,
        Validators.minLength(7),
        Validators.maxLength(8),
        Validators.pattern('[a-zA-Z]{3}-[0-9]{3,4}'),      
  
      ])),
      fecha: new FormControl('', Validators.required),
   
   
      
    });
    this.placa  = this.consultaForm.controls['placa'];
    this.fecha  = this.consultaForm.controls['fecha'];
  
  
  }
  submitted = false;
  respuesta:string;
  onSubmit() {this.submitted = true;
    
    this.autoService.search(this.consultaForm.value.placa,
      this.consultaForm.value.fecha,
    this.consultaForm.value.fecha).subscribe(
      (data) => { // Success
        this.respuesta = data;
        console.log(this.respuesta );
      },
      (error) => {
        console.error(error);
      }
    );
    
   
   
  }
}
