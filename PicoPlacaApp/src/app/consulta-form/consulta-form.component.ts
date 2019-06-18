import { Component, OnInit } from '@angular/core';
import { FormControl, Validators, FormBuilder, FormGroup, AbstractControl } from '@angular/forms';

@Component({
  selector: 'app-consulta-form',
  templateUrl: './consulta-form.component.html',
  styleUrls: ['./consulta-form.component.css']
})
export class ConsultaFormComponent implements OnInit {
  consultaForm:FormGroup;
  placa:AbstractControl;
  fecha: AbstractControl;
  hora:AbstractControl;
  
  
  
  constructor(private fb: FormBuilder ) { 
    
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
      hora: new FormControl('',Validators.required),
      
    });
    this.placa  = this.consultaForm.controls['placa'];
    this.fecha  = this.consultaForm.controls['fecha'];
    this.hora = this.consultaForm.controls['hora'];
  
  }
  submitted = false;
 
  onSubmit() {this.submitted = true;
    alert("La informacion ingresada fue :\nPlaca:"+
      this.consultaForm.value.placa+"\nFecha:"+
      this.consultaForm.value.fecha+"\nHora:"+
      this.consultaForm.value.hora
     );
    console.log(JSON.stringify(this.consultaForm.value));
  }
}
