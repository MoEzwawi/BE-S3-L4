package MoEzwawi.dao;

import MoEzwawi.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonDAO {
    private final EntityManager em;

    public PersonDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Person person){
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.persist(person);
        transaction.commit();
        System.out.println("L'utente "+person.getSurname()+" "+person.getName()+" è stato correttamente aggiunto al database");
    }
    public Person getById(long id){
        Person found = null;
        try {
            found = em.find(Person.class, id);
            if (found == null){
                throw new IllegalArgumentException("L'utente con id='"+id+"' non è presente nel database");
            }
        } catch (IllegalArgumentException e){
            System.err.println(e);
        }
        return found;
    }
    public void delete(long id){
        Person found = this.getById(id);
        try {
            EntityTransaction transaction = this.em.getTransaction();
            transaction.begin();
            em.persist(found);
            transaction.commit();
        } catch(IllegalArgumentException | NullPointerException e){
            System.err.println("L'utente con id='"+id+"' non è presente nel database");
        }
    }
}
