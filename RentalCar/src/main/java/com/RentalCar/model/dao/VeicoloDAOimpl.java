package com.RentalCar.model.dao;

import com.RentalCar.model.bean.Veicolo;
import com.RentalCar.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VeicoloDAOimpl implements veicoloDAO{

    @Override
    public Boolean saveVeicolo(Veicolo veicolo){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(veicolo);
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
    public Boolean removeVeicoloWithId(int id){
        Transaction transaction = null;
        Veicolo veicolo = new Veicolo();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            veicolo.setNumeroTelaio(id);
            session.delete(veicolo);
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
    public Boolean modificationVeicolo(Veicolo veicolo){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(veicolo);
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
    public List<Veicolo> getListaVeicoli() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Veicolo", Veicolo.class).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Veicolo getVeicoloByTelaio(int id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Veicolo.class, id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
