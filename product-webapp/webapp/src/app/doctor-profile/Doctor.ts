
import { Byte } from "@angular/compiler/src/util";
import { User } from "../user";

export class Doctor{
  user= new User()
  dob!: Date;
  gender!:string;
  address!: string;
  city!: string;
  state!: string;
  postalCode!: number;
  country!:string;
  educationQualifiaction!:string;
  speciality!:string;
  yearOfExpertise!: number;
  img!:string
  constructor() {}
}
