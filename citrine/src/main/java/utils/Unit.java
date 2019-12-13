package utils;

public class Unit {

    final int MINUTE = 1 ;
    final int HOUR = 2 ;
    final int DAY = 3 ;
    final int DEGREE = 4 ;
    final int ARCMINUTE = 5 ;
    final int ARCSECOND = 6 ;
    final int HECTARE = 7 ;
    final int LITRE = 8 ;
    final int TONNE = 9 ;

    Long minute ;
    Long hectare ;
    Long hour ;
    Long day ;
    Long degree ;
    Long arcminute ;
    Long arcsecond ;
    Long litre ;
    Long tonne ;

    public  Unit () {
        minute  = (64L << ((MINUTE-1) * 7)) ;
        hour = (64L << ((HOUR-1) * 7)) ;
        day = (64L << ((DAY-1) * 7)) ;
        degree =  (64L << ((DEGREE-1) * 7)) ;
        arcminute = (64L << ((ARCMINUTE-1) * 7)) ;
        arcsecond = (64L << ((ARCSECOND-1) * 7)) ;
        hectare = (64L << ((HECTARE-1) * 7)) ;
        litre = (64L << ((LITRE -1) * 7)) ;
        tonne = (64L << ((TONNE-1) * 7)) ;
    }

    public void augmentUnit (int type, Long change) {
        switch (type) {
            case MINUTE:
                minute += change ;
                break ;
            case HECTARE:
                hectare += change ;
                break ;
            case HOUR:
                hour += change ;
                break ;
            case DAY:
                day += change ;
                break ;
            case DEGREE:
                degree += change ;
                break ;
            case ARCMINUTE:
                arcminute += change ;
                break ;
            case ARCSECOND:
                arcsecond += change ;
                break ;
            case TONNE:
                tonne += change ;
                break ;
            case LITRE:
                litre += change ;
                break    ;
            default:
                break ;
        }

    }

    public Long getMinute() {
        return minute;
    }

    public void setMinute(Long nminute) {
        this.minute = minute;
    }

    public Long getHour() {
        return hour;
    }

    public void setHour(Long nhour) {
        this.hour = hour;
    }

    public Long getDay() {
        return day;
    }

    public void setDay(Long nday) {
        this.day = day;
    }

    public Long getDegree() {
        return degree;
    }

    public void setDegree(Long ndegree) {
        this.degree = degree;
    }

    public Long getArcminute() {
        return arcminute;
    }

    public void setArcminute(Long narcminute) {
        this.arcminute = arcminute;
    }

    public Long getArcsecond() {
        return arcsecond;
    }

    public void setArcsecond(Long narcsecond) {
        this.arcsecond = arcsecond;
    }

    public Long getHectare() {
        return hectare;
    }

    public void setHectare(Long nhectare) {
        this.hectare = hectare;
    }

    public Long getLitre() {
        return litre;
    }

    public void setLitre(Long nlitre) {
        this.litre = litre;
    }

    public Long getTonne() {
        return tonne;
    }

    public void setTonne(Long ntonne) {
        this.tonne = tonne;
    }

    public void incrMinute () {

    }

    public void printUnits () {
        System.out.println ("Minute = " + getMinute()) ;
        System.out.println("Hour = " + getHour()) ;
        System.out.println("Day = " + getDay());
        System.out.println ("Degree = " + getDegree()) ;
        System.out.println ("Arcminute = " + getArcminute()) ;
        System.out.println("Arcsecond = " + getArcsecond());
        System.out.println("Hectare = " + getHectare());
        System.out.println("Litre = " + getLitre());
        System.out.print("Tonne = " + getTonne());
    }
}
