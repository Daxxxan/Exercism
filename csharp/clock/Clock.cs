using System;

public class Clock
{
    private const int HoursPerDay = 24;
    private const int MinutesPerHour = 60;

    private int Hours { get; set; }
    private int Minutes { get; set; }

    public Clock(int hours, int minutes)
    {
        Hours = hours;
        Minutes = minutes;
        
        CalculateDate();   
    }

    private void CalculateDate()
    {
        HandleNegativeDate();
        
        int hoursInMinutes = CalculateNumberHoursInMinutes();
        
        Hours = CalculateNumberHoursForOneDay(Hours + hoursInMinutes);
        Minutes = CalculateNumberMinutesForOneHour();
    }
    
    private void HandleNegativeDate()
    {
        if (Minutes < 0)
        {
            HandleNegativeMinutes();
        }
     
        if (Hours < 0)
        {
            HandleNegativeHours();
        }
    }

    private int CalculateNumberHoursForOneDay(int hours) => hours % HoursPerDay;
    
    private int CalculateNumberMinutesForOneHour() => Minutes % MinutesPerHour;
    
    private int CalculateNumberHoursInMinutes() => Minutes / MinutesPerHour;

    private void HandleNegativeHours() => Hours = CalculateNumberHoursForOneDay(Hours) + 24;

    private void HandleNegativeMinutes()
    {
        Hours += (CalculateNumberHoursInMinutes() - 1);
        Minutes = CalculateNumberMinutesForOneHour() + 60;
    }
    
    public Clock Add(int minutesToAdd) => new Clock(Hours, Minutes + minutesToAdd);

    public Clock Subtract(int minutesToSubtract) => new Clock(Hours, Minutes - minutesToSubtract);

    public override string ToString() => FormatDate();

    private string FormatDate()
    {
        string hours = FormatIntClockToStringClock(Hours);
        string minutes = FormatIntClockToStringClock(Minutes);

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

    public override bool Equals(object obj) =>
        obj is Clock clock 
        && this.Hours == clock.Hours 
        && this.Minutes == clock.Minutes;
}
