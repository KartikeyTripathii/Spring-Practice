package in.kuru.beans;

public class Address {
    private int lane;
    private String city;
    private int pin;

    public void setLane(int lane) {
        this.lane = lane;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public String toString(){
        return "#"+lane+", "+city+"-"+pin;
    }
}
