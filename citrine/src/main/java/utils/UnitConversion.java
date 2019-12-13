package utils;

public class UnitConversion {

    int radians ;
    int seconds ;
    int meter ;
    int kg ;
    double conversion ;

    public UnitConversion () {
        radians = 0 ;
        seconds = 0 ;
        meter = 0 ;
        kg = 0 ;
        conversion = 1.0 ;
    }

    public void multiplyConversion(double mulValue) {
        conversion *= mulValue ;
    }

    public void divideConversion(double mulValue) {
        conversion /= mulValue ;
    }

    public void incrRadians () {
        ++radians ;
    }

    public void incrSeconds () {
        ++seconds ;
    }

    public void incrMeter () {
        ++meter ;
    }

    public void incrKg () {
        ++kg ;
    }

    public void addRadians (int radians) {
        this.radians += radians ;
    }

    public void addSeconds (int seconds) {
        this.seconds += seconds ;
    }

    public void addMeter (int meter) {
        this.meter += meter ;
    }

    public void addKg (int kg) {

        this.kg += kg ;
    }
    public void decrRadians () {
        --radians ;
    }

    public void decrSeconds () {
        --seconds ;
    }

    public void decrMeter () {
        --meter ;
    }

    public void decrKg () {
        --kg;
    }


    public int getRadians() {
        return radians;
    }

    public void setRadians(int radians) {
        this.radians = radians;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMeter() {
        return meter;
    }

    public void setMeter(int meter) {
        this.meter = meter;
    }

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    public double getConversion() {
        return conversion;
    }

    public void setConversion(double conversion) {
        this.conversion = conversion;
    }
}
