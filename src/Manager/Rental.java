package Manager;
import java.sql.Timestamp;

public class Rental
{
    private int rentalId;
    private int customerId;
    private int carId;
    private Timestamp fromDate;
    private Timestamp toDate;
    private int maxKm;
    private int startKm;
    private int slutkm;

    public Rental(){}

    public Rental(int rentalId, int customerId, int carId, Timestamp fromDate, Timestamp toDate, int maxKm, int startKm, int slutkm)
    {
        this.rentalId = rentalId;
        this.customerId = customerId;
        this.carId = carId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.maxKm = maxKm;
        this.startKm = startKm;
        this.slutkm = slutkm;
    }

    public int getRentalId()
    {
        return rentalId;
    }

    public int getCustomerId()
    {
        return customerId;
    }

    public int getCarId()
    {
        return carId;
    }

    public Timestamp getFromDate()
    {
        return fromDate;
    }

    public Timestamp getToDate()
    {
        return toDate;
    }

    public int getMaxKm()
    {
        return maxKm;
    }

    public int getStartKm()
    {
        return startKm;
    }

    public int getSlutkm()
    {
        return slutkm;
    }

    public void setRentalId(int rentalId)
    {
        this.rentalId = rentalId;
    }

    public void setCustomerId(int customerId)
    {
        this.customerId = customerId;
    }

    public void setCarId(int carId)
    {
        this.carId = carId;
    }

    public void setFromDate(Timestamp fromDate)
    {
        this.fromDate = fromDate;
    }

    public void setToDate(Timestamp toDate)
    {
        this.toDate = toDate;
    }

    public void setMaxKm(int maxKm)
    {
        this.maxKm = maxKm;
    }

    public void setStartKm(int startKm)
    {
        this.startKm = startKm;
    }

    public void setSlutkm(int slutkm)
    {
        this.slutkm = slutkm;
    }

    @Override
    public String toString()
    {
        return "Rental ID: " + rentalId + "\n"
                + "Customer ID: " + customerId + "\n"
                + "Car ID: " + carId + "\n"
                + "From Date: " + fromDate + "\n"
                + "To Date: " + toDate + "\n"
                + "Max Km: " + maxKm + "\n"
                + "Start Km: " + startKm + "\n"
                + "Slut Km: " + slutkm + "\n";
    }
}
