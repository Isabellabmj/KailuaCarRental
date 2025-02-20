package Manager;
import java.sql.Date;

public class Car
{
    private int carID = 0;
    private String brand;
    private String model;
    private String regNr;
    private Date firstRegDate;
    private int odometer;
    private int categoryId;
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
        this.categoryId = catagoryId;
        this.fuelType = fuelType;
    }

    public int getCarId()
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

    public int getCategoryId()
    {
        return categoryId;
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
        this.categoryId = catagoryId;
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
                + "Catagory ID: " + categoryId + "\n"
                + "FuelType ID: " + fuelType;
    }
}