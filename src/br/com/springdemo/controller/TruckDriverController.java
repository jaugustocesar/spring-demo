package br.com.springdemo.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String saveTruckDriver(@Valid @ModelAttribute("truckDriver") TruckDriver truckDriver, BindingResult bindingResult) {
		
		if (Boolean.FALSE.equals(bindingResult.hasErrors())) {
			try {
				truckDriver.setModified(this.getCurrentTimestamp());
				this.truckDriverService.saveTruckDriver(truckDriver);
			} catch (ConstraintViolationException e) {
				bindingResult.rejectValue("phoneNumber", "duplicatedError",
						"Já existe um cadastro contendo um dos campos informados, favor verificar.");
				return "truck-driver-form";
			}
			return "redirect:/truckdriver/list";
		} else {
			return "truck-driver-form";
		}
	}

	private Timestamp getCurrentTimestamp() {
		return new Timestamp(new Date().getTime());
	}

	@GetMapping("/update-driver-form")
	public String showDriverFormForUpdate(@RequestParam("id") int id, Model model) {
		TruckDriver truckDriver = truckDriverService.getTruckDriver(id);
		model.addAttribute("truckDriver", truckDriver);
		return "truck-driver-form";
	}
	
	@GetMapping("/delete-driver")
	public String deleteDriver(@RequestParam("id") int id) {
		truckDriverService.deleteTruckDriver(id);
		return "redirect:/truckdriver/list";
	}
	
}
