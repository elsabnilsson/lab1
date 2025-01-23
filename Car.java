import java.awt.*;

public abstract class Car implements Movable{
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public double xpos;
    public double ypos;
    public String direction;

    public Car(int nrDoors, Color color, double enginePower, String modelName, int xpos, int ypos, String direction){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.xpos = 0;
        this.ypos = 0;
        this.direction = "N";
        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public void move() {
        switch (direction) {
            case "N" -> ypos += currentSpeed;
            case "E" -> xpos += currentSpeed;
            case "S" -> ypos -= currentSpeed;
            case "W" -> xpos -= currentSpeed;
        }
    }

    public void turnLeft() {
        switch (direction) {
            case "N" -> direction = "W";
            case "E" -> direction = "N";
            case "S" -> direction = "E";
            case "W" -> direction = "S";
        }
    }

    public void turnRight() {

    }

    public double getEnginePower() { return enginePower; }

    public double getCurrentSpeed() { return currentSpeed; }

    public Color getColor() { return color; }

    public void setColor(Color clr) { color = clr; }

    public void startEngine() { currentSpeed = 0.1; }

    public void stopEngine() { currentSpeed = 0; }

    abstract double speedFactor();

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

}

