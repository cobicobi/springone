package net.cobicobi.springone;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.cobicobi.springone.entity.Role;
import net.cobicobi.springone.entity.User;

import org.junit.Test;

public class UserTest extends BaseTest {
	@Test
	public void testNewUser() throws Exception {
		
		EntityManagerFactory emFactory = Persistence.
				createEntityManagerFactory("springonePU");
		EntityManager entityManager = emFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		try {
			User user = new User();
			user.setUsername("user" + Long.toString(new Date().getTime()));
			
			entityManager.persist(user);
			entityManager.getTransaction().commit();
		
			User foundUser = entityManager.find(User.class, user.getId());
			assertEquals(user, foundUser);

			entityManager.getTransaction().begin();
			entityManager.remove(foundUser);
			entityManager.getTransaction().commit();
			
			foundUser = entityManager.find(User.class, user.getId());
			assertEquals(null, foundUser);
			
		} catch (Exception e) {
			e.printStackTrace();
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
		}
		
		entityManager.close();
	}
	
	@Test
	public void testNewUserRole() {
		
		EntityManagerFactory emFactory = Persistence.
				createEntityManagerFactory("springonePU");
		EntityManager entityManager = emFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		try {
			User user = new User();
			user.setUsername("user" + Long.toString(new Date().getTime()));
			
			Role role = new Role();
			role.setName("role" + Long.toString(new Date().getTime()));
			
			entityManager.persist(user);
			entityManager.persist(role);
			entityManager.getTransaction().commit();
			
			assertEquals(0, user.getRoles().size());
			
			entityManager.getTransaction().begin();
			
			user.addRole(role);

			assertEquals(1, user.getRoles().size());
			
			entityManager.merge(user);
			entityManager.getTransaction().commit();
			
			User foundUser = entityManager.find(User.class, user.getId());
			assertEquals(1, foundUser.getRoles().size());
			
			entityManager.getTransaction().begin();
			entityManager.remove(foundUser);
			entityManager.remove(role);
			entityManager.getTransaction().commit();
			
			foundUser = entityManager.find(User.class, user.getId());
			assertEquals(null, foundUser);
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		
		entityManager.close();
	}
	
	@Test
	public void testFindUser() {
		EntityManagerFactory emFactory = Persistence.
				createEntityManagerFactory("springonePU");
		EntityManager entityManager = emFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		try {
			User user = new User();
			user.setUsername("user" + Long.toString(new Date().getTime()));
			
			Role role = new Role();
			role.setName("role" + Long.toString(new Date().getTime()));
			
			entityManager.persist(user);
			entityManager.persist(role);
			
			user.addRole(role);
			
			entityManager.merge(user);
			entityManager.getTransaction().commit();
			entityManager.close();
			
			entityManager = emFactory.createEntityManager();
			
			User foundUser = entityManager.
				createNamedQuery("User.findByName", User.class).
				setParameter("username", user.getUsername()).getSingleResult();
			
			System.out.println(foundUser);
			
			assertEquals(user.getUsername(), foundUser.getUsername());
			assertEquals(1, foundUser.getRoles().size());
			
			System.out.println(foundUser.getRoles().getClass());
			
			entityManager.getTransaction().begin();
			entityManager.remove(foundUser);
			entityManager.remove(role);
			entityManager.getTransaction().commit();
			
			foundUser = entityManager.find(User.class, user.getId());
			assertEquals(null, foundUser);
			
		} catch (Exception e) {
			e.printStackTrace();
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
		}
		
		entityManager.close();
	}
}