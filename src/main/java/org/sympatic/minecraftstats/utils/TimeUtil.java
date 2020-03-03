package org.sympatic.minecraftstats.utils;

public class TimeUtil {

    /**
     * Converts seconds into 00:00:00 format
     *
     * @param secs Seconds.
     * @return Formatted time.
     */
    public static String convert(int secs) {
        int h = secs / 3600, i = secs - h * 3600, m = i / 60, s = i - m * 60;
        String timeF = "";

        if (h < 10) {
            timeF = timeF + "";
        }
        timeF = timeF + h + " hour(s) ";
        if (m < 10) {
            timeF = timeF + "";
        }
        timeF = timeF + m + " minute(s) ";
        if (s < 10) {
            timeF = timeF + "";
        }
        timeF = timeF + s + " second(s) ";

        return timeF;
    }

}
