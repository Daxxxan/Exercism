using System;

public class Clock
{
    private const int HoursPerDay = 24;
    private const int MinutesPerHour = 60;

    private int _hours;
    private int _minutes;

    public Clock(int hours, int minutes)
    {
        _hours = hours;
        _minutes = minutes;
        
        CalculateDate();   
    }

    private void CalculateDate()
    {
        HandleNegativeDate();
        
        int hoursInMinutes = CalculateNumberHoursInMinutes();
        
        _hours = CalculateNumberHoursForOneDay(_hours + hoursInMinutes);
        _minutes = CalculateNumberMinutesForOneHour();
    }
    
    private void HandleNegativeDate()
    {
        if (_minutes < 0)
        {
            HandleNegativeMinutes();
        }
     
        if (_hours < 0)
        {
            HandleNegativeHours();
        }
    }

    private int CalculateNumberHoursForOneDay(int hours) => hours % HoursPerDay;
    
    private int CalculateNumberMinutesForOneHour() => _minutes % MinutesPerHour;
    
    private int CalculateNumberHoursInMinutes() => _minutes / MinutesPerHour;

    private void HandleNegativeHours() => _hours = CalculateNumberHoursForOneDay(_hours) + 24;

    private void HandleNegativeMinutes()
    {
        _hours += (CalculateNumberHoursInMinutes() - 1);
        _minutes = CalculateNumberMinutesForOneHour() + 60;
    }
    
    public Clock Add(int minutesToAdd) => new Clock(_hours, _minutes + minutesToAdd);

    public Clock Subtract(int minutesToSubtract) => new Clock(_hours, _minutes - minutesToSubtract);

    public override string ToString() => FormatDate();

    private string FormatDate()
    {
        string hours = FormatIntClockToStringClock(_hours);
        string minutes = FormatIntClockToStringClock(_minutes);

        return hours + ":" + minutes;
    }

    private string FormatIntClockToStringClock(int time)
    {
        if (time < 10)
        {
            return "0" + time;
        }

        return time.ToString();
    }
}
