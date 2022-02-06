package com.RentalCar.model.dao;
import com.RentalCar.model.bean.Utente;
import com.RentalCar.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOimpl implements com.RentalCar.model.dao.userDAO {

    @Override
    public Boolean saveUser(Utente cust){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
                transaction = session.beginTransaction();
                session.save(cust);
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
    public Boolean removeUserWithId(int id){
        Transaction transaction = null;
        Utente c = new Utente();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            c.setId(id);
            session.delete(c);
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
    public Boolean modificationUser(Utente customer){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(customer);
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
    public Utente getUserById(int id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Utente.class, id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Utente> getUser() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Utente ", Utente.class).list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Utente getUserByName(String nome) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Utente user = (Utente) session.createQuery("select u from Utente u where u.nome =:x").setParameter("x", nome).uniqueResult();
            return user;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Utente getUserForLogin(String nome, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Utente user = (Utente) session.createQuery("select u from Utente u where u.nome =:x and u.password =:y").setParameter("x", nome)
                    .setParameter("y", password)
                    .uniqueResult();
            return user;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
