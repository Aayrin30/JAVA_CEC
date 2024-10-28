package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.CarModel;
import com.example.demo.repository.CarRepository;

@Controller
public class CarController {
@Autowired
CarRepository carRepo;

@GetMapping("/")
public String home() {
	return "home";
}

@PostMapping("/add")
public String addCar(CarModel cm) {
	try {
		carRepo.save(cm);
		return "redirect:/display";
	}
	catch (Exception e) {
		return e.getMessage();
	}
}

@GetMapping("/display")
public String displayCar(Model model) {
	List<CarModel> car_list=(List<CarModel>)carRepo.findAll();
	model.addAttribute("cars",car_list);
	return "display";
}

@GetMapping("/delete/{id}")
public String deleteCar(@PathVariable("id")Integer id) {
	carRepo.deleteById(id);
	return "redirect:/display";
}

@GetMapping("/edit/{id}")
public String editCar(@PathVariable("id")Integer id,Model model) {
	CarModel cm = carRepo.findById(id).get();
	model.addAttribute("car",cm);
	return "edit";
}
@PostMapping("/edit")
public String editCar(CarModel cm) {
	Integer id=cm.getId();
	String brand=cm.getBrand();
	String model=cm.getModel();
	int rentalPrice=cm.getRentalPrice();
	CarModel carDB=carRepo.findById(id).get();
	carDB.setBrand(brand);
	carDB.setModel(model);
	carDB.setRentalPrice(rentalPrice);
	carRepo.save(carDB);
	return "redirect:/display";

}



}
