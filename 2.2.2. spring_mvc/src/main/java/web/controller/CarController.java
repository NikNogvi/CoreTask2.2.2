package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarServiceImpl carService;

    @GetMapping()
    public String showCar(Model model) {
        model.addAttribute("allCar", carService.getCarList());
        return "cars";
    }

    @GetMapping(params = "count")
    public String showPartCar(@RequestParam("count") int id, Model model) {
        model.addAttribute("allCar", carService.getPartCarList(id));
        return "cars";
    }

}
