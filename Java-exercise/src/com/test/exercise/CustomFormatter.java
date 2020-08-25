package com.test.exercise;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;


public class CustomFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            StringBuffer sb = new StringBuffer();
            sb.append(record.getMessage());
            return sb.toString();
        }

    }
