/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.contacjsf.dao;

import com.objis.contacjsf.entity.Client;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author kra
 */
public class Clientdao {
    
    // un singléton pour permettant de créer une instance de EntityManager
    private static final String JPA_UNIT_NAME = "contact-PU";
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory(
					JPA_UNIT_NAME).createEntityManager();
		}
		return entityManager;
	}
        
        
        
/**
 * Enregistrement d'un client dans la base de données
 * * @return La personne insérée
     * @param c
     * @return 
 */
public Client insert(Client c) {
	getEntityManager().getTransaction().begin();
	getEntityManager().persist(c);
	getEntityManager().getTransaction().commit();
	return c;
}
        
/**
	 * L'opération de lecture
	 * @return toutes les clients dans la base de données.
	 */
	public List<Client> selectAll() {
		List<Client> clients = getEntityManager().createQuery(
				"select c from Client c").getResultList();
		return clients;
	}
        
        /**
* L'opération Delete
* @param c Le client à supprimer de la base de donnés.
*/
public void delete(Client c) {
    
getEntityManager().getTransaction().begin();

c = getEntityManager().merge(c);

getEntityManager().remove(c);

getEntityManager().getTransaction().commit();

}

/**
* L'opération Update
* @param c Le à mettre à jour dans la base de données.
* @return Le mise à jour
*/
public Client update(Client c) {
getEntityManager().getTransaction().begin();
c = getEntityManager().merge(c);
getEntityManager().getTransaction().commit();
return c;
}
    
}
