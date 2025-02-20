package TestDAO;

import DAO.CarDAO;
import Manager.Car;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Test
{
        public static void main(String[] args) {
            System.out.println("DAO test starter...");

            testAddCars();

        }


        public static void testAddCars()
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
        }
}


    /*public static void testAddCars()
    {
        Car car = new Car("Xpeng","G6","SP23485", Date.valueOf("2017-01-09"), 12530,2,3);

        int carID = CarDAO.addCar(car);
    }

    public static void main(String[] args)
    {
        System.out.println("DAO test");*/




