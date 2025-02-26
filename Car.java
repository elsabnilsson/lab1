import java.awt.*;

public abstract class Car implements Movable{
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private final String modelName;
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private double xpos;
    private double ypos;
    private int direction;
    private final double carLength;

    public Car(int nrDoors, Color color, double enginePower, String modelName, int xpos, int ypos, int direction, double carLength){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.xpos = 0;
        this.ypos = 0;
        this.direction = 0;
        this.carLength = carLength;
        this.modelName = modelName;
        stopEngine();
    }
    
    public String getModelName() { return modelName; }

    public double getCarLength() { return carLength; }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getXpos() { return xpos; }
    public double getYpos() { return ypos; }
    public int getDirection() { return direction; }

    public void setPosition(double x, double y){
        xpos = x;
        ypos = y;
    }

    // Makes car move in the direction it is facing (task 2)
    public void move(){
            switch (direction){
                case 0 -> ypos += currentSpeed;
                case 1 -> xpos += currentSpeed;
                case 2 -> ypos -= currentSpeed;
                case 3 -> xpos -= currentSpeed;
            }
    }

    // Makes car turn left (task 2)
    public void turnLeft(){
        direction = (direction + 3) % 4;
    }

    // Makes car turn right (task 2)
    public void turnRight(){
        direction = (direction + 1) % 4;
    }

    abstract boolean canStart();

    public double getEnginePower() { return enginePower; }

    public double getCurrentSpeed() { return currentSpeed; }

    public Color getColor() { return color; }

    public void setColor(Color clr) { color = clr; }

    // Starts the engine
    public void startEngine() {
        if (canStart()) { currentSpeed = 0.1; }}

    // Stops the engine
    public void stopEngine() { currentSpeed = 0; }

    // Abstract method - implemented in subclasses
    abstract double speedFactor();

    // Makes sure that currentSpeed is always below or equal to enginePower (task 4)
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }
    // Makes sure that currentSpeed is always above or equal to zero (task 4)
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    // Checks if the amount is within the bounds of 0 and 1
    public void checkAmount(double amount){
        if (amount < 0 || amount > 1){
            throw new IllegalArgumentException("Amount out of bounds");
        }
    }
    // Makes the car go faster
    public void gas(double amount){
        checkAmount(amount);
        incrementSpeed(amount);
    }

    // Makes the car go slower
    public void brake(double amount){
        checkAmount(amount);
        decrementSpeed(amount);
    }




}

