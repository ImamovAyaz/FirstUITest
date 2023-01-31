package UI;

import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.chrono.Chronology;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;

public class WebDriverWait implements ChronoLocalDate, Temporal {
    public WebDriverWait(WebDriver driver, Duration duration) {
    }

    @Override
    public Chronology getChronology() {
        return null;
    }

    @Override
    public int lengthOfMonth() {
        return 0;
    }

    @Override
    public long until(Temporal endExclusive, TemporalUnit unit) {
        return 0;
    }

    @Override
    public ChronoPeriod until(ChronoLocalDate endDateExclusive) {
        return null;
    }

    @Override
    public long getLong(TemporalField field) {
        return 0;
    }
}
