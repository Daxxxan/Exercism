using System;

public class SpaceAge
{
    private double _seconds;
    private static double EARTH_YEAR_IN_SECOND = 31557600;

    private struct Planet
    {
        public const double Earth = 1;
        public const double Mercury = 0.2408467;
        public const double Venus = 0.61519726;
        public const double Mars = 1.8808158;
        public const double Jupiter = 11.862615;
        public const double Saturn = 29.447498;
        public const double Uranus = 84.016846;
        public const double Neptune = 164.79132;
    }

    public SpaceAge(int seconds)
    {
        _seconds = seconds;
    }

    public double OnEarth()
    {
        return GetOrbitalAge(Planet.Earth);
    }

    public double OnMercury()
    {
        return GetOrbitalAge(Planet.Mercury);
    }

    public double OnVenus()
    {
        return GetOrbitalAge(Planet.Venus);
    }

    public double OnMars()
    {
        return GetOrbitalAge(Planet.Mars);
    }

    public double OnJupiter()
    {
        return GetOrbitalAge(Planet.Jupiter);
    }

    public double OnSaturn()
    {
        return GetOrbitalAge(Planet.Saturn);
    }

    public double OnUranus()
    {
        return GetOrbitalAge(Planet.Uranus);
    }

    public double OnNeptune()
    {
        return GetOrbitalAge(Planet.Neptune);
    }

    public double GetOrbitalAge(double planetOrbitalYear)
    {
        return (_seconds / EARTH_YEAR_IN_SECOND) / planetOrbitalYear;
    }
}