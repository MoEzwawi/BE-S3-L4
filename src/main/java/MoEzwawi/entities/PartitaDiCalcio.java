package MoEzwawi.entities;

import MoEzwawi.entities.enums.EventType;

import java.time.LocalDate;

public class PartitaDiCalcio extends Event{
    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int golCasa;
    private int golOspite;

    public PartitaDiCalcio(){

    }

    public PartitaDiCalcio(String title, LocalDate eventDate, EventType eventType, Location location, String squadraDiCasa, String squadraOspite, int golCasa, int golOspite) {
        super(title, eventDate, eventType, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.golCasa = golCasa;
        this.golOspite = golOspite;
        if(golCasa > golOspite){
            this.squadraVincente = this.squadraDiCasa;
        } else if (golOspite > golCasa) {
            this.squadraVincente = this.squadraOspite;
        } else {
            this.squadraVincente = null;
        }
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolCasa() {
        return golCasa;
    }

    public void setGolCasa(int golCasa) {
        this.golCasa = golCasa;
    }

    public int getGolOspite() {
        return golOspite;
    }

    public void setGolOspite(int golOspite) {
        this.golOspite = golOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", golCasa=" + golCasa +
                ", golOspite=" + golOspite +
                '}';
    }
}
