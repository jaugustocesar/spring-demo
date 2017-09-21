package br.com.springdemo.dao;

import java.util.List;

import br.com.springdemo.entity.TruckDriver;

public interface TruckDriverDAO {
	
	public List<TruckDriver> getTruckDrivers();

	public void saveTruckDriver(TruckDriver truckDriver);

	public TruckDriver getTruckDriver(String documentID);

	public void deleteTruckDriver(String documentID);

}
