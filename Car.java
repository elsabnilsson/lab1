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

    // Makes car move in the direction it is facing (task 2)
    public void move() {
        switch (direction) {
            case "N" -> ypos += currentSpeed;
            case "E" -> xpos += currentSpeed;
            case "S" -> ypos -= currentSpeed;
            case "W" -> xpos -= currentSpeed;
        }
    }

    // Makes car turn left (task 2)
    public void turnLeft() {
        switch (direction) {
            case "N" -> direction = "W";
            case "E" -> direction = "N";
            case "S" -> direction = "E";
            case "W" -> direction = "S";
        }
    }

    // Makes car turn right (task 2)
    public void turnRight() {
        switch (direction) {
            case "N" -> direction = "E";
            case "E" -> direction = "S";
            case "S" -> direction = "W";
            case "W" -> direction = "N";
        }
    }

    public double getEnginePower() { return enginePower; }

    public double getCurrentSpeed() { return currentSpeed; }

    public Color getColor() { return color; }

    protected void setColor(Color clr) { color = clr; }

    // Starts the engine
    public void startEngine() { currentSpeed = 0.1; }

    // Stops the engine
    public void stopEngine() { currentSpeed = 0; }

    // Abstract method - implemented in subclasses
    abstract double speedFactor();

    // Makes sure that currentSpeed is always below or equal to enginePower (task 4)
    protected void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }
    // Makes sure that currentSpeed is always above or equal to zero (task 4)
    protected void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // Makes the car go faster
    public void gas(double amount){
        if (amount < 0 || amount > 1){
            throw new IllegalArgumentException("Amount out of bounds");
        }
        else
            incrementSpeed(amount);
    }

    // Makes the car go slower
    public void brake(double amount){
        if (amount < 0 || amount > 1){
            throw new IllegalArgumentException("Amount out of bounds");
        }
        else
            decrementSpeed(amount);
    }

}

