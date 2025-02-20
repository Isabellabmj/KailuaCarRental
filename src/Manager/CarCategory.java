package Manager;

public class CarCategory
{
    private int categoryId;
    private String cName;

    public CarCategory(){}

    public CarCategory(int categoryId, String cName)
    {
        this.categoryId = categoryId;
        this.cName = cName;
    }

    public int getCatagoryId()
    {
        return categoryId;
    }

    public String getCName()
    {
        return cName;
    }

    public void setCategoryId(int categoryId)
    {
        this.categoryId = categoryId;
    }

    public void setCName(String cName)
    {
        this.cName = cName;
    }

    @Override
    public String toString()
    {
        return "CarCategory ID: " + categoryId + "\n"
                + "Catagory name: " + cName;
    }
}
