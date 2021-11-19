import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Test {

    public static void main(String[] args){

        Dealership d1 = new Dealership();
        double finalprice = 0;
        Offer offer = new Offer() {
            @Override
            public double getDiscount(Car car) {
                return 5000;
            }
        };
        Car c1 = new Car(250000, 2017, CarType.Toyota);
        System.out.println("Prima masina este : " + c1.getType());
        System.out.println("Initial price: " + c1.getPrice());
        System.out.println("Applying Brand discount: " + d1.getBrandOffer().getDiscount(c1));
        System.out.println("Applying Dealer discount: " + d1.getDealerOffer().getDiscount(c1));
        System.out.println("Applying Special discount: " + d1.getSpecialOffer().getDiscount(c1));
        finalprice = d1.getFinalPrice(c1);
        System.out.println("Final price: " + finalprice);
        System.out.println("Applying client's discount: " + offer.getDiscount(c1));
        finalprice = d1.negotiate(c1, offer);
        System.out.println("Final price after negociations: " + finalprice);

        Car c2 = new Car(170000, 2010, CarType.Peugeot);
        System.out.println("A doua masina este : " + c2.getType());
        System.out.println("Initial price: " + c2.getPrice());
        System.out.println("Applying Brand discount: " + d1.getBrandOffer().getDiscount(c2));
        System.out.println("Applying Dealer discount: " + d1.getDealerOffer().getDiscount(c2));
        System.out.println("Applying Special discount: " + d1.getSpecialOffer().getDiscount(c2));
        finalprice = d1.getFinalPrice(c2);
        System.out.println("Final price: " + finalprice);
        System.out.println("Applying client's discount: " + offer.getDiscount(c2));
        finalprice = d1.negotiate(c2, offer);
        System.out.println("Final price after negociations: " + finalprice);

        Car c3 = new Car(400000, 2015, CarType.Chevrolet);
        System.out.println("A treia masina este : " + c3.getType());
        System.out.println("Initial price: " + c3.getPrice());
        System.out.println("Applying Brand discount: " + d1.getBrandOffer().getDiscount(c3));
        System.out.println("Applying Dealer discount: " + d1.getDealerOffer().getDiscount(c3));
        System.out.println("Applying Special discount: " + d1.getSpecialOffer().getDiscount(c3));
        finalprice = d1.getFinalPrice(c3);
        System.out.println("Final price: " + finalprice);
        System.out.println("Applying client's discount: " + offer.getDiscount(c3));
        finalprice = d1.negotiate(c3, offer);
        System.out.println("Final price after negociations: " + finalprice);

        Car nr1 = new Car(10000, 2019, CarType.Chevrolet);
        Car nr2 = new Car(25000, 2018, CarType.Toyota);
        Car nr3 = new Car(550000, 2021, CarType.Peugeot);
        Car nr4 = new Car(430000, 2017, CarType.Toyota);
        Car nr5 = new Car(200000, 2016, CarType.Chevrolet);
        List<Car> values = new ArrayList<>(Arrays.asList(nr1, nr2, nr3, nr4, nr5));

        System.out.println("Lista INAINTE DE eliminarea masinilor cu pretul >= 430000: ");
        values.forEach((v)-> System.out.println(v.getPrice()));
        values.removeIf((v) -> v.getPrice() >= 430000);
        System.out.println("Lista DUPA eliminarea masinilor cu pretul >= 430000: ");
        values.forEach((v) -> System.out.println(v.getPrice()));

        //clasele .class generate la compilare sunt:
        // Test$1.class,
        // Dealership$BrandOffer.class,
        // Dealership$DealerOffer.class,
        // Dealership$SpecialOffer.class,
        // Dealership.class,
        // Test.class,
        // Car$CarType.class,
        // Offer.class,
        // Car.class,
        // Offer.class.
    }
}
