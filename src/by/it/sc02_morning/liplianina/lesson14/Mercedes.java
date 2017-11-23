package by.it.sc02_morning.liplianina.lesson14;

public class Mercedes extends Car {
    public Mercedes(int speed) {
        super(speed = (speed > 200) ? 200 : speed);

    }

    @Override
    public String toString() {
        return "Mercedes";
    }

    @Override
    void beep() {
        System.out.println((this + " сигналит: Фа-фа!"));
    }
}
