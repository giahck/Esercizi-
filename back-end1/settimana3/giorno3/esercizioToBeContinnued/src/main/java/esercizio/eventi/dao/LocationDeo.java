package esercizio.eventi.dao;

import esercizio.eventi.entity.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDeo {
    private EntityManager em;
    public LocationDeo(EntityManager em) {
        this.em = em;
    }
    public void save(Location location){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(location);
        et.commit();
    }
    public Location getById(int id){
        Location location = em.find(Location.class,id);
        return location;
    }
    public void delete(Location location){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(location);
        et.commit();
    }

}
