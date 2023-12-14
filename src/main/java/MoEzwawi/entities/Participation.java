package MoEzwawi.entities;

import MoEzwawi.entities.enums.ParticipationState;

import javax.persistence.*;

@Entity
@Table(name="participations")
public class Participation {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Person person;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    @Enumerated(EnumType.STRING)
    private ParticipationState state;

    public Participation() {
    }
    public Participation(Person person, Event event, ParticipationState state) {
        this.person = person;
        this.event = event;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public ParticipationState getState() {
        return state;
    }

    public void setState(ParticipationState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Participation{" +
                "person=" + person +
                ", event=" + event.getTitle() +
                ", state=" + state +
                '}';
    }
}
