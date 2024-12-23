public class KineticEnergy extends PhysicalObject {

    public KineticEnergy(double mass, double speed) {
        super(mass, speed);
    }

    public double calculateEnergy() {
        return 0.5 * mass * Math.pow(speed, 2);
    }

    @Override
    public String toString() {
        return "масса = " + mass + "м/с, скорость = " + speed + "км/ч, энергия = " + calculateEnergy() + "Дж.";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        KineticEnergy that = (KineticEnergy) obj;
        return Double.compare(that.calculateEnergy(), this.calculateEnergy()) == 0;
    }
}
