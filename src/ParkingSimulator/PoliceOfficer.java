package ParkingSimulator;

import exceptions.InvalidValueException;

public class PoliceOfficer
{
    /*Class simulates a police officer inspecting parked cars. */

    private String first;
    private String last;
    private String badge;

    //Empty constructor to fall back on
    public PoliceOfficer()
    {
        this.first = null;
        this.last = null;
        this.badge = null;
    }

    public PoliceOfficer(String first, String last, String badge)
    {
        setFirst(first);
        setLast(last);
        setBadge(badge);
    }

    //getters:
    public String getFirst()
    {
        return this.first;
    }
    public String getLast()
    {
        return this.last;
    }
    public String getBadge()
    {
        return this.badge;
    }


    //setters:
    public void setFirst(String first)
    {
        if (first != null)
        {
            this.first = first;
        }
        else
        {
            throw new InvalidValueException();
        }
    }
    public void setLast(String last)
    {
        if (last != null)
        {
            this.last = last;
        }
        else
        {
            throw new InvalidValueException();
        }
    }
    public void setBadge(String badge)
    {
        if (badge != null)
        {
            this.badge = badge;
        }
        else
        {
            throw new InvalidValueException();
        }
    }

    //Examine a ParkedCar object and a ParkingMeter object and determine whether the car’s time has expired.
    public boolean isExpired(ParkedCar car, ParkingMeter purchased)
    {
        boolean expired = car.getMinutes() >= purchased.getMinutesPurchased();
        return expired;
    }

    //Issue a parking ticket if the car’s time has expired
    public String issueTicket(ParkedCar car, ParkingMeter purchased)
    {
        ParkingTicket ticket = new ParkingTicket(car.getMake(), car.getModel(), car.getColor(), car.getLicense(), car.getMinutes(),
                this.first, this.last, this.badge, purchased.getMinutesPurchased());
        if (isExpired(car, purchased))
        {
            return ticket.toString();
        }
        //if not, return an issueTicket that's $0.00 and says "clear"
        else
        {
            return ticket + "\n--- clear ---";
        }
    }

    public String toString()
    {
        return getFirst() + " " + getLast() + " " + getBadge();
    }
}
