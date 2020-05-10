package grCodeHub.app;

public class Customer {
    //fields
    String surename;
    String lastname;
    String custCode;
    int bday, bmonth, byear;
    String phone;
    String address;
    String email;

    //construction

    public Customer () {
        custCode = null;
    }

    public Customer (String surenamename, String lastname, String custCode, int bday, int bmonth, int byear){
        this.surename = surenamename;
        this.lastname = lastname;
        this.custCode = custCode;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
    }
    public Customer (String surenamename, String lastname,  String custCode, int bday, int bmonth, int byear, String email, String phone){
        this.surename = surenamename;
        this.lastname = lastname;
        this.custCode = custCode;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
    }

    //getter methods, accessors
    //setters, modifiers, mutators
    public String getCustCode(){
        return custCode;
    }
    public void setCustCode(String custCode){
        this.custCode = custCode;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getBday() {
        return bday;
    }

    public void setBday(int bday) {
        this.bday = bday;
    }

    public int getBmonth() {
        return bmonth;
    }

    public void setBmonth(int bmonth) {
        this.bmonth = bmonth;
    }

    public int getByear() {
        return byear;
    }

    public void setByear(int byear) {
        this.byear = byear;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //toString
    @Override
    public String toString(){
        return "Fullname is " +surename+ " " +lastname+
        "\n with customer code: " +custCode+
        "\n Was born in " +bday+ "/" +bmonth+ "/" +byear+
        "\n Phone " +phone+ " and email " +email;
    }
}
