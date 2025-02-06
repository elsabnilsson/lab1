public class TruckBed {
    private double angle;
    private final double maxAngle = 70;
    private final double minAngle = 0;

    public TruckBed() { angle = 0; }

    public double getAngle() { return angle; }

    // open
    public void raiseBed(double amount) {
        angle = Math.min(angle + amount, maxAngle); }

    // close
    public void lowerBed(double amount) {
        angle = Math.max(angle - amount, minAngle); }

    public boolean isBedDown() {
        return angle == 0; }
}
