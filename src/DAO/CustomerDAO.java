package DAO;
import Database.ConnectToDatabase;
import Manager.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO
{
    public static void addCustomer(Customer customer)
    {
        String sqlAddCustomer = "insert into Costumer(Cname, Caddress, Czip, Ccity, Ccellphone, Cphone, Cemail, CdriverLicence, CdriverSince) values (?,?,?,?,?,?,?,?,?)";

        try(Connection connect = ConnectToDatabase.getConnection();
            PreparedStatement prepstm = connect.prepareStatement (sqlAddCustomer,Statement.RETURN_GENERATED_KEYS))
        {
            prepstm.setString(1,customer.getName());
            prepstm.setString(2,customer.getAddress());
            prepstm.setString(3,customer.getZip());
            prepstm.setString(4,customer.getCity());
            prepstm.setString(5,customer.getCellphone());
            prepstm.setString(6,customer.getPhone());
            prepstm.setString(7,customer.getEmail());
            prepstm.setString(8,customer.getDriversLicense());
            prepstm.setDate(9,customer.getDriverSince());

            int insertCustomer = prepstm.executeUpdate();
            if(insertCustomer > 0)
            {
                System.out.println("Customer has been added.");
            }

            ResultSet newKey = prepstm.getGeneratedKeys();
            if(newKey.next())
            {
                customer.setCustomerID(newKey.getInt(1));
                System.out.println("New customers ID number: " + customer.getCustomerID());
            } else
            {
                System.out.println("Customer was not added.");
            }
        } catch(SQLException e)
        {
            System.out.println("Error, can not add costumer" + e.getMessage());
            e.printStackTrace();
        }
    }
}
