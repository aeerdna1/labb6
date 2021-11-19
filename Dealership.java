import java.util.Random;
public class Dealership{
    private class BrandOffer implements Offer{
        public double getDiscount(Car car){ //discount in fct de tipul masinii
            double discount = 0;
            int price = car.getPrice();
            if(car.getType().equals(CarType.Peugeot)){
                discount = 0.1 * price;
            }else if(car.getType().equals(CarType.Toyota)){
                discount =0.3 * price;
            }else if(car.getType()==CarType.Chevrolet){
                discount = 0.25 * price;
            }
            return discount;
        }
    }
    private class DealerOffer implements Offer{
        public double getDiscount(Car car) {
            int currentYear = 2021;
            double discount = 0;
            int vechime = 0;
            if(car.getYear() != 2021){
                vechime = currentYear - car.getYear();
            }
            for(int i = 0; i < vechime; i++){
                discount = discount + 500;
            }
            return discount;
        }
    }
    private class SpecialOffer implements Offer{ //discount random
        public double getDiscount(Car car){
            Random r = new Random();
            int low = 100;
            int high = 300;
            double result = r.nextInt(high-low) + low;
            return result;
        }
    }
    public double negotiate(Car car, Offer offer){
        double finalprice = 0;
        double discount1 = new BrandOffer().getDiscount(car);
        double discount2 = new DealerOffer().getDiscount(car);
        double discount3 = new SpecialOffer().getDiscount(car);
        finalprice = car.getPrice() - (discount1+discount2+discount3);
        double discount4 = offer.getDiscount(car);
        Random random = new Random();
        if(random.nextInt(2) == 0){
            System.out.println("Don't apply any discound!");
        }else{
            finalprice = finalprice - discount4;
        }
        return finalprice;
    }
    public double getFinalPrice(Car car){
        double discount1 = new BrandOffer().getDiscount(car);
        double discount2 = new DealerOffer().getDiscount(car);
        double discount3 = new SpecialOffer().getDiscount(car);
        double discounts = discount1 + discount2 + discount3;
        double finalprice = car.getPrice()- discounts;
        return finalprice;
    }

    public Offer getBrandOffer(){
        BrandOffer b = new BrandOffer();
        return b;
    }
    public Offer getDealerOffer(){
        DealerOffer d = new DealerOffer();
        return d;
    }
    public Offer getSpecialOffer(){
        SpecialOffer s = new SpecialOffer();
        return s;
    }

}
