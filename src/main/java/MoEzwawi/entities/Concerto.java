package MoEzwawi.entities;

import MoEzwawi.entities.enums.EventType;
import MoEzwawi.entities.enums.GenereMusicale;

import java.time.LocalDate;

public class Concerto extends Event{
    private GenereMusicale genere;
    private boolean inStreaming;
    public Concerto(){

    }

    public Concerto(String title, LocalDate eventDate, EventType eventType, Location location, GenereMusicale genere, boolean inStreaming) {
        super(title, eventDate, eventType, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public GenereMusicale getGenere() {
        return genere;
    }

    public void setGenere(GenereMusicale genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", title='" + title + '\'' +
                '}';
    }
}
