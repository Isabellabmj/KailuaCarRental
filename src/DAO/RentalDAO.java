package DAO;

import Database.ConnectToDatabase;
import Manager.Rental;
import java.sql.Timestamp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentalDAO
{

    public List<Rental> showAllRentals()
    {
        List<Rental> rentals = new ArrayList<Rental>();
        String showRentalsSql = "select * from Rental";

        try(Connection connect = ConnectToDatabase.getConnection();
            PreparedStatement statement = connect.prepareStatement(showRentalsSql);
            ResultSet result = statement.executeQuery())
        {
            while(result.next())
            {
                Rental rental = new Rental(
                        result.getInt("RentalID"),
                        result.getInt("CustomerID"),
                        result.getInt("CarID"),
                        Timestamp.valueOf(result.getString("fronDate")),
                        Timestamp.valueOf(result.getString("toDate")),
                        result.getInt("maxKm"),
                        result.getInt("startKm"),
                        result.getInt("slutKm")
                );

                rentals.add(rental);
            }
            System.out.println("Rentals list:");
        }catch(SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        return rentals;
    }

    public void rentalContract(int CustomerID, int CarID, Date fromDate, Date toDate, int maxKm, int startKm, int slutKm)
    {


        String costumerSql = "select count(*) from costumer where CostumerID = ?";
        String carSql = "select count(*) from car where CarID = ?";
        String inputRentalstm = "insert into Rental (CostumerID, CarID, FromDate, ToDate, maxKm, startKm, slutKm) values (?,?,?,?,?,?,?)";

        try
                ( Connection con = ConnectToDatabase.getConnection();

                 PreparedStatement checkCos = con.prepareStatement(costumerSql);
                 PreparedStatement checkCar = con.prepareStatement(carSql);
                 PreparedStatement insertRentalStmt = con.prepareStatement(inputRentalstm, Statement.RETURN_GENERATED_KEYS))
        {
            checkCos.setInt(1,CustomerID);
            ResultSet customerRes = checkCos.executeQuery();
            customerRes.next();
            int costumerCount = customerRes.getInt(1);

            if(costumerCount == 0)
            {
                System.out.println("The customer with ID: " + CustomerID + " does not exist in the database");
            }

            checkCar.setInt(1,CarID);
            ResultSet carRes = checkCar.executeQuery();
            carRes.next();
            int carID = carRes.getInt(1);

            if(carID == 0)
            {
                System.out.println("The car with ID: " + carID + " does not exist in the database");
            }

            insertRentalStmt.setInt(1,CustomerID);
            insertRentalStmt.setInt(2,CarID);
            insertRentalStmt.setDate(3,fromDate);
            insertRentalStmt.setDate(4,toDate);
            insertRentalStmt.setInt(5,maxKm);
            insertRentalStmt.setInt(6,startKm);
            insertRentalStmt.setInt(7, slutKm);

            int insertRow = insertRentalStmt.executeUpdate();
            if(insertRow > 0)
            {
                ResultSet result = insertRentalStmt.getGeneratedKeys();
                if(result.next())
                {
                    int rentalID = result.getInt(1);
                    System.out.println("Rental contract made " + rentalID + " for customer " + CustomerID);
                }
            } else
            {
                System.out.println("Rental contract NOT made for customer " + CustomerID);
            }


        }catch(Exception e)
        {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        }


    }
}
