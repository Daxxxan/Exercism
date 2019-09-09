class SpaceAge {

    private double seconds;
    private static final double EARTH_YEAR_IN_SECOND = 31557600;

    private enum Planet {
        MERCURY(0.2408467),
        VENUS(0.61519726),
        EARTH(1.),
        MARS(1.8808158),
        JUPITER(11.862615),
        SATURN(29.447498),
        URANUS(84.016846),
        NEPTUNE(164.79132);

        private double earthYear;

        Planet(double earthYear) {
            this.earthYear = earthYear;
        }
    }

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return this.seconds;
    }

    double secondByYear(double earthYear) {
        return earthYear * EARTH_YEAR_IN_SECOND;
    }

    double onEarth() {
        return getOrbitalAge(Planet.EARTH);
    }

    double onMercury() {
        return getOrbitalAge(Planet.MERCURY);
    }

    double onVenus() {
        return getOrbitalAge(Planet.VENUS);
    }

    double onMars() {
        return getOrbitalAge(Planet.MARS);
    }

    double onJupiter() {
        return getOrbitalAge(Planet.JUPITER);
    }

    double onSaturn() {
        return getOrbitalAge(Planet.SATURN);
    }

    double onUranus() {
        return getOrbitalAge(Planet.URANUS);
    }

    double onNeptune() {
        return getOrbitalAge(Planet.NEPTUNE);
    }

    private double getOrbitalAge(Planet planet) {
        return this.seconds / secondByYear(planet.earthYear);
    }
}
