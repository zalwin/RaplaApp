package com.example.raplaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public Map<Integer, Vorlesung> Vorlesungen = new HashMap<>()
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private void parseIncommingStringInList(String inCommingString){
        String[] inhaltSplitted = inCommingString.split("\n");

        String dateMo;
        String dateDi;
        String dateMi;
        String dateDo;
        String dateFr;

        //jede zeile aus dem web auf eine Vorlesung überprüfen, und Vorlesung erstellen
        for (int lineOfCodeFromWeb = 1; lineOfCodeFromWeb < inhaltSplitted.length; lineOfCodeFromWeb++) {
            //extract dates
            if(inhaltSplitted[n].contains("</th><td class=\"week_header\"")){
                String weedate = inhaltSplitted[n];

                String week = weedate.split("</th><td class=\"week_header\"")[0];
                week = week.split("class=\"week_number\">")[1];

                dateMo = weekdate.split(".</nobr>")[0];
                dateDi = weekdate.split(".</nobr>")[1];
                dateMi = weekdate.split(".</nobr>")[2];
                dateDo = weekdate.split(".</nobr>")[3];
                dateFr = weekdate.split(".</nobr>")[4];

                dateMo = dateMo.strip();
                dateDi = dateDi.strip();
                dateMi = dateMi.strip();
                dateDo = dateDo.strip();
                dateFr = dateFr.strip();
            }

            //parsing Time and Name
            if(inhaltSplitted[n].contains("[ Teiln]")){
                String weekday;
                String substring = inhaltSplitted[n].split("[ Teiln]")[0];
                String name = substring.rsplit("<br/>")[1];
                substring = substring.rsplit("<br/>")[0];

                String endtime = substring.rsplit("&#160;-")[1];
                substring = substring.rsplit("&#160;-")[0];

                String starttime = "";

                if(substring.contains('<a href="#0">')){
                    starttime = substring.rsplit('<a href="#0">')[1]
                    substring = substring.rsplit('<a href="#0">')[0]
                }

                if(substring.contains('<a href="#1">')){
                    starttime = substring.rsplit('<a href="#1">')[1]
                    substring = substring.rsplit('<a href="#1">')[0]
                }

                if(substring.contains('<a href="#2">')){
                    starttime = substring.rsplit('<a href="#2">')[1]
                    substring = substring.rsplit('<a href="#2">')[0]
                }

                if(substring.contains('<a href="#3">')){
                    starttime = substring.rsplit('<a href="#3">')[1]
                    substring = substring.rsplit('<a href="#3">')[0]
                }

                if(substring.contains('<a href="#4">')) {
                    starttime = substring.rsplit('<a href="#4">')[1]
                    substring = substring.rsplit('<a href="#4">')[0]
                }

                if(substring.contains('<a href="#5">')){
                    starttime = substring.rsplit('<a href="#5">')[1]
                    substring = substring.rsplit('<a href="#5">')[0]
                }

                if(substring.contains('<a href="#6">')){
                    starttime = substring.rsplit('<a href="#6">')[1]
                    substring = substring.rsplit('<a href="#6">')[0]
                }

                if(substring.contains('<a href="#7">')){
                    starttime = substring.rsplit('<a href="#7">')[1]
                    substring = substring.rsplit('<a href="#7">')[0]
                }

                if(substring.contains('<a href="#8">')){
                    starttime = substring.rsplit('<a href="#8">')[1]
                    substring = substring.rsplit('<a href="#8">')[0]
                }

                if(substring.contains('<a href="#9">')){
                    starttime = substring.rsplit('<a href="#9">')[1]
                    substring = substring.rsplit('<a href="#9">')[0]
                }

                if(substring.contains('<a href="#10">')){
                    starttime = substring.rsplit('<a href="#10">')[1]
                    substring = substring.rsplit('<a href="#10">')[0]
                }

                String substringDate = inhaltSplitted[n+1];
                String date = substringDate.split("</div>")[0];
                date = date.split("</div>")[1];

                //parsing date
                if(!date.contains("wöchentlich")){
                    date = date.split(" ")[1];
                    date = date.split(" ")[0];

                    if(date.contains(".22")){
                        date = date.split(".22")[0];
                    }
                    else if(date.contains(".23")){
                        date = date.split(".23")[0];
                    }
                    else if(date.contains(".24")){
                        date = date.split(".24")[0];
                    }
                }else {
                    if (date.contains("Mo")){
                        date = dateMo;
                    } else if (date.contains("Di")) {
                        date = dateDi;
                    } else if (date.contains("Mi")) {
                        date = dateMi;
                    } else if (date.contains("Do")) {
                        date = dateDo;
                    } else if (date.contains("Fr")) {
                        date = dateFr;
                    }
                }

                //parsing weekday
                if(date.equals(dateMo)){
                    weekday = "Mo";
                } else if (date.equals(dateDi)) {
                    weekday = "Di";
                } else if (date.equals(dateMi)) {
                    weekday = "Mi";
                } else if (date.equals(dateDo)) {
                    weekday = "Do";
                } else if (date.equals(dateFr)) {
                    weekday = "Fr";
                }

                String place = substringDate.split("</div>")[1];
                place = place.split("<strong>")[1];
                place = place.split("</strong>")[0];

                vorlesungen.put(vorlesungen.size()+1, new vorlesung(weekday, name, place, date, starttime, endtime));

            }
        }

    }
}