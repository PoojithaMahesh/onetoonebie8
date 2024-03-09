package onetoonebie8.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoonebie8.dto.AadharCard;
import onetoonebie8.dto.Person;

public class AadharCardDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	
	public void updateAadharCard(int id,AadharCard aadharCard)
	{
		EntityManager entityManager=getEntityManager();
		AadharCard dbAadharCard=entityManager.find(AadharCard.class, id);	
		if(dbAadharCard!=null) {
//			id is present so i can update the data
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			aadharCard.setId(id);
			aadharCard.setPerson(dbAadharCard.getPerson());
			entityManager.merge(aadharCard);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry ID is not present");
		}
		
	}
	
	public void findAadharCard(int id)
	{
		EntityManager entityManager=getEntityManager();
		AadharCard dbAadharCard=entityManager.find(AadharCard.class, id);	
		if(dbAadharCard!=null) {
//			id is present so i can update the data
			System.out.println(dbAadharCard);
		}else {
			System.out.println("Sorry ID is not present");
		}
		}
	public void deleteAadharCard(int id)
	{
		EntityManager entityManager=getEntityManager();
		AadharCard dbAadharCard=entityManager.find(AadharCard.class, id);	
		if(dbAadharCard!=null) {
//			id is present so i can update the data
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Person person=dbAadharCard.getPerson();
		person.setAadharCard(null);
		entityManager.remove(dbAadharCard);
		entityTransaction.commit();
		}else {
			System.out.println("Sorry ID is not present");
		}
		}
	
	
	
	
	
	
	
}
