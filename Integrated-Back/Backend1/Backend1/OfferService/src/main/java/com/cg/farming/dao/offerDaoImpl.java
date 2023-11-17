package com.cg.farming.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.farming.entity.offer;

@Transactional
@Repository
public class offerDaoImpl implements offerDao{
	
	
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public offer viewOffer(int offer_Id) {
		
		return em.find(offer.class, offer_Id);
	}

	@Override
	public List<offer> viewAllOffer(String Person) {
		String jpql = "from offer o where o.person=:Person";
		Query query = em.createQuery(jpql);
		query.setParameter("Person", Person);
		return query.getResultList();

	}

	@Override
	public boolean deleteOffer(int offer_Id) {
		String jpql = "delete from offer o where o.offer_Id=:oid";

		Query query = em.createQuery(jpql);
		query.setParameter("oid", offer_Id);
		int res = query.executeUpdate();
		if (res > 0)
			return true;
		else
			return false;
	}
	

	@Override
	public boolean editOffer(offer offer) {
		em.merge(offer);
		return true;
	}

	@Override
	public boolean addOffer(offer offer) {
		em.persist(offer);
		return true;
	}

}
