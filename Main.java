interface Drivable {
    void accelerate(int speedIncrease);
    void brake();
}

class Car implements Drivable {
    private int speed;
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
        this.speed = 0;
    }

    public void accelerate(int speedIncrease) {
        engine.increasePower();
        speed += speedIncrease;
    }

    public void brake() {
        engine.decreasePower();
        speed = Math.max(speed - 10, 0); 
    }

    public void start() {
        engine.start();
    }

    public void stop() {
        engine.stop();
        speed = 0;
    }
}

interface Engine {
    void start();
    void stop();
    void increasePower();
    void decreasePower();
}

class GasolineEngine implements Engine {
    private boolean isRunning;
    private int power;

    public GasolineEngine() {
        this.isRunning = false;
        this.power = 0;
    }

    public void start() {
        if (!isRunning) {
            isRunning = true;
            System.out.println("Двигатель запущен.");
        }
    }

    public void stop() {
        if (isRunning) {
            isRunning = false;
            power = 0;
            System.out.println("Двигатель остановлен.");
        }
    }

    public void increasePower() {
        if (isRunning) {
            power += 10;
            System.out.println("Мощность увеличена до " + power + ".");
        }
    }

    public void decreasePower() {
        if (isRunning) {
            power -= 10;
            System.out.println("Мощность уменьшена до " + power + ".");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Engine engine = new GasolineEngine();
        Car car = new Car(engine);
        car.start();
        car.accelerate(50);
        car.brake();
        car.stop();
    }
}