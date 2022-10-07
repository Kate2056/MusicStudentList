package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.MusicTeacher;

//package and import statements
public class MusicTeacherHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MusicStudent");
	public void insertShopper(MusicTeacher m) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
	}

public List<MusicTeacher> showAllTeachers() {
	EntityManager em =emfactory.createEntityManager();
	List<MusicTeacher> allMusicTeachers = em.createQuery("SELECT m FROM MusicTeacher m").getResultList();
	return allMusicTeachers;
}
public MusicTeacher findMusicTeacher(String nameToLookUp) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<MusicTeacher> typedQuery = em.createQuery("select mt from MusicTeacher mt where mt.musicTeacherName = :selectedName", MusicTeacher.class);
	typedQuery.setParameter("selectedName", nameToLookUp);
	typedQuery.setMaxResults(1);
	MusicTeacher foundMusicTeacher;
	try{
		foundMusicTeacher = typedQuery.getSingleResult();
	}catch(NoResultException ex) {
		foundMusicTeacher = new MusicTeacher(nameToLookUp);
	}
	em.close();
	return foundMusicTeacher;
}
}