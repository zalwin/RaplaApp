import jdk.tools.jmod.Main;

public class Vorlesung extends MainActivity {
    
    private String name;
    private String ort;
    private String datum;
    private Time startzeit;
    private Time endzeit;

    public void setName(String name) {
        this.name = name;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setStartzeit(Time startzeit) {
        this.startzeit = startzeit;
    }

    public void setEndzeit(Time endzeit) {
        this.endzeit = endzeit;
    }

    public String getName() {
        return name;
    }

    public String getOrt(){
        return ort;
    }

    public String getDatum() {
        return datum;
    }

    public Time getStartzeit() {
        return startzeit;
    }

    public Time getEndzeit() {
        return endzeit;
    }
}