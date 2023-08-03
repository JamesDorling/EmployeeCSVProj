package org.employee_csv_proj.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return  LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(
                FormatStyle.SHORT)) + " " + record.getLevel() + ": " + record.getMessage()+ "\n";
    }
}