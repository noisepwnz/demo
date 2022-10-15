package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {


    private final CarsRepository carsRepository;


    @Autowired
    public UserService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    public Car carById(Long id) {
        return carsRepository.getOne(id);
    }

    public List<Car> findAll() {
        return carsRepository.findAll();
    }

    public Car saveCar(Car car) {
        return carsRepository.save(car);
    }

    public void deleteCar(long id) {
        carsRepository.deleteById(id);
    }
}
