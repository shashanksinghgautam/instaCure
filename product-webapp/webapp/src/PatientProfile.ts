import { User } from "./app/user";

export class Patient {
  email!: string;
  mobile!: number;
  dob!: string;
  address!: string;
  city!: string;
  country!: string;
  postalCode!: number;
  med!: string;

  user=new User()

  constructor() {}
}
