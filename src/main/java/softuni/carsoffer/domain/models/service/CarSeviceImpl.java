package softuni.carsoffer.domain.models.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.carsoffer.domain.entities.Cars;
import softuni.carsoffer.repository.CarRepository;
import softuni.carsoffer.service.CarService;

import javax.validation.Validator;

@Service
public class CarSeviceImpl implements CarService {

    private final CarRepository repository;
    private final Validator validator;
    private final ModelMapper modelMapper;



    @Autowired
    public CarSeviceImpl(CarRepository repository, Validator validator, ModelMapper modelMapper) {
        this.repository = repository;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }



    @Override
    public void registerCar(CarServiceModel carServiceModel) {
        if(validator.validate(carServiceModel).size() != 0) {
            throw new IllegalArgumentException("Something is wrong");
        }

        this.repository.saveAndFlush(modelMapper.map(carServiceModel, Cars.class));
    }
}
