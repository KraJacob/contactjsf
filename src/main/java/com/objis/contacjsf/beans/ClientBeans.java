/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.contacjsf.beans;

import com.objis.contacjsf.entity.Client;
import com.objis.contacjsf.dao.Clientdao;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
/**
 *
 * @author kra
 * un managed-beanJSF ( Controller ) qui fera le lien entre les pages et la couche métier.
 * Cette classe est ensuite declarée dans faces-config.xml
 */

public class ClientBeans {
private Client client;
private Clientdao clientdao;
private DataModel clients;
private Client editClient;

    public DataModel getClients() {
         if (clients == null) {
        clients = new ListDataModel();
        clients.setWrappedData(clientdao.selectAll());
        
        }
        return clients;
        
    }

   

public Client getClient(){ 
    return client;
} 
public void setClient(Client client){
    this.client = client;
            }
public Clientdao getClientdao(){ 
    return clientdao;
} 
public void setClientdao(Clientdao clientdao){
    this.clientdao = clientdao;
            }

    public void setEditClient(Client editClient) {
        this.editClient = editClient;
    }

    public Client getEditClient() {
        return editClient;
    }



public ClientBeans() {
    
        client = new Client();
        
         clientdao = new Clientdao();
         
         editClient = new Client();
         
	if (clients == null) {
        clients = new ListDataModel();
        clients.setWrappedData(clientdao.selectAll());
        
        }
                    
	
    }



    // initialisation de la liste dans le getter

   /* public List<Client> getClient() {
        
        if(clients==null){            
		clients = clientdao.selectAll();
                 }        
	return clients;
    }
*/
 
 
 //private String nom = client.getPrenom();
 public String createClient(){
     // insertion du client
     clientdao.insert(client);
     // création d'une instance pour la prochaine insertion
     client = new Client();
     // mise à jour de la liste des clients
     clients.setWrappedData(clientdao.selectAll());
     // on retourne un littérale list qui va nous servir dans nos règles de navigation
     return "list";
     
 }
 
 /**
* L'opération de suppression à invoquer suite à la sélection d'un
* client.
* *
@return outcome pour la navigation entre les pages. Dans ce cas, c'est null pour
* rester dans la page de listing.
*/
public String deleteClient() {
Client c = (Client) clients.getRowData();
clientdao.delete(c);
clients.setWrappedData(clientdao.selectAll());
return null;
}

/**
* Opération pour recuperer le à modifier.
* @return outcome pour la navigation entre les pages. Dans ce cas, c'est "edit" pour
* aller à la page de modification.
*/
public String editClient() {
    
editClient = (Client) clients.getRowData();

return "edit";
}

/**
* L'opération Update pour faire la mise à jour.
* @return outcome pour la navigation entre les pages. Dans ce cas, c'est "list" pour
* retourner à la page de listing.
*/
public String updateClient() {
    
clientdao.update(editClient);

clients.setWrappedData(clientdao.selectAll());

return "list";

}
    
}
