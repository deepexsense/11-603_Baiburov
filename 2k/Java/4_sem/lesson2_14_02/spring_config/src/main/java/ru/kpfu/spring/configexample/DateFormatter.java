package ru.kpfu.spring.configexample;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Alexander Ferenets (aka Istamendil) – http://istamendil.info
 */
public class DateFormatter {

  private String pattern = "d.MM.yyyy";

  public DateFormatter() {
  }

  public DateFormatter(String pattern) {
    this.pattern = pattern;
  }

  public String getDateFormatted(Calendar date) {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    return sdf.format(date.getTime());
  }

  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

}
