package Manager;
import java.sql.Date;

public class Car
{
    private int carID;
    private String brand;
    private String model;
    private String regNr;
    private Date firstRegDate;
    private int odometer;
    private int catagoryId;
    private int fuelType;

    public Car(){}

    public Car(int carId, String brand, String model, String regNr, Date firstRegDate, int odometer, int catagoryId, int fuelType)
    {
        this.carID = carId;
        this.brand = brand;
        this.model = model;
        this.regNr = regNr;
        this.firstRegDate = firstRegDate;
        this.odometer = odometer;
        this.catagoryId = catagoryId;
        this.fuelType = fuelType;
    }

    public int getId()
    {
        return carID;
    }

    public String getBrand()
    {
        return brand;
    }

    public String getModel()
    {
        return model;
    }

    public String getRegNr()
    {
        return regNr;
    }

    public Date getFirstRegDate()
    {
        return firstRegDate;
    }

    public int getOdometer()
    {
        return odometer;
    }

    public int getCatagoryId()
    {
        return catagoryId;
    }

    public int getFuelType()
    {
        return fuelType;
    }

    public void setCarID(int carID)
    {
        this.carID = carID;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public void setRegNr(String regNr)
    {
        this.regNr = regNr;
    }

    public void setRegDate(Date regDate)
    {
        this.firstRegDate = regDate;
    }

    public void setFirstRegDate(Date firstRegDate)
    {
        this.firstRegDate = firstRegDate;
    }

    public void setCatagoryId(int catagoryId)
    {
        this.catagoryId = catagoryId;
    }

    public void setOdometer(int odometer)
    {
        this.odometer = odometer;
    }

    public void setFuelType(int fuelType)
    {
        this.fuelType = fuelType;
    }

    @Override
    public String toString()
    {
        return "Car ID: " + carID + "\n"
                + "Brand: " + brand + "\n"
                + "Model: " + model + "\n"
                + "Registration number: " + regNr + "\n"
                + "Odometer: " + odometer + "\n"
                + "Catagory ID: " + catagoryId + "\n"
                + "FuelType ID: " + fuelType;
    }
}