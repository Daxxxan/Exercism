class SpaceAge {

    private double seconds;
    private static final double EARTH_PERIOD = 365.25;

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
        return earthYear * EARTH_PERIOD * 24 * 60 * 60;
    }

    double onEarth() {
        return this.seconds / secondByYear(Planet.EARTH.earthYear);
    }

    double onMercury() {
        return this.seconds / secondByYear(Planet.MERCURY.earthYear);
    }

    double onVenus() {
        return this.seconds / secondByYear(Planet.VENUS.earthYear);
    }

    double onMars() {
        return this.seconds / secondByYear(Planet.MARS.earthYear);
    }

    double onJupiter() {
        return this.seconds / secondByYear(Planet.JUPITER.earthYear);
    }

    double onSaturn() {
        return this.seconds / secondByYear(Planet.SATURN.earthYear);
    }

    double onUranus() {
        return this.seconds / secondByYear(Planet.URANUS.earthYear);
    }

    double onNeptune() {
        return this.seconds / secondByYear(Planet.NEPTUNE.earthYear);
    }

}
