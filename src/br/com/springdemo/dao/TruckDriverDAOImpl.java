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
		currentSession.saveOrUpdate(truckDriver);
	}

	@Override
	public TruckDriver getTruckDriver(String documentID) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		TruckDriver truckDriver = currentSession.get(TruckDriver.class, documentID);
		return truckDriver;
	}

	@Override
	public void deleteTruckDriver(String documentID) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Query<?> query = currentSession.createQuery("delete from TruckDriver where id=:documentID");
		query.setParameter("documentID", documentID);
		query.executeUpdate();
	}

}
