package Manager;
import java.sql.Date;

public class Customer
{
    private int customerId;
    private String name;
    private String address;
    private String zip;
    private String city;
    private String cellphone;
    private String phone;
    private String email;
    private String driversLicense;
    private Date driverSince;

    public Customer(){}

    public Customer(int customerId, String name, String address, String zip, String city, String cellphone, String phone, String email, String driversLicense, Date driverSince)
    {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.cellphone = cellphone;
        this.phone = phone;
        this.email = email;
        this.driversLicense = driversLicense;
        this.driverSince = driverSince;
    }

    public int getCustomerID()
    {
        return customerId;
    }

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public String getZip()
    {
        return zip;
    }

    public String getCity()
    {
        return city;
    }

    public String getCellphone()
    {
        return cellphone;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }

    public String getDriversLicense()
    {
        return driversLicense;
    }

    public Date getDriverSince()
    {
        return driverSince;
    }


    public void setCustomerID(int customerID)
    {
        this.customerId = customerID;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setCellphone(String cellphone)
    {
        this.cellphone = cellphone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setDriversLicense(String driversLicense)
    {
        this.driversLicense = driversLicense;
    }

    public void setDriverSince(Date driverSince)
    {
        this.driverSince = driverSince;
    }

    @Override
    public String toString()
    {
        return "Customer ID " + customerId + "\n"
                + "Name: " + name + "\n"
                + "Address: " + address + "\n"
                + "Zip: " + zip + "\n"
                + "City: " + city + "\n"
                + "Cellphone number: " + cellphone + "\n"
                + "Phone number: " + phone + "\n"
                + "E-mail: " + email + "\n"
                + "Drivers license number: " + driversLicense + "\n"
                + "Driver since date: " + driverSince;
    }
}
