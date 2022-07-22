package com.sekolahkripto.codingtest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sekolahkripto.codingtest.model.Car;
import com.sekolahkripto.codingtest.model.Response;
import com.sekolahkripto.codingtest.service.CarService;

@SpringBootTest
class CodingTestApplicationTests {

	@Autowired
	private CarService carService;

	@Test
	void goals1() {
		// given
		List<Car> req = new ArrayList<>();

		Car car1 = new Car("S", "Black", 0);
		req.add(car1);

		// when
		Response<Car> carCombinationFunc = carService.readData(req);

		assertThat(carCombinationFunc.getData().get(0).getColor()).isEqualTo("Black");
	}
	
	@Test
	void goals2() {
		// given
		List<Car> req = new ArrayList<>();

		Car car1 = new Car("S", "", 0);
		req.add(car1);

		// when
		Response<Car> carCombinationFunc = carService.readData(req);

		assertThat(carCombinationFunc.getData().get(0).getColor()).isEqualTo("White");
	}

}
