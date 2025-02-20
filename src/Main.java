import DAO.CarDAO;
import DAO.CustomerDAO;
import DAO.RentalDAO;
import Manager.Car;
import Manager.Customer;
import Manager.Rental;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
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

                case 2:
                    deleteCar();
                    break;

                case 3:
                    showAllCars();
                    break;

                case 4:
                    addCustomer();
                    break;

                case 5:
                    showAllCustomers();
                    break;

                case 6:
                    createNewRentalContract();
                    break;

                case 7:
                    showAllRentalContracts();
                    break;

                case 8:
                    System.out.println("Exit program!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
            }


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

    public static void deleteCar() {
        System.out.println("Enter the Car ID to delete:");
        int carID = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        carDAO.deleteCar(carID);
    }

    public static void showAllCars()
    {
        List<Car> cars = carDAO.getAllCars();

        if (cars.isEmpty())
        {
            System.out.println("No cars found in the inventory.");
        } else
        {
            System.out.println("Cars in the inventory:");
            for (Car car : cars)
            {
                System.out.println(car);
            }
        }
    }

    public static void addCustomer()
    {
        System.out.println("Enter customer name:");
        String name = scanner.nextLine();

        System.out.println("Enter customer address:");
        String address = scanner.nextLine();

        System.out.println("Enter customers zip code:");
        String zipCode = scanner.nextLine();

        System.out.println("Enter customers city");
        String city = scanner.nextLine();

        System.out.println("Enter customer cellphone number (Can not be null): ");
        String cellphone = scanner.nextLine();

        System.out.println("Enter customer phone number (Can be null, just write null): ");
        String phone = scanner.nextLine();

        System.out.println("Enter customer email:");
        String email = scanner.nextLine();

        System.out.println("Enter customers drivers license:");
        String driverLicense = scanner.nextLine();

        System.out.println("Enter drivers license since (date):");
        String inputDate = scanner.nextLine();
        Date dateOfDriverslicense = Date.valueOf(inputDate);

        Customer customer = new Customer(0, name, address, zipCode, city, cellphone, phone, email, driverLicense, dateOfDriverslicense);
        customerDAO.addCustomer(customer);

    }

    public static void showAllCustomers()
    {
        List<Customer> customers = customerDAO.getAllCustomers();

        System.out.println("List of all customers:");
        if(customers.isEmpty())
        {
            System.out.println("No customers found in the inventory.");
        }
        else
        {
            for(Customer customer : customers)
            {
                System.out.println(customer + "\n");
            }
        }
    }

    public static void createNewRentalContract()
    {
        System.out.println("Create a new rental contract:");

        System.out.println("Choose existing Customers to create contract:");
        List<Customer> customers = customerDAO.getAllCustomers();
        for (Customer customer : customers)
        {
            System.out.println("Customer ID: " + customer.getCustomerID() + "\n");
        }

        System.out.print("Enter Customer ID from the list above: " + "\n");
        int customerID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Available Cars:");
        List<Car> cars = carDAO.getAllCars();
        for (Car car : cars)
        {
            System.out.println("ID: " + car.getCarId() + "\n");
        }

        System.out.print("Enter Car ID from the list above: " + "\n");
        int carID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter rental start date (YYYY-MM-DD HH:MM:SS): ");
        String fromDateInput = scanner.nextLine();
        Timestamp fromDate = Timestamp.valueOf(fromDateInput);
        scanner.nextLine();

        System.out.print("Enter rental end date (YYYY-MM-DD HH:MM:SS): ");
        String toDateInput = scanner.nextLine();
        Timestamp toDate = Timestamp.valueOf(toDateInput);
        scanner.nextLine();

        System.out.print("Enter max km allowed: ");
        int maxKm = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter car start km: ");
        int startKm = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter estimated end km: ");
        int endKm = scanner.nextInt();
        scanner.nextLine();

        rentalDAO.rentalContract(customerID, carID, fromDate, toDate, maxKm, startKm, endKm);

        System.out.println("Rental contract was successfully created");
    }

    public static void showAllRentalContracts()
    {
        List<Rental> rentals = rentalDAO.showAllRentals();

        if(rentals.isEmpty())
        {
            System.out.println("No rental contracts found.");
        }
        else
        {
            System.out.println("list of rental contracts");
            for(Rental rental : rentals)
            {
                System.out.println("Rental ID: " + rental.getRentalId());
                System.out.println("Customer ID: " + rental.getCustomerId());
                System.out.println("Car ID: " + rental.getCarId() + "\n");
                System.out.println("Start Date: " + rental.getFromDate());
                System.out.println("End Date: " + rental.getToDate());
                System.out.println("Max Km " + rental.getMaxKm());
                System.out.println("Start Km " + rental.getStartKm());
                System.out.println("End Km " + rental.getSlutkm());

            }
        }
    }



}