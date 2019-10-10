package softuni.carsoffer.web.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import softuni.carsoffer.domain.models.binding.CarRegisterBindingOffer;
import softuni.carsoffer.domain.models.service.CarServiceModel;
import softuni.carsoffer.service.CarService;

@Controller
public class CarRegister {

    private final CarService carService;
    private final ModelMapper modelMapper;


    @Autowired
    public CarRegister(CarService carService, ModelMapper modelMapper) {
        this.carService = carService;
        this.modelMapper = modelMapper;
    }



    @GetMapping("/reg")
    public String register () {
        return "register.html";
    }

    @PostMapping("/reg")
    public String registerConfirm (@ModelAttribute(name = "model") CarRegisterBindingOffer model) {

        try {
            this.carService.registerCar(modelMapper.map(model, CarServiceModel.class));
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            return "redirect:/reg";
        }


        return "redirect:/";
    }


}
