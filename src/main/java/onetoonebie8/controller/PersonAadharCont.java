package onetoonebie8.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoonebie8.dao.AadharCardDao;
import onetoonebie8.dao.PersonDao;
import onetoonebie8.dto.AadharCard;
import onetoonebie8.dto.Person;

public class PersonAadharCont {
public static void main(String[] args) {
	Person person=new Person();
	person.setId(2);
	person.setName("Poojitha");
	person.setAddress("Bangalore");
	
	
	AadharCard aadharCard=new AadharCard();
	aadharCard.setId(102);
	aadharCard.setName("pooji");
	aadharCard.setAge(18);
	
	
	
	person.setAadharCard(aadharCard);
	aadharCard.setPerson(person);
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(person);
	entityManager.persist(aadharCard);
	entityTransaction.commit();
	
//	PersonDao dao=new PersonDao();
////	dao.deletePerson(1);
////	
//	dao.findPerson(2);
//	AadharCardDao cardDao=new AadharCardDao();
////	
//cardDao.findAadharCard(101);
	
	
	
}
}
