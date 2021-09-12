package ParkingSimulator;

import exceptions.InvalidValueException;

public class ParkingMeter
{
    /*Class simulates a parking meter.*/

    private int minutesPurchased;

    //empty constructor to fall back on
    public ParkingMeter()
    {
        this.minutesPurchased = 0;
    }

    public ParkingMeter(int purchased)
    {
        setMinutesPurchased(purchased);
    }

    //getter:
    public int getMinutesPurchased()
    {
        return this.minutesPurchased;
    }

    //setter:
    public void setMinutesPurchased(int purchased)
    {
        if (purchased >= 0)
        {
            this.minutesPurchased = purchased;
        }
        else
        {
            throw new InvalidValueException();
        }
    }

    public String toString()
    {
        return "minutes purchased: " + getMinutesPurchased();
    }

}
