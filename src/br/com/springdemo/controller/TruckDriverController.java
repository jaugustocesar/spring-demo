package br.com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.springdemo.entity.TruckDriver;
import br.com.springdemo.service.TruckDriverService;

@Controller
@RequestMapping("/truckdriver")
public class TruckDriverController {

	@Autowired
	private TruckDriverService truckDriverService;

	@GetMapping("/list")
	public String listTruckDrivers(Model model) {
		List<TruckDriver> truckDrivers = this.truckDriverService.getTruckDrivers();
		model.addAttribute("truckDrivers", truckDrivers);
		return "list-truck-drivers";
	}

	@GetMapping("/driver-form")
	public String showDriverForm(Model model) {
		TruckDriver truckDriver = new TruckDriver();
		model.addAttribute("truckDriver", truckDriver);
		return "truck-driver-form";
	}

	@PostMapping("/save-truck-driver")
	public String saveTruckDriver(@ModelAttribute("truckDriver") TruckDriver truckDriver) {
		this.truckDriverService.saveTruckDriver(truckDriver);
		return "redirect:/truckdriver/list";
	}

	@GetMapping("/update-driver-form")
	public String showDriverFormForUpdate(@RequestParam("documentID") String documentID,
										  Model model) {
		
		if (documentID != null && !documentID.trim().isEmpty()) {
			TruckDriver truckDriver = truckDriverService.getTruckDriver(documentID);
			model.addAttribute("truckDriver", truckDriver);
			return "truck-driver-form";
		} else {
			return "redirect:/truckdriver/list";
		}
	}
	
	@GetMapping("/delete-driver")
	public String deleteDriver(@RequestParam("documentID") String documentID) {
		if (documentID != null && !documentID.trim().isEmpty()) {
			truckDriverService.deleteTruckDriver(documentID);
		}
		return "redirect:/truckdriver/list";
	}
}
