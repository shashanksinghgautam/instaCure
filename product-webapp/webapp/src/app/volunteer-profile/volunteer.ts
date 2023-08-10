import { Byte } from "@angular/compiler/src/util";
import { User } from "../user";

export class Volunteer {

    User = new User()
    email:any=[];
    vid!: number;
    city!: string;
    state! : string;
    address!:string;
    zipcode!:number;
    image!:Byte[]

    constructor(){}
}
