package DAO;
import Database.ConnectToDatabase;
import Manager.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO
{
    public void addCustomer(Customer customer)
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

    public List<Customer> getAllCustomers()
    {
        List<Customer> customers = new ArrayList<>();
        String sqlShowCustomers = "select * from costumer";

        try(Connection connect = ConnectToDatabase.getConnection();
        Statement statement = connect.createStatement();
        ResultSet result = statement.executeQuery(sqlShowCustomers))
        {
            while(result.next())
            {
                Customer customer = new Customer
                        (result.getInt("CostumerID"),
                        result.getString("Cname"),
                        result.getString("Caddress"),
                        result.getString("Czip"),
                        result.getString("Ccity"),
                        result.getString("Ccellphone"),
                        result.getString("Cphone"),
                        result.getString("Cemail"),
                        result.getString("CdriverLicence"),
                        result.getDate("CdriverSince"));

                        customers.add(customer);

            }
            System.out.println("All customers loaded");
        } catch(SQLException e)
        {
            System.out.println("Error, can not get all customers" + e.getMessage());
            e.printStackTrace();
        }
        return customers;
    }

    public void deleteCustomer(int customerID)
    {
        String sqlDeleteCustomer = "delete from costumer where CostumerID = ?";

        try(Connection connect = ConnectToDatabase.getConnection();
        PreparedStatement statement = connect.prepareStatement(sqlDeleteCustomer))
        {
            statement.setInt(1, customerID);
            int deleteRow = statement.executeUpdate();

            if(deleteRow > 0)
            {
                System.out.println("Customer with ID:" + customerID + " has been deleted.");
            }
            else
            {
                System.out.println("No customer was deleted.");
            }
        }catch(SQLException e)
        {
            System.out.println("Error, can not delete costumer" + e.getMessage());
            e.printStackTrace();
        }
    }
}
