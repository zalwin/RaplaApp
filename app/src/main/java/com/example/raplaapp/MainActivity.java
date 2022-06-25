package com.example.raplaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

//    public Map<Integer, Vorlesung> Vorlesungen = new HashMap<>()
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rapla_table);
    }

/*
    private static void parseIncommingStringInList(String inCommingString) {
        String[] inhaltSplitted = inCommingString.split("\n");

        String dateMo = null;
        String dateDi = null;
        String dateMi = null;
        String dateDo = null;
        String dateFr = null;
        String weekday = "";

        //jede zeile aus dem web auf eine Vorlesung überprüfen, und Vorlesung erstellen
        for (int lineOfCodeFromWeb = 1; lineOfCodeFromWeb < inhaltSplitted.length; lineOfCodeFromWeb++) {
            //extract dates
            if (inhaltSplitted[lineOfCodeFromWeb].contains("</th><td class=\"week_header\"")) {
                String weekdate = inhaltSplitted[lineOfCodeFromWeb];

                String week = weekdate.split("</th><td class=\"week_header\"")[0];
                week = week.split("class=\"week_number\">")[1];

                dateMo = weekdate.split("\\.</nobr>")[0];
                dateDi = weekdate.split("\\.</nobr>")[1];
                dateMi = weekdate.split("\\.</nobr>")[2];
                dateDo = weekdate.split("\\.</nobr>")[3];
                dateFr = weekdate.split("\\.</nobr>")[4];

                dateMo = dateMo.split("<nobr>")[1];
                dateDi = dateDi.split("<nobr>")[1];
                dateMi = dateMi.split("<nobr>")[1];
                dateDo = dateDo.split("<nobr>")[1];
                dateFr = dateFr.split("<nobr>")[1];

                dateMo = dateMo.split(" ")[1];
                dateDi = dateDi.split(" ")[1];
                dateMi = dateMi.split(" ")[1];
                dateDo = dateDo.split(" ")[1];
                dateFr = dateFr.split(" ")[1];

                System.out.println(dateMo);
                System.out.println(dateDi);
                System.out.println(dateMi);
                System.out.println(dateDo);
                System.out.println(dateFr);

                dateMo = dateMo.strip();
                dateDi = dateDi.strip();
                dateMi = dateMi.strip();
                dateDo = dateDo.strip();
                dateFr = dateFr.strip();
            }

            //parsing Time and Name
            if (inhaltSplitted[lineOfCodeFromWeb].contains("[ Teiln]")) {

                //System.out.println(inhaltSplitted[lineOfCodeFromWeb]);

                String stringToSplit = inhaltSplitted[lineOfCodeFromWeb];

                String[] substrings = stringToSplit.split("\\[ Teiln]");   //[0]  [ Teiln]

//                for (int i = 0; i < substrings.length; i++) {
//                    System.out.println(substrings[i]);
//                }

                String substring = substrings[0];

                //System.out.println("\n" + substring);
                String name = substring.split("<br/>")[1];
                substring = substring.split("<br/>")[0];

                String endtime = substring.split("&#160;-")[1];
                substring = substring.split("&#160;-")[0];

                String starttime = "";

                if (substring.contains("<a href=\"#0\">")) {
                    starttime = substring.split("<a href=\"#0\">")[1];
                    substring = substring.split("<a href=\"#0\">")[0];
                }

                if (substring.contains("<a href=\"#1\">")) {
                    starttime = substring.split("<a href=\"#1\">")[1];
                    substring = substring.split("<a href=\"#1\">")[0];
                }

                if (substring.contains("<a href=\"#2\">")) {
                    starttime = substring.split("<a href=\"#2\">")[1];
                    substring = substring.split("<a href=\"#2\">")[0];
                }

                if (substring.contains("<a href=\"#3\">")) {
                    starttime = substring.split("<a href=\"#3\">")[1];
                    substring = substring.split("<a href=\"#3\">")[0];
                }

                if (substring.contains("<a href=\"#4\">")) {
                    starttime = substring.split("<a href=\"#4\">")[1];
                    substring = substring.split("<a href=\"#4\">")[0];
                }

                if (substring.contains("<a href=\"#5\">")) {
                    starttime = substring.split("<a href=\"#5\">")[1];
                    substring = substring.split("<a href=\"#5\">")[0];
                }

                if (substring.contains("<a href=\"#6\">")) {
                    starttime = substring.split("<a href=\"#6\">")[1];
                    substring = substring.split("<a href=\"#6\">")[0];
                }

                if (substring.contains("<a href=\"#7\">")) {
                    starttime = substring.split("<a href=\"#7\">")[1];
                    substring = substring.split("<a href=\"#7\">")[0];
                }

                if (substring.contains("<a href=\"#8\">")) {
                    starttime = substring.split("<a href=\"#8\">")[1];
                    substring = substring.split("<a href=\"#8\">")[0];
                }

                if (substring.contains("<a href=\"#9\">")) {
                    starttime = substring.split("<a href=\"#9\">")[1];
                    substring = substring.split("<a href=\"#9\">")[0];
                }

                if (substring.contains("<a href=\"#10\">")) {
                    starttime = substring.split("<a href=\"#10\">")[1];
                    substring = substring.split("<a href=\"#10\">")[0];
                }

                String substringDate = inhaltSplitted[lineOfCodeFromWeb + 1];
                String date = substringDate.split("</div>")[0];
                //System.out.println(date);

                //date = date.split("</div>")[1];
                date = date.replace("</div>", "");
                //System.out.println(date);

                //parsing date
                if (!date.contains("wöchentlich")) {
                    date = date.split(" ")[1];
                    date = date.split(" ")[0];

                    if (date.contains(".22")) {
                        date = date.split(".22")[0];
                    } else if (date.contains(".23")) {
                        date = date.split(".23")[0];
                    } else if (date.contains(".24")) {
                        date = date.split(".24")[0];
                    }

                    System.out.println("DATE:\n" + date);
                } else {
                    if (date.contains("Mo")) {
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
                if(date.contains(" ")){
                    date = date.split(" ")[1];
                }
                System.out.println("---" + date + "---");
                if (date.equals(dateMo)) {
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

                System.out.println();
                System.out.println(weekday);
                System.out.println(name);
                System.out.println(place);
                System.out.println(date);
                System.out.println(starttime + " - " + endtime);


                vorlesungen.put(vorlesungen.size()+1, new vorlesung(weekday, name, place, date, starttime, endtime));

            }
        }
    }

 */
}