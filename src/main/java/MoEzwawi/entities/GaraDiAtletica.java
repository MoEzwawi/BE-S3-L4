package MoEzwawi.entities;

import MoEzwawi.entities.enums.EventType;

import java.time.LocalDate;
import java.util.Set;

public class GaraDiAtletica extends Event{
    private Set<Person> setDiAtleti;
    private Person vincitore;

    public GaraDiAtletica(){

    }
    public GaraDiAtletica(String title, LocalDate eventDate, EventType eventType, Location location, Set<Person> setDiAtleti, Person vincitore) {
        super(title, eventDate, eventType, location);
        this.setDiAtleti = setDiAtleti;
        this.vincitore = vincitore;
    }

    public Set<Person> getSetDiAtleti() {
        return setDiAtleti;
    }

    public void setSetDiAtleti(Set<Person> setDiAtleti) {
        this.setDiAtleti = setDiAtleti;
    }

    public Person getVincitore() {
        return vincitore;
    }

    public void setVincitore(Person vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "gara"+ title+
                "vincitore=" + vincitore +
                '}';
    }
}
