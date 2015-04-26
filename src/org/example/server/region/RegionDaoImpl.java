package org.example.server.region;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RegionDaoImpl implements RegionDao {

	@PersistenceContext
	private EntityManager em;
	
    public RegionDaoImpl() {}

	@Override
	public Region create(Region region) {
		em.persist(region);
		return region;
	}

	@Override
	public Region update(Region region) {
		em.merge(region);
		return region;	
	}

	@Override
	public void delete(int id) {
		em.remove(retrieve(id));
	}

	@Override
	public Region retrieve(int id) {
		return em.find(Region.class, id);
	}

	@Override
	public List<Region> retrieve() {
		return em.createNamedQuery("Region.findAll", Region.class).getResultList();
	}
    

}
