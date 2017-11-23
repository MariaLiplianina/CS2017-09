package by.it.sc02_morning.liplianina.lesson14;

public class Maz extends Car {

    public Maz(int speed) {
        super(speed = (speed > 80) ? 80 : speed);

    }

    @Override
    public String toString() {
        return "Maz";
    }

    @Override
    void beep() {
        System.out.println((this + " сигналит: У-у-у-у!"));
    }
}
