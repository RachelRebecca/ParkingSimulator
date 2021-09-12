package ParkingSimulator;

public class ParkingTicket {
    /*Class simulates a parking ticket*/

    private ParkedCar car;
    private PoliceOfficer officer;
    private int trackMinutes; //tracks how many minutes are being used when issuing the ticket


    //Empty constructor to fall back on, calling other empty constructors
    public ParkingTicket()
    {
        this.car = new ParkedCar();
        this.officer = new PoliceOfficer();
        this.trackMinutes = 0;
    }

    public ParkingTicket(String make, String model, String color, String license, int minutes,
                         String first, String last, String badge, int purchased)
    {
        setCar(make, model, color, license, minutes);
        setOfficer(first, last, badge);
        setTrackMinutes(purchased);
    }

    //getters:
    public ParkedCar getCar()
    {
        return this.car;
    }

    public PoliceOfficer getOfficer()
    {
        return this.officer;
    }

    //setters:
    public void setCar(String make, String model, String color, String license, int minutes)
    {
        this.car = new ParkedCar(make, model, color, license, minutes);
    }

    public void setOfficer(String first, String last, String badge)
    {
        this.officer = new PoliceOfficer(first, last, badge);
    }

    private void setTrackMinutes(int minutesPurchased)
    {
        if (car.getMinutes() >= minutesPurchased)
        {
            this.trackMinutes = this.car.getMinutes() - minutesPurchased;
        }
    }

    // returns the amount of the fine, which is $25 for the first hour or part of an hour that the car
    // is illegally parked, plus $10 for every additional hour or part of an hour that the car is illegally parked
    public double getFine()
    {
        if (this.trackMinutes > 0 && this.trackMinutes <= 60){
            return 25;
        }
        else if (this.trackMinutes > 60)
        {
            int afterHour = trackMinutes / 60;
            int total = 0;
            for (int i=0; i<afterHour + 1; i++)
            {
                total += 10;
            }
            return 25 + total;
        }
        else
        {
            return 0;
        }
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(getOfficer()).append("\n");
        builder.append(getCar()).append("\n");
        if (getFine() != 0)
        {
            builder.append("fine: $").append(getFine());
        }
        else
        {
            builder.append("no fine, $").append(getFine());
        }
        return builder.toString();
    }
}
