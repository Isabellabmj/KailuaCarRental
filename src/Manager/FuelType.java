package Manager;

public class FuelType
{
    private int fuelTypeId;
    private String ftName;

    public FuelType(){}

    public FuelType(int fuelType, String ftName)
    {
        this.fuelTypeId = fuelType;
        this.ftName = ftName;
    }

    public int getFuelType()
    {
        return fuelTypeId;
    }

    public String getftName()
    {
        return ftName;
    }

    public void setFuelType(int fuelType)
    {
        this.fuelTypeId = fuelType;
    }

    public void setFtName(String ftName)
    {
        this.ftName = ftName;
    }

    @Override
    public String toString()
    {
        return "FuelType ID: " + fuelTypeId + "\n"
                + "Fuel type: " + ftName + "\n";
    }

}
