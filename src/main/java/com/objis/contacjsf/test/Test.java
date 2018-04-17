/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.contacjsf.test;

import com.objis.contacjsf.entity.Client;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


/**
 *
 * @author JACOB
 */
public class Test {
    
    public static void main(String[]args){
        //
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contact-PU");
        
        EntityManager em = emf.createEntityManager();
        
        // ouverture d'une transaction
        
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        
        Client client = new Client("KRA", "Jacob", "kra@yahoo.fr", "57773168");
        
        em.persist(client);
        
        tx.commit();
        em.close();
        emf.close();
        
        
    }
    
}
