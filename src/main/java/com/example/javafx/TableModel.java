package com.example.javafx;

public class TableModel {
    String type, no,des,price,status,bed,guest;

    public TableModel(String type, String no, String des, String guest, String bed, String price, String status) {
        this.type = type;
        this.no = no;
        this.des = des;
        this.guest = guest;
        this.bed = bed;
        this.price = price;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public String getNo() {
        return no;
    }

    public String getDes() {
        return des;
    }

    public String getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public String getBed() {
        return bed;
    }

    public String getGuest() {
        return guest;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }
}
