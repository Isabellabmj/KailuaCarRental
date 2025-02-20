package TestDAO;

import DAO.CarDAO;
import DAO.CustomerDAO;
import DAO.RentalDAO;
import Manager.Car;
import Manager.Customer;
import Manager.Rental;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Test
{
        public static void main(String[] args)
        {
            System.out.println("DAO test starter...");

           // testAddCars();
           // testCustomer();
            testShowAllRentals();
            testRentalContract();



        }


        /*public static void testAddCars()
        {
            Car car = new Car(0, "Xpeng", "G6", "SP23485", Date.valueOf("2017-01-09"), 12530, 2, 3);

            CarDAO carDAO = new CarDAO();

            carDAO.addCar(car);

            List<Car> cars = CarDAO.getAllCars();
            for (Car c : cars)
            {
                System.out.println(c);
                System.out.println("\n");
            }
        }*/

        /*public static void testCustomer()
        {
            Customer customer = new Customer(0,"Lasse", "Aarhusgade 70", "2100", "København", "45903845", null, "Lasse@gmail.com", "DK58827312", Date.valueOf("2014-01-12"));

            CustomerDAO customerDAO = new CustomerDAO();

            customerDAO.addCustomer(customer);

            List<Customer> customers = customerDAO.getAllCustomers();
            for(Customer cus : customers)
            {
                System.out.println(cus);
                System.out.println("\n");
            }
        }*/

        /*public static void testRentalContract()
        {
            RentalDAO rentalDAO = new RentalDAO();

            int customerID = 3;
            int carID = 4;
            Date fromDate = new Date(2024-03-14);
            Date toDate = new Date(2024-03-18);
            int maxKm = 500;
            int startKm = 51723;
            int slutKm = 52129;

            rentalDAO.rentalContract(customerID, carID, fromDate, toDate, maxKm, startKm, slutKm);

        }*/

    public static void testRentalContract()
    {
        RentalDAO newRental = new RentalDAO();

        int CostumerID = 5;
        int carID = 2;
        Timestamp fromDate = Timestamp.valueOf("2025-02-20 10:00:00");
        Timestamp toDate = Timestamp.valueOf("2025-02-27 10:00:00");
        int maxKm = 1000;
        int startKm = 20350;
        int slutKm = 21150;

        newRental.rentalContract(CostumerID, carID, fromDate, toDate, maxKm, startKm, slutKm);
    }

    public static void testShowAllRentals()
    {
        RentalDAO dao = new RentalDAO();
        List<Rental> rentals = dao.showAllRentals();

        System.out.println("List of rentals: ");

        if(rentals.isEmpty())
        {
            System.out.println("No contracts to show");
        }
        else
        {
            System.out.println("Rental contracts:");
            for(Rental rental : rentals)
            {
                System.out.println(
                        "Rental ID: " + rental.getRentalId() + "\n"
                        + "Customer ID: " + rental.getCustomerId() + "\n"
                        + "Car ID: " + rental.getCarId() + "\n"
                        + "Start date for rental: " + rental.getFromDate() + "\n"
                        + "End date for rental: " + rental.getToDate() + "\n"+ "\n");
            }
        }
    }



}




