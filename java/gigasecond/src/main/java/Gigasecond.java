import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private final int GIGASECOND = 1000000000;
    private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
        this.moment = moment.atStartOfDay().plusSeconds(GIGASECOND);
    }

    Gigasecond(LocalDateTime moment) {
        this.moment = moment.plusSeconds(GIGASECOND);
    }

    LocalDateTime getDateTime() {
        return this.moment;
    }

}
