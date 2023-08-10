import { Injectable } from "@angular/core";

@Injectable()
export class User {
  id!: number;
  uname!:string;
  password!: string;
  email!: string;
  mobile!: string;
  role!: string;

  // constructor(id: number, name: string, password: string, email: string, mobile: number, role: string){
  //      this.id=id;
  //      this.password=password;
  //      this.name=name;
  //      this.mobile=mobile;
  //      this.email=email;
  //      this.role=role;
  // }
  constructor(){

  }
}
