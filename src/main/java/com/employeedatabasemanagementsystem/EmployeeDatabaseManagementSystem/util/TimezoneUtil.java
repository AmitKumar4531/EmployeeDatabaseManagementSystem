package com.employeedatabasemanagementsystem.EmployeeDatabaseManagementSystem.util;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimezoneUtil {

    @Value("zone_Name")
    private static String zone_Name;
    // Simulate the remote server's timezone
    private static final ZoneId REMOTE_SERVER_ZONE = ZoneId.of(zone_Name); // Example timezone

    // Convert the current time to the remote server's timezone
    public static ZonedDateTime getCurrentRemoteServerTime() {
        return ZonedDateTime.now(REMOTE_SERVER_ZONE);
    }

    // Convert a local date-time to the remote server's timezone
    public static ZonedDateTime convertToRemoteServerTime(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(REMOTE_SERVER_ZONE);
    }

    // Convert a remote server's date-time to local timezone
    public static LocalDateTime convertToLocalTime(ZonedDateTime remoteDateTime) {
        return remoteDateTime.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();
    }
}
