package by.it.sc04_evening_tue_thu.tokun.lesson14;

public class Maz extends Car {
    Maz (int speed) {
        super((speed <= 80)?speed:80 );
    }

    @Override
    void beep() {
        System.out.println(this + " сигналит: У-у-у-у!");
    }

    @Override
    public String toString() {
        return "Maz";
    }

    @Override
    void fire() {
        System.out.println(this + " включил зажигание");
    }
}
