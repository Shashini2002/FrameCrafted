export class Order{

    address :String;
    comments : String;
    emailAddress : String;
    phoneNumber : String;
    photoUrl :String;
    orderState :String;
    itemCode :String;
    price: String;








constructor(address :String,
    comments : String,
    emailAddress : String,
    phoneNumber : String,
    photoUrl :String,
    orderState :String,
    itemCode :String,
    price: String

){
this.itemCode =itemCode;

this.emailAddress = emailAddress;
this.address =address;
this.phoneNumber = phoneNumber;
this.photoUrl =photoUrl;
this.comments = comments;
this.price=price;
this.orderState=orderState ;


}


}