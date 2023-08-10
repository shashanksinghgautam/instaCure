package com.stackroute.medicine.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("medicine")
public class Medicine{ 
	public Medicine(int mid, String medicinename, int qnt, int price,  String category) {
		super();
		this.mid = mid;
		this.medicinename = medicinename;
		this.qnt = qnt;
		this.price = price;
//		this.mimage = mimage;
		this.category = category;
	}
	public Medicine() {
		super();
	}

@Id
private int mid;
private String medicinename;
private int qnt;
private int price;
//private Image mimage;
private String category;
public String getMedicinename() {
	return medicinename;
}
public void setMedicinename(String medicinename) {
	this.medicinename = medicinename;
}
public int getQnt() {
	return qnt;
}
public void setQnt(int qnt) {
	this.qnt = qnt;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
//public Image getMimage() {
//	return mimage;
//}
//public void setMimage(Image mimage) {
//	this.mimage = mimage;
//}
public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}

}
