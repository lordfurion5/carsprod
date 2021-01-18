package management.system.at.an.IT.enterprise.demo.controllers;
import management.system.at.an.IT.enterprise.demo.models.*;
import management.system.at.an.IT.enterprise.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;



@Controller
public class MainController {


    @Autowired
    private ManufacturerRepo manufacturerRepo;

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private AssessmentRepo assessmentRepo;

    @Autowired
    private CommentRepo commentRepo;

    @GetMapping("/getAllManufacturers")
    public String getAllManufacturer(Model model) {
        Iterable<Manufacturer> manufacturers=manufacturerRepo.findAll();
        model.addAttribute("manufacturer", manufacturers);
        return "manufacturer";
    }


    @GetMapping("/addManufacturer")
    public String addManufacturerGet(Model model){
        return "addManufacturer";
    }

    @PostMapping("/addManufacturer")
    public String addManufacturerPost(@RequestParam String name,@RequestParam String logo){

        Manufacturer expected = new Manufacturer(name,logo);
        manufacturerRepo.save(expected);

        return "redirect:/getAllManufacturers";
    }

    @GetMapping("/manufacturer/{id}")
    public String manufacturerDetail(@PathVariable(value = "id") long id, Model model) {
        Optional<Manufacturer> manufacturer=manufacturerRepo.findById(id);
        ArrayList<Manufacturer> res =new ArrayList<>();
        manufacturer.ifPresent(res::add);

        model.addAttribute("manufacturer", res);
        return "manufacturer-detail";
    }



    @GetMapping("/getAllCar")
    public String getAllCar(Model model) {
        Iterable<Car> car=carRepo.findAll();
        model.addAttribute("car", car);
        return "car";
    }

    @GetMapping("/addCar")
    public String addCarGet(Model model){
        return "addCar";
    }

    @PostMapping("/addCar")
    public String addCarPost(@RequestParam String name,@RequestParam String photoURL,@RequestParam String desc,@RequestParam Manufacturer manufacturer_id){

        Car expected = new Car(name,photoURL,desc);
        expected.setManufacturer(manufacturer_id);
        carRepo.save(expected);

        return "redirect:/getAllCar";
    }


    @GetMapping("/car/{id}")
    public String carDetail(@PathVariable(value = "id") long id, Model model) {
        Optional<Car> car=carRepo.findById(id);
        ArrayList<Car> res =new ArrayList<>();
        car.ifPresent(res::add);

        model.addAttribute("car", res);
        return "car-detail";
    }

    @GetMapping("/car/{id}/edit")
    public String carEdit(@PathVariable(value = "id") long id, Model model) {
        if (!carRepo.existsById(id)){
            return "redirect:/";
        }
        Optional<Car> car=carRepo.findById(id);
        ArrayList<Car> res =new ArrayList<>();
        car.ifPresent(res::add);

        model.addAttribute("car", res);
        return "car-edit";
    }

    @PostMapping("/car/{id}/edit")
    public String updateCarPost(@PathVariable(value = "id") long id,@RequestParam String desc){
        Optional<Car> car=carRepo.findById(id);
        if (desc!=null){
            car.get().setDesc(desc);
        }


        carRepo.save(car.get());

        return "redirect:/getAllCar";
    }
    @PostMapping("/car/{id}/delete")
    public String deleteCarPost(@PathVariable(value = "id") long id){
        carRepo.deleteById(id);
        return "redirect:/getAllCar";
    }


    @GetMapping("/getAllAssessment")
    public String getAllAssessment(Model model) {
        Iterable<Assessment> assessments=assessmentRepo.findAll();
        model.addAttribute("assessments", assessments);
        return "assessments";
    }


    @GetMapping("/addAssessment")
    public String addAssessmentGet(Model model){
        return "addAssessment";
    }

    @PostMapping("/addAssessment")
    public String addAssessmentPost(@RequestParam String reliability,@RequestParam String quality,@RequestParam String service,@RequestParam Car car_id){

        Assessment expected = new Assessment(reliability,quality,service);
        expected.setCar(car_id);
        assessmentRepo.save(expected);


        return "redirect:/getAllAssessment";
    }

    @GetMapping("/getAllComment")
    public String getAllComment(Model model) {
        Iterable<Comment> comments=commentRepo.findAll();
        model.addAttribute("comments", comments);
        return "comment";
    }


    @GetMapping("/addComment")
    public String addCommentGet(Model model){
        return "addComment";
    }

    @PostMapping("/addComment")
    public String addCommentPost(@RequestParam String title,@RequestParam String name,@RequestParam Car car_id){

        Comment expected = new Comment(title,name);
        expected.setCar(car_id);
        commentRepo.save(expected);

        return "redirect:/getAllComment";
    }

}