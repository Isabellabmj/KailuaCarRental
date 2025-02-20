import DAO.CarDAO;
import DAO.CustomerDAO;
import DAO.RentalDAO;
import Manager.Car;

import java.sql.Date;
import java.util.Scanner;

public class Main
{
    private static final Scanner scanner = new Scanner(System.in);
    private static CarDAO carDAO = new CarDAO();
    private static CustomerDAO customerDAO = new CustomerDAO();
    private static RentalDAO rentalDAO = new RentalDAO();


    public static void main(String[] args)
    {
        while(true)
        {
            System.out.println("Kailua Rental, choose a number corresponding to your choice");
            System.out.println("1. Add a new car");
            System.out.println("2. delete a car");
            System.out.println("3. Show all cars that are in the inventory");
            System.out.println("4. Add a new customer");
            System.out.println("5. Show all customers");
            System.out.println("6. Create a new rental contract");
            System.out.println("7. Show all contracts");
            System.out.println("8. Exit the program");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice)
            {
                case 1:
                    addCar();
                    break;
            }
            scanner.close();

        }

    }

    public static void addCar()
    {
        System.out.println("Enter brand:");
        String brand = scanner.nextLine();

        System.out.println("Enter model:");
        String model = scanner.nextLine();

        System.out.println("Enter registration number:");
        String regNr = scanner.nextLine();

        System.out.println("Enter first registration date (YYYY-MM-DD): ");
        String dateInput = scanner.nextLine();
        Date date = Date.valueOf(dateInput);

        System.out.println("Add odometer:");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter category ID:");
        int categoryID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter fuel type:");
        int fuelType = scanner.nextInt();
        scanner.nextLine();

        Car car = new Car(0, brand, model, regNr, date, odometer, categoryID, fuelType);
        carDAO.addCar(car);
    }

}