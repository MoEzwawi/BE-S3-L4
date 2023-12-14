package MoEzwawi.dao;

import MoEzwawi.entities.Event;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventDAO {
    private final EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Event event){
        if (event.getEventDate()!=null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(event);
            transaction.commit();
            System.out.println("L'evento " + event.getTitle() + " è stato caricato correttamente!");
        } else {
            System.err.println("Imposta una data valida prima di aggiungere l'evento al database");
        }
    }
    public Event getById(long id){
        Event found = null;
        try {
            found = em.find(Event.class, id);
            if (found == null){
                throw new IllegalArgumentException("L'evento con id='"+id+"' non è presente nel database");
            }
        } catch (IllegalArgumentException e){
            System.err.println(e);
        }
        return found;
    }
    public void delete(long id){
        Event found = this.getById(id);
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("L'evento " + found.getTitle() + " è stato rimosso correttamente!");
        }catch (IllegalArgumentException | NullPointerException e){
            System.err.println("L'evento con id='"+id+"' non è presente nel database");
        }
    }
}
