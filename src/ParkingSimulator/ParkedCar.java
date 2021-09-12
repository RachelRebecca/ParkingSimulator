package ParkingSimulator;

import exceptions.InvalidValueException;

public class ParkedCar
{
    /*Class simulates a parked car. */

    private String make;
    private String model;
    private String color;
    private String license;
    private int minutes; //number of minutes car has been parked for already

    //Empty constructor to fall back on
    public ParkedCar()
    {
        this.make = null;
        this.model = null;
        this.color = null;
        this.license = null;
        this.minutes = 0;
    }

    public ParkedCar(String make, String model, String color, String license, int minutes)
    {
       setMake(make);
       setModel(model);
       setColor(color);
       setLicense(license);
       setMinutes(minutes);
    }

    //getters:
    public String getMake()
    {
        return this.make;
    }
    public String getModel()
    {
        return this.model;
    }
    public String getColor()
    {
        return this.color;
    }
    public String getLicense()
    {
        return this.license;
    }
    public int getMinutes()
    {
        return this.minutes;
    }

    //setters:
    //Even though information isn't likely to be changed, in case in error was entered in, these methods are included
    public void setMake(String make)
    {
        if (make != null)
        {
            this.make = make;
        }
        else
        {
            throw new InvalidValueException();
        }
    }
    public void setModel(String model)
    {
        if (model != null)
        {
            this.model = model;
        }
        else
        {
            throw new InvalidValueException();
        }
    }
    public void setColor(String color)
    {
        if (color != null)
        {
            this.color = color;
        }
        else
        {
            throw new InvalidValueException();
        }
    }
    public void setLicense(String license)
    {
        if (license != null)
        {
            this.license = license;
        }
        else
        {
            throw new InvalidValueException();
        }
    }

    //Sets number of minutes parked
    public void setMinutes(int minutes)
    {
        if (minutes >= 0)
        {
            this.minutes = minutes;
        }
        else
        {
            throw new InvalidValueException();
        }
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(getMake()).append(" ").append(getModel()).append(" ");
        builder.append(getColor()).append(" ").append(getLicense());
        builder.append("\nminutes parked: ").append(getMinutes());
        return builder.toString();
    }
}
