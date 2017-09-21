package br.com.springdemo.service;

import java.util.List;

import br.com.springdemo.entity.TruckDriver;

public interface TruckDriverService {
	
	public List<TruckDriver> getTruckDrivers();

	public void saveTruckDriver(TruckDriver truckDriver);

	public TruckDriver getTruckDriver(String documentID);

	public void deleteTruckDriver(String documentID);

}
