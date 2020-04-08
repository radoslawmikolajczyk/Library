package com.mikolajczyk.Configuration;

import com.mikolajczyk.Components.Book;
import com.mikolajczyk.Components.History;
import com.mikolajczyk.Components.Reader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class LibraryConfiguration {

    public static Configuration con;
    public static ServiceRegistry reg;
    public static SessionFactory sf;
    public static Session session;
    public static Transaction transaction;

    public static void configure(){
        con = new Configuration().configure().
                addAnnotatedClass(Reader.class).
                addAnnotatedClass(Book.class).
                addAnnotatedClass(History.class);
        reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        sf = con.buildSessionFactory(reg);
        session = sf.openSession();
        transaction = session.beginTransaction();
    }

    public static void commit(){
        try {
            transaction.commit();
            session.close();
        } catch (NullPointerException nullEx){
            configure();
            commit();
        } catch (Exception ex){
            System.out.println("Unrecognized error. Please contact administrator.");
        }
    }

    public static void refresh(){
        configure();
    }
}
