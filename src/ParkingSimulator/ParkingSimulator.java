package ParkingSimulator;

import exceptions.InvalidValueException;

import java.util.ArrayList;
import java.util.Objects;

public class ParkingSimulator
{
    public static void main(String[] args)
    {
        /*
        4 ParkedCar objects and 4 ParkingMeter objects (one per car), and a PoliceOfficer object
        who assigns tickets as needed.
         */

        ArrayList<ParkedCar> cars = new ArrayList<>();

        //Creating my car objects and storing them into the cars ArrayList
        createNewCarObject(cars, "Toyota", "RAV4", "Ruby Flare Pearl", "KED9205", 104);
        createNewCarObject(cars, "Porsche", "Panamera", "Mamba Green Metallic", "ATT752", 45);
        createNewCarObject(cars, "BMW", "Z4", "Mediterranean Blue", "EEV2967", 260);
        createNewCarObject(cars, "Kia", "Forte", "Currant Red", "KGW4347", 125);

        ArrayList<ParkingMeter> meter = new ArrayList<>();

        //creating my meter objects and storing them into the meter ArrayList
        createNewMeterObject(meter, 60);
        createNewMeterObject(meter, 90);
        createNewMeterObject(meter, 60);
        createNewMeterObject(meter, 120);

        PoliceOfficer officer = null;
        try
        {
            //creating PoliceOfficer object
            officer = new PoliceOfficer("Max", "Goof", "57864");
        }
        catch (InvalidValueException invalidValueException)
        {
            System.out.println(invalidValueException.getMessage());
        }

        //loop through each car and parallel meter object and see if they should get a fine or not
        for (int i=0; i < cars.size(); i++)
        {
            if (officer != null && meter.get(i) != null)
                System.out.println(officer.issueTicket(cars.get(i), meter.get(i)));
            System.out.println();
        }
    }

    private static void createNewCarObject(ArrayList<ParkedCar> cars,
                                           String make, String model, String color, String license, int minutes)
    {
        ParkedCar car = null;
        try
        {
            car = new ParkedCar(make, model, color, license, minutes);
        }
        catch (InvalidValueException invalidValueException)
        {
            System.out.println(invalidValueException.getMessage());
        }

        if (car != null)
            cars.add(car);
    }

    private static void createNewMeterObject(ArrayList<ParkingMeter> meters, int minutesPurchased)
    {
        ParkingMeter parkingMeter = null;
        try
        {
            parkingMeter = new ParkingMeter(minutesPurchased);
        }
        catch (InvalidValueException invalidValueException)
        {
            System.out.println(invalidValueException.getMessage());
        }

        meters.add(parkingMeter);
    }
}
