package com.example.raplaapp;

import dhbw.timetable.rapla.data.event.Appointment;
import dhbw.timetable.rapla.exceptions.NoConnectionException;
import dhbw.timetable.rapla.parser.DataImporter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class RaplaImporter {
    public static String getStundenplan(String link) throws IOException, NoConnectionException, IllegalAccessException {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Map<LocalDate, ArrayList<Appointment>> data = DataImporter.ImportWeekRange(LocalDate.now(), LocalDate.now().plusDays(5), link);
        }
        return null;
    }
}