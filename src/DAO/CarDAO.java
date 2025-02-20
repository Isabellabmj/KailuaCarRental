package DAO;
import Database.ConnectToDatabase;
import Manager.Car;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CarDAO
{
    public static void addCar(Car car)
    {
        String sqladd = "Insert into Car (brand, model, regNr, firstRegDate, odometer, CatagoryId, fuelTypeID) Values (?,?,?,?,?,?,?)";

        try(Connection connect = ConnectToDatabase.getConnection();
            PreparedStatement prepstm = connect.prepareStatement(sqladd))
        {
            prepstm.setString(1, car.getBrand());
            prepstm.setString(2, car.getModel());
            prepstm.setString(3, car.getRegNr());
            prepstm.setDate(4, car.getFirstRegDate());
            prepstm.setInt(5, car.getOdometer());
            prepstm.setInt(6, car.getCatagoryId());
            prepstm.setInt(7, car.getFuelType());
            System.out.println("Car successfully added");
        } catch (SQLException e)
        {
            System.out.println("Error, car not added");
        }

    }

    public static List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String sqlshow = "select * from Car";

        try (Connection connect = ConnectToDatabase.getConnection();
             Statement statement = connect.createStatement();
             ResultSet result = statement.executeQuery(sqlshow))
        {

            while (result.next())
            {
                Car car = new Car
                        (result.getInt("CarID"),
                        result.getString("brand"),
                        result.getString("model"),
                        result.getString("regNr"),
                        result.getDate("firstRegDate"),
                        result.getInt("odometer"),
                        result.getInt("categoryID"),
                        result.getInt("fuelTypeID")
                        );

                cars.add(car);
            }
            System.out.println("All cars loaded");

        } catch (SQLException e)
        {
            System.out.println("Could not show cars: " + e.getMessage());
        }
        return cars;
    }

    public static void deleteCar(int carID)
    {
        String sqldelete = "delete from Car where CarID = ?";

        try(Connection connection = ConnectToDatabase.getConnection();
            PreparedStatement prepstm = connection.prepareStatement(sqldelete))
        {
            prepstm.setInt(1, carID);
            prepstm.executeUpdate();
            System.out.println("Car was deleted");
        }
        catch(SQLException e)
        {
            System.out.println("Error deleting car: " + e.getMessage());
        }
    }
}
