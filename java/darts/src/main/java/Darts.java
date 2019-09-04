class Darts {

    private double x;
    private double y;
    private double outerCircleRadius = 10;
    private double middleCircleRadius = 5;
    private double innerCircleRadius = 1;

    Darts(double x, double y) {
        this.x = x;
        this.y = y;
    }

    boolean pointIsInTheCircle(double radius) {
        if(Math.pow(this.x, 2) + Math.pow(this.y, 2) <= Math.pow(radius, 2)) {
            return true;
        }
        return false;
    }

    int score() {
        final int SCORE_OUTSIDE = 0;
        final int SCORE_INNER_CIRCLE = 10;
        final int SCORE_MIDDLE_CIRCLE = 5;
        final int SCORE_OUTER_CIRCLE = 1;

        if(!pointIsInTheCircle(outerCircleRadius)) {
            return SCORE_OUTSIDE;
        } else {
            if(pointIsInTheCircle(innerCircleRadius)) {
                return SCORE_INNER_CIRCLE;
            } else if(pointIsInTheCircle(middleCircleRadius)) {
                return SCORE_MIDDLE_CIRCLE;
            } else {
                return SCORE_OUTER_CIRCLE;
            }
        }
    }

}
