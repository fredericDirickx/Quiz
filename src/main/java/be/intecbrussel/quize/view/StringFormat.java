package be.intecbrussel.quize.view;

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

}
