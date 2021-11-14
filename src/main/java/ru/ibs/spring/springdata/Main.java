//package ru.ibs.spring.springdata;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import ru.ibs.trainee.spring.jpa.entities.Car;
//import ru.ibs.trainee.spring.jpa.entities.Gear;
//import ru.ibs.trainee.spring.jpa.service.CarService;
//import ru.ibs.trainee.spring.jpa.service.GearSevice;
//
//import java.util.List;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ru.ibs.trainee.spring.jpa");
//
//        final CarService carService = applicationContext.getBean(CarService.class);
//
//
//
//        final Car fordCar = carService.addCar("Ford", "Mondeo", "R4 petrol engine");
//        final Car chevyCar = carService.addCar("Chevrolet", "Impala", "V8 petrol engine");
//
//        final GearSevice gearSevice = applicationContext.getBean(GearSevice.class);
//
//        final List<Gear> gears = gearSevice.findGears(fordCar);
////        final Gear gear = gearSevice.findGear(chevyCar);  // упадёт т.к. по сигнатуре метода спринг будет ожидать единственную запись
//
//    }
//}
