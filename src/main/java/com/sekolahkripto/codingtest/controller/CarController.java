package com.sekolahkripto.codingtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sekolahkripto.codingtest.model.Car;
import com.sekolahkripto.codingtest.model.Response;
import com.sekolahkripto.codingtest.service.CarService;

@RestController
@RequestMapping("/api/v1/test")
public class CarController {

	@Autowired
	private CarService carService;

	@PostMapping
	private Response<Car> readData(@RequestBody List<Car> data) {
		return carService.readData(data);
	}
}
