export class Order{
frameName :String;
size : String;
material :String;
emailAddress : String;
address :String;
phoneNumber : String;
photoUrl :String;
comments : String;
orderState :String;

constructor(frameName :String,size : String,material :String,emailAddress : String,address :String,phoneNumber : String, photoUrl :String,comments : String,orderState :String){
this.frameName =frameName;
this.size = size;
this.material  =material;
this.emailAddress = emailAddress;
this.address =address;
this.phoneNumber = phoneNumber;
this.photoUrl =photoUrl;
this.comments = comments;
this.orderState=orderState ;

}


}