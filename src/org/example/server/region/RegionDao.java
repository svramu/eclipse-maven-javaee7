package org.example.server.region;

import java.util.List;

import javax.ejb.Local;

@Local
public interface RegionDao {
	public Region create(Region region);
	public Region update(Region region);
	public void delete(int id);
	public Region retrieve(int id);
	public List<Region> retrieve();
}
