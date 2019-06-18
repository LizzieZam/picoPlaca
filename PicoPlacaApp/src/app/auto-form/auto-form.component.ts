import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder, AbstractControl } from '@angular/forms';
@Component({
  selector: 'app-auto-form',
  templateUrl: './auto-form.component.html',
  styleUrls: ['./auto-form.component.css']
})
export class AutoFormComponent implements OnInit {
  autoForm:FormGroup;
  placa:AbstractControl;
  color: AbstractControl;
  modelo:AbstractControl;
  chasis:AbstractControl;
  marca: AbstractControl;
 
  
  
  constructor(private fb: FormBuilder ) { 
    
  }

  ngOnInit() {
    this.autoForm = this.fb.group({
      placa: new FormControl('',Validators.compose( [
        Validators.required,
        Validators.minLength(7),
        Validators.maxLength(8),
        Validators.pattern('[a-zA-Z]{3}-[0-9]{3,4}'),      
  
      ])),
      color: new FormControl('', Validators.required),
      modelo: new FormControl('',Validators.required),
      chasis: new FormControl('', Validators.compose( [
        Validators.required,
        Validators.minLength(17),
        Validators.maxLength(17),
        Validators.pattern('[(0-9)*a-z(0-9)*A-Z(0-9)*]{3}[a-z0-9A-Z]{5}[0-9]{1}[a-zA-Z0-9]{1}[0-9]{7}'),             
  
      ])),
      marca: new FormControl('',Validators.required),
    });
    this.placa  = this.autoForm.controls['placa'];
    this.color  = this.autoForm.controls['color'];
    this.modelo = this.autoForm.controls['modelo'];
    this.chasis = this.autoForm.controls['chasis'];
    this.marca  = this.autoForm.controls['marca'];
  }
  submitted = false;
 
  onSubmit() {this.submitted = true;
    alert("La informacion ingresada fue :\nPlaca:"+
      this.autoForm.value.placa+"\nColor:"+
      this.autoForm.value.color+"\nModelo:"+
      this.autoForm.value.modelo+"\nChasis:"+
      this.autoForm.value.chasis+"\nMarca:"+
      this.autoForm.value.marca );
      localStorage.setItem("autos", JSON.stringify(this.autoForm.value));

    console.log(JSON.stringify(this.autoForm.value));
  }
}
