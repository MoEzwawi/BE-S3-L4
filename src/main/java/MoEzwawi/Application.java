package MoEzwawi;

import MoEzwawi.dao.EventDAO;
import MoEzwawi.dao.ParticipationDAO;
import MoEzwawi.dao.PersonDAO;
import MoEzwawi.entities.*;
import MoEzwawi.entities.enums.EventType;
import MoEzwawi.entities.enums.Gender;
import MoEzwawi.entities.enums.ParticipationState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("events_management");
    private static Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        EventDAO eventDAO = new EventDAO(em);
        PersonDAO personDAO = new PersonDAO(em);
        ParticipationDAO participationDAO = new ParticipationDAO(em);

        LocalDate aldosB = Event.parseDateForItaly("28/09/1958");
        LocalDate giovannisB = Event.parseDateForItaly("20/02/1957");
        LocalDate giacomosB = Event.parseDateForItaly("26/04/1956");
        LocalDate marinasB = Event.parseDateForItaly("16/05/1963");
        LocalDate future = Event.parseDateForItaly("02/05/2024");

        Location piazza = new Location("Piazza","Bagnone");
        Location stadio = new Location("San Siro","Milano");
        Location teatro = new Location("Scala","Milano");

        Person aldo = new Person("Aldo","Baglio","aldo@email",aldosB,Gender.MALE);
        Person giovanni = new Person("Giovanni","Storti","giovanni@email",giovannisB,Gender.MALE);
        Person giacomo = new Person("Giacomo","Poretti","giacomo@email",giacomosB,Gender.MALE);
        Person marina = new Person("Marina","Massironi","marina@email",marinasB,Gender.FEMALE);
        personDAO.save(aldo);
        personDAO.save(giovanni);
        personDAO.save(giacomo);
        personDAO.save(marina);
        Event p = new PartitaDiCalcio("match",future,EventType.PUBLIC,stadio,"Atalanta","Villareal",4,1);
        Set<Person> cast = new HashSet<>();
        cast.add(aldo);
        cast.add(giovanni);
        cast.add(giacomo);
        cast.add(marina);
        Event a = new GaraDiAtletica("Gara",future,EventType.PRIVATE,piazza,cast,aldo);
        eventDAO.save(p);
        eventDAO.save(a);

        emf.close();
        em.close();
    }
}
