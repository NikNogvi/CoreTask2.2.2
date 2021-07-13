package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    private List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car(1, "BMW", 280));
        cars.add(new Car(2, "Mazda", 180));
        cars.add(new Car(3, "Lada", 110));
        cars.add(new Car(4, "Bugatti", 1900));
        cars.add(new Car(5, "Ferrari", 800));
    }


    @Override
    public List getCarList() {
        return cars;
    }

    @Override
    public List getPartCarList(int id) {

        if (id <= 5) {
            List<Car> partCars = new ArrayList<>();
            for (int i = 0; i < id; i++) {
                partCars.add(cars.get(i));
            }
            return partCars;
        } else {
            return cars;
        }
    }
}
