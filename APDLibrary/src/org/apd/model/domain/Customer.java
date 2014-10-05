package org.apd.model.domain;

import org.apd.model.enums.PhoneType;

import java.util.Date;

public class Customer extends Base {
    private String firstName;
    private String lastName;
    private Housing housingInformation;
    private String email;
    private PhoneNumber phoneNumber1;
    private PhoneNumber phoneNumber2;
    String emergencyContactName;
    String emergencyContactPhone;
    private Date date;

    public Customer(String firstName, String lastName) {
        this(firstName, lastName, new Housing(), "", new PhoneNumber(), new PhoneNumber(), "", "", new Date());
    }

    public Customer(String firstName, String lastName, Housing housingInformation, String email, PhoneNumber phone1,
                    PhoneNumber phone2, String emergencyContactName, String emergencyContactPhone, Date date) throws IllegalArgumentException {
        if(lastName == null || lastName.equals("")) {
            throw new IllegalArgumentException("Last name cannot be null or empty.");
        }

        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setHousingInformation((housingInformation == null ? new Housing() : housingInformation));
        this.setEmail(email);
        this.setPhoneNumber1(phone1);
        this.setPhoneNumber2(phone2);
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
        this.setDate(date);
    }

    public String toCsv() {
        return Base.PrintStringNull(this.getLastName()) + "," +
                Base.PrintStringNull(this.getFirstName()) + "," +
                "," +
                this.getHousingInformation().toCsv() + "," +
                this.HomePhone() + "," +
                this.WorkPhone() + "," +
                this.MobilePhone() + "," +
                this.TTY() + "," +
                this.Fax() + "," +
                Base.PrintStringNull(this.emergencyContactName) + "," +
                Base.PrintStringNull(this.emergencyContactPhone) + "," +
                super.dateFormat.format(this.getDate());
    }

    private String HomePhone() {
        if (this.getPhoneNumber1().getType() == PhoneType.Home) {
            return this.getPhoneNumber1().toCsv();
        } else if (this.getPhoneNumber2().getType() == PhoneType.Home) {
            return this.getPhoneNumber2().toCsv();
        } else {
            return "";
        }
    }

    private String WorkPhone() {
        if (this.getPhoneNumber1().getType() == PhoneType.Work) {
            return this.getPhoneNumber1().toCsv() + "," + Base.PrintStringNull(this.getPhoneNumber1().getExtension());
        } else if (this.getPhoneNumber2().getType() == PhoneType.Work) {
            return this.getPhoneNumber2().toCsv() + "," + Base.PrintStringNull(this.getPhoneNumber2().getExtension());
        } else {
            return ",";
        }
    }

    private String MobilePhone() {
        if (this.getPhoneNumber1().getType() == PhoneType.Mobile) {
            return this.getPhoneNumber1().toCsv();
        } else if (this.getPhoneNumber2().getType() == PhoneType.Mobile) {
            return this.getPhoneNumber2().toCsv();
        } else {
            return "";
        }
    }

    private String TTY() {
        if (this.getPhoneNumber1().getType() == PhoneType.TTY) {
            return this.getPhoneNumber1().toCsv();
        } else if (this.getPhoneNumber2().getType() == PhoneType.TTY) {
            return this.getPhoneNumber2().toCsv();
        } else {
            return "";
        }
    }

    private String Fax() {
        if (this.getPhoneNumber1().getType() == PhoneType.Fax) {
            return this.getPhoneNumber1().toCsv();
        } else if (this.getPhoneNumber2().getType() == PhoneType.Fax) {
            return this.getPhoneNumber2().toCsv();
        } else {
            return "";
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Housing getHousingInformation() {
        return housingInformation;
    }

    public void setHousingInformation(Housing housingInformation) {
        this.housingInformation = housingInformation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PhoneNumber getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(PhoneNumber phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public PhoneNumber getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(PhoneNumber phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
