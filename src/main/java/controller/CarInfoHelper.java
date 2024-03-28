package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CarInfo;

/**
 * Larry Paucar - Lpaucar
 * CIS175 -Spring 2024
 * Feb 4, 2024
 */
public class CarInfoHelper {
	
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("CarsList"); 

	public void insertItem(CarInfo ci) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(ci);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CarInfo> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<CarInfo> allItems = em.createQuery("SELECT i FROM CarInfo i").getResultList();
		return allItems; }
	
	public void deleteItem(CarInfo toDelete) {
		EntityManager em = emfactory.createEntityManager(); em.getTransaction().begin();
		TypedQuery<CarInfo> typedQuery = em.createQuery("select ci from CarInfo ci where ci.make = :selectedMake and ci.model = :selectedModel", CarInfo.class);
		//Substitute parameter with actual data from the toDelete item 
		typedQuery.setParameter("selectedMake", toDelete.getMake()); 
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		
		//we only want one result 
		typedQuery.setMaxResults(1);
		
		
		//get the result and save it into a new list item 
		CarInfo result = typedQuery.getSingleResult();
		
		//remove it 
		em.remove(result); 
		em.getTransaction().commit(); 
		em.close();
		}

	/**
	 * @param modelName
	 * @return
	 */
	public List<CarInfo> searchForItemByMake(String makeName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager(); em.getTransaction().begin();
		TypedQuery<CarInfo> typedQuery = em.createQuery("select ci from CarInfo ci where ci.make = :selectedMake", CarInfo.class); typedQuery.setParameter("selectedMake", makeName);
		List<CarInfo> foundItems = typedQuery.getResultList(); em.close();
		return foundItems;
		}
	/**
	 * @param modelName
	 * @return
	 */
	public List<CarInfo> searchForItemByModel(String modelName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager(); em.getTransaction().begin();
		TypedQuery<CarInfo> typedQuery = em.createQuery("select ci from CarInfo ci where ci.model = :selectedModel", CarInfo.class); typedQuery.setParameter("selectedModel", modelName);
		List<CarInfo> foundItems = typedQuery.getResultList(); em.close();
		return foundItems;
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public CarInfo searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager(); em.getTransaction().begin();
		CarInfo found = em.find(CarInfo.class, idToEdit); em.close();
		return found;
	}

	/**
	 * @param toEdit
	 */
	public void updateModel(CarInfo toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin();
		em.merge(toEdit); 
		em.getTransaction().commit(); 
		em.close();
	}
	public void cleanUp(){
		emfactory.close(); }


	}
