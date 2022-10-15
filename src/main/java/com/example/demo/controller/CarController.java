package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CarController {
    private final UserService userService;

    public CarController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/cars")
    public String findAll(Model model) {
        List<Car> cars = userService.findAll();
        model.addAttribute("cars", cars);
        return "cars";
    }

    @GetMapping("/car-create")
    public String createCarForm(Car car) {

        return "car-create";
    }

    @PostMapping("/car-create")
    public String createCar(Car car) {
        userService.saveCar(car);
        return "redirect:/cars";

    }

//    @GetMapping("/car-update")
//    public String carUpdate(Car car) {
//userService.
//        return "car-create";
//    }
//
//    @PostMapping("/car-create")
//    public String createCar(Car car) {
//        userService.saveCar(car);
//        return "redirect:/cars";
//
//    }

        @GetMapping("/car-delete/{id}")
        public String deleteCar(@PathVariable("id") Long id) {
        userService.deleteCar(id);
        return "redirect:/cars";

    }


        @GetMapping("/car-update/{id}")
    public String carUpdateForm(Model model, Long id) {
        Car car =  userService.carById(id);
        model.addAttribute("car", car);
        return "car-update";
    }

    @PostMapping("/car-update")
    public String carUpdate(Car car) {
        userService.saveCar(car);
        return "redirect:/cars";

    }
}
