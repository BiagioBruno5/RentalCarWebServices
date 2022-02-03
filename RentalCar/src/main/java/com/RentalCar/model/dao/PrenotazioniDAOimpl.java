package com.RentalCar.model.dao;

import com.RentalCar.model.bean.Prenotazioni;
import com.RentalCar.model.bean.Utente;
import com.RentalCar.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PrenotazioniDAOimpl implements com.RentalCar.model.dao.prenotazioniDAO {

    @Override
    public Boolean savePrenotazioni(Prenotazioni prenotazioni){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(prenotazioni);
            transaction.commit();
            session.close();
            return true;
        }
        catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean removePrenotazioniWithId(int id){
        Transaction transaction = null;
        Prenotazioni pren = new Prenotazioni();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            pren.setNumeroPrenotazione(id);
            session.delete(pren);
            transaction.commit();
            session.close();
            return true;
        }
        catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean modificationPrenotazioni(Prenotazioni prenotazioni){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(prenotazioni);
            transaction.commit();
            session.close();
            return true;
        }
        catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Prenotazioni> getListaPrenotazioni() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Prenotazioni", Prenotazioni.class).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Prenotazioni getPrenotazioneByNumeroPrenotazione(int id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Prenotazioni.class, id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Autowired
    com.RentalCar.model.dao.userDAO user;

    @Override
    public List<Prenotazioni> getListaPrenotazioniById(int id_user){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            //String hql = "from Prenotazioni p where p.id = '" + 2 + "'";
            //String hql = "from Prenotazioni ";

            Utente utente = user.getUserById(id_user);
            return session.createQuery("select p from Prenotazioni p where p.utente =:x").setParameter("x", utente).list();
                    }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
