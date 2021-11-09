import { User } from "./User";
import { Value } from "./Value";

export class Movement {


    public date_entry: string;
    public date_exit:  string;
    public id:         number;
    public license_plate: string;
    public model_car:     string;
    public time:          string;
    public user:          User;
    public value:         Value;
    public value_paid:    number;       
}