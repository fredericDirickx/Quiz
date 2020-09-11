package tech.dirickx.littlearithmetics.views;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;

public class StringFormat {

    public static String durationToString(Duration duration) {
        int hours = duration.toHoursPart();
        int minutes = duration.toMinutesPart();
        int seconds = duration.toSecondsPart();
        int millis = duration.toMillisPart();
        String hoursString = hours > 0 ? "" + hours + " h " : "";
        String minutesString = minutes > 0 ? "" + minutes + " m " : "";
        String secondsString = seconds > 0 ? "" + seconds + " s " : "0 s";
        return hoursString + "" + minutesString + "" + secondsString;
    }



    public static String IsCorrect(boolean isCorrect) {
        if (isCorrect) {
            return "correct";
        } else {
            return "wrong";
        }
    }

    public static String bigDecimalToString(BigDecimal bigDecimal){
        int scale = bigDecimal.scale();
        scale = Math.min(scale, 3);
        return bigDecimal
                .setScale(scale, RoundingMode.HALF_UP)
                .stripTrailingZeros()
                .toPlainString();
    }

}
