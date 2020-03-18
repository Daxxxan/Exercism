class Triangle {

    private double firstSide;
    private double secondSide;
    private double thirdSide;

    Triangle(double firstSide, double secondSide, double thirdSide) throws TriangleException {
        checkTriangleIsValid(firstSide, secondSide, thirdSide);
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    private void checkTriangleIsValid(double firstSide, double secondSide, double thirdSide) throws TriangleException {
        if(firstSide <= 0 || secondSide <= 0 || thirdSide <= 0) {
            throw new TriangleException();
        }

        if((firstSide + secondSide < thirdSide) || (secondSide + thirdSide < firstSide) || (thirdSide + firstSide < secondSide)) {
            throw new TriangleException();
        }
    }

    boolean isEquilateral() {
        return Double.compare(firstSide, secondSide) == 0 && Double.compare(secondSide, thirdSide) == 0;
    }

    boolean isIsosceles() {
        return Double.compare(firstSide, secondSide) == 0 || Double.compare(secondSide, thirdSide) == 0 || Double.compare(thirdSide, firstSide) == 0;
    }

    boolean isScalene() {
        return Double.compare(firstSide, secondSide) != 0 && Double.compare(secondSide, thirdSide) != 0 && Double.compare(thirdSide, firstSide) != 0;
    }

}
