package br.com.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.springdemo.dao.TruckDriverDAO;
import br.com.springdemo.entity.TruckDriver;

@Service
public class TruckDriverServiceImpl implements TruckDriverService {

	@Autowired
	private TruckDriverDAO truckDriverDAO;
	
	@Override
	@Transactional
	public List<TruckDriver> getTruckDrivers() {
		return this.truckDriverDAO.getTruckDrivers();
	}

	@Override
	@Transactional
	public void saveTruckDriver(TruckDriver truckDriver) {
		this.truckDriverDAO.saveTruckDriver(truckDriver);
	}

	@Override
	@Transactional
	public TruckDriver getTruckDriver(int id) {
		return this.truckDriverDAO.getTruckDriver(id);
	}

	@Override
	@Transactional
	public void deleteTruckDriver(int id) {
		this.truckDriverDAO.deleteTruckDriver(id);
	}

}
