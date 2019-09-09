class SpaceAge {

    private double seconds;
    private static final double EARTH_PERIOD = 365.25;

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
        return this.seconds / secondByYear(1);
    }

    double onMercury() {
        return this.seconds / secondByYear(0.2408467);
    }

    double onVenus() {
        return this.seconds / secondByYear(0.61519726);
    }

    double onMars() {
        return this.seconds / secondByYear(1.8808158);
    }

    double onJupiter() {
        return this.seconds / secondByYear(11.862615);
    }

    double onSaturn() {
        return this.seconds / secondByYear(29.447498);
    }

    double onUranus() {
        return this.seconds / secondByYear(84.016846);
    }

    double onNeptune() {
        return this.seconds / secondByYear(164.79132);
    }

}
