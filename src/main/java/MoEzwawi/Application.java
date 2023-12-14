package MoEzwawi;

import MoEzwawi.dao.EventDAO;
import MoEzwawi.dao.ParticipationDAO;
import MoEzwawi.dao.PersonDAO;
import MoEzwawi.entities.Event;
import MoEzwawi.entities.Location;
import MoEzwawi.entities.Participation;
import MoEzwawi.entities.Person;
import MoEzwawi.entities.enums.EventType;
import MoEzwawi.entities.enums.Gender;
import MoEzwawi.entities.enums.ParticipationState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

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
        Event sagra = new Event("Sagra della cipolla",Event.parseDateForItaly("03/05/2024"),EventType.PUBLIC,piazza);
        sagra.setMaximumCapacity(100);
        sagra.setDescription("Cibi a base di cipolla");
        Event partita = new Event("Partita del cuore",Event.parseDateForItaly("03/07/2024"),EventType.PUBLIC,stadio);
        partita.setMaximumCapacity(40000);
        partita.setDescription("Partita di beneficenza");
        Event concerto = new Event("Concerto di musica classica",Event.parseDateForItaly("23/03/2024"),EventType.PRIVATE,teatro);
        concerto.setMaximumCapacity(150);
        concerto.setDescription("Musica di qualità");
        eventDAO.save(sagra);
        eventDAO.save(partita);
        eventDAO.save(concerto);
        Participation p1 = new Participation(aldo,sagra,ParticipationState.CONFIRMED);
        Participation p2 = new Participation(giovanni,sagra,ParticipationState.CONFIRMED);
        Participation p3 = new Participation(giacomo,sagra,ParticipationState.CONFIRMED);
        Participation p4 = new Participation(marina,sagra,ParticipationState.PENDING);
        Participation p5 = new Participation(marina,concerto,ParticipationState.CONFIRMED);
        Participation p6 = new Participation(giovanni,concerto,ParticipationState.CONFIRMED);
        Participation p7 = new Participation(giacomo,concerto,ParticipationState.PENDING);
        Participation p8 = new Participation(aldo,partita,ParticipationState.CONFIRMED);
        Participation p9 = new Participation(giovanni,partita,ParticipationState.CONFIRMED);
        Participation p10 = new Participation(giacomo,partita,ParticipationState.CONFIRMED);
        participationDAO.save(p1);
        participationDAO.save(p2);
        participationDAO.save(p3);
        participationDAO.save(p4);
        participationDAO.save(p5);
        participationDAO.save(p6);
        participationDAO.save(p7);
        participationDAO.save(p8);
        participationDAO.save(p9);
        participationDAO.save(p10);
        emf.close();
        em.close();
    }
}
