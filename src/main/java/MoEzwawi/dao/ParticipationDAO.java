package MoEzwawi.dao;

import MoEzwawi.entities.Participation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ParticipationDAO {
    private final EntityManager em;

    public ParticipationDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Participation participation){
        EntityTransaction transaction = this.em.getTransaction();
        transaction.begin();
        em.persist(participation);
        transaction.commit();
        System.out.println("La partecipazione all'evento "+participation.getEvent()+" è stata correttamente aggiunta al database");
    }
    public Participation getById(long id){
        Participation found = null;
        try {
            found = em.find(Participation.class, id);
            if (found == null){
                throw new IllegalArgumentException("La partecipazione con id='"+id+"' non è presente nel database");
            }
        } catch (IllegalArgumentException e){
            System.err.println(e);
        }
        return found;
    }
    public void delete(long id){
        Participation found = this.getById(id);
        try {
            EntityTransaction transaction = this.em.getTransaction();
            transaction.begin();
            em.persist(found);
            transaction.commit();
        } catch(IllegalArgumentException | NullPointerException e){
            System.err.println("La partecipazione con id='"+id+"' non è presente nel database");
        }
    }
}
