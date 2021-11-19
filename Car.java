public class Car {
    private Integer price;
    private Integer year;
    private CarType type;
    public Car(Integer price, Integer year,CarType type){
        this.price = price;
        this.year = year;
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }
}
