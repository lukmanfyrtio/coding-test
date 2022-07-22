package com.sekolahkripto.codingtest.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sekolahkripto.codingtest.model.Car;
import com.sekolahkripto.codingtest.model.Response;

@Service
public class CarService {
	String[] model = { "S", "3", "X", "Y" };
	String[] color = { "Red", "Black", "White", "Blue", "Green" };

	public Response<Car> readData(List<Car> req) {
		Response<Car> result1 = new Response<>();

		List<Car> result = new ArrayList<>();
		List<Car> existingData = initData();

		// looping list request from rest api
		for (Car data : req) {

			// get model list
			List<Car> model = existingData.stream().filter(dataF -> dataF.getModel().equalsIgnoreCase(data.getModel()))
					.collect(Collectors.toList());

			// checking mandatory field
			if (data.getModel() == null) {
				result1.setStatus(400);
				result1.setMessage("model is required");
				return result1;
			} else if (model.isEmpty()) {
				result1.setStatus(400);
				result1.setMessage("model is only S,3,X and Y");
				return result1;
			}

			// get lowest price from model list
			Car lowestPrice = model.stream().min(Comparator.comparing(Car::getPrice))
					.orElseThrow(NoSuchElementException::new);

			Car map = new Car();
			// check data if color none .empty or null will get lowest price on own model
			if (data.getColor() == null || data.getColor() == "" || data.getColor() == "none") {
				map.setModel(data.getModel());
				map.setColor(lowestPrice.getColor());
			} else {
				// find data from existing
				String filter = data.getModel() + data.getColor();
				Optional<Car> getCar = existingData.stream()
						.filter(dataF -> filter.equals(dataF.getModel() + dataF.getColor())).findFirst();
				map.setModel(getCar.isPresent() ? getCar.get().getModel() : lowestPrice.getModel());
				map.setColor(getCar.isPresent() ? getCar.get().getColor() : lowestPrice.getColor());
			}
			result.add(map);
		}

		result1.setStatus(200);
		result1.setData(result);
		return result1;
	}

	private List<Car> initData() {
		// ■ S-Red -> 2.000.000
		// ■ S-Black -> 3.000.000
		// ■ S-White -> 1.000.000
		// ■ S-Blue -> 5.000.000
		// ■ S-Green -> 4.000.000

		// ■ 3-Red -> 2.000.000
		// ■ 3-Black -> 3.000.000
		// ■ 3-White -> 1.000.000
		// ■ 3-Blue -> 5.000.000
		// ■ 3-Green -> 4.000.000

		// ■ X-Red -> 2.000.000
		// ■ X-Black -> 3.000.000
		// ■ X-White -> 1.000.000
		// ■ X-Blue -> 5.000.000
		// ■ X-Green -> 4.000.000

		// ■ Y-Red -> 2.000.000
		// ■ Y-Black -> 3.000.000
		// ■ Y-White -> 1.000.000
		// ■ Y-Blue -> 5.000.000
		// ■ Y-Green -> 4.000.000

		// create object list from class car
		List<Car> result = new ArrayList<>();
		for (int i = 0; i < model.length; i++) {
			for (int j = 0; j < color.length; j++) {
				if (color[j].equals("Red")) {
					result.add(new Car(model[i], color[j], 2_000_000));
				} else if (color[j].equals("Black")) {
					result.add(new Car(model[i], color[j], 3_000_000));
				} else if (color[j].equals("White")) {
					result.add(new Car(model[i], color[j], 1_000_000));
				} else if (color[j].equals("Blue")) {
					result.add(new Car(model[i], color[j], 5_000_000));
				} else if (color[j].equals("Green")) {
					result.add(new Car(model[i], color[j], 4_000_000));
				}
			}
		}

		return result;

	}
}
