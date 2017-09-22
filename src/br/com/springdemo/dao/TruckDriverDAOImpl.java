package br.com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.springdemo.entity.TruckDriver;

@Repository
public class TruckDriverDAOImpl implements TruckDriverDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<TruckDriver> getTruckDrivers() {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Query<TruckDriver> query = currentSession.createQuery("from TruckDriver order by name", TruckDriver.class);
		List<TruckDriver> truckDrivers = query.getResultList();
		return truckDrivers;
	}

	@Override
	public void saveTruckDriver(TruckDriver truckDriver) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		if (truckDriver.getId() != 0) {
			currentSession.update(truckDriver);
		} else {
			currentSession.save(truckDriver);
		}
	}

	@Override
	public TruckDriver getTruckDriver(int id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		TruckDriver truckDriver = currentSession.get(TruckDriver.class, id);
		return truckDriver;
	}

	@Override
	public void deleteTruckDriver(int id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Query<?> query = currentSession.createQuery("delete from TruckDriver where id=:idTruckDriver");
		query.setParameter("idTruckDriver", id);
		query.executeUpdate();
	}

}
