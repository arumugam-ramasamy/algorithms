package utils;

import java.awt.*;

public class GrammarConstants {

    final static Long MINUTE = 65L ;
    final static Long HOUR = 65L << 7 ;
    final static Long DAY = 65L << 14;
    final static Long DEGREE = 65L << 21 ;
    final static Long ARCMINUTE = 65L << 28 ;
    final static Long ARCSECOND = 65L << 35 ;
    final static Long HECTARE = 65L << 42 ;
    final static Long LITRE = 65L << 49 ;
    final static Long TONNE = 65L << 56 ;

    public GrammarConstants() {
    }

    public static Long getMINUTE() {
        return MINUTE;
    }

    public static  String getMINUTEString() {
        return String.valueOf(MINUTE) ;
    }

    public static Long getHOUR() {
        return HOUR;
    }

    public static  String getHOURString() {
        return (String.valueOf(HOUR)) ;
    }

    public static Long getDAY() {
        return DAY;
    }

    public static String getDAYString () {
        return (String.valueOf(DAY)) ;
    }

    public static Long getDEGREE() {
        return DEGREE;
    }

    public static String getDEGREEString() {
        return (String.valueOf(DEGREE)) ;
    }

    public static Long getARCMINUTE() {
        return ARCMINUTE;
    }

    public static String getARCMINUTEString() {
        return (String.valueOf(ARCMINUTE)) ;
    }

    public static Long getARCSECOND() {
        return ARCSECOND;
    }

    public static String getARCSECONDString() {
        return (String.valueOf(ARCSECOND)) ;
    }

    public static Long getHECTARE() {
        return HECTARE;
    }

    public static String getHECTAREString() {
        return (String.valueOf(HECTARE)) ;
    }

    public static Long getLITRE() {
        return LITRE;
    }

    public static String getLITREString() {
        return (String.valueOf(LITRE)) ;
    }

    public static Long getTONNE() {
        return TONNE;
    }

    public static String getTONNEString() {
        return (String.valueOf(TONNE)) ;
    }


}
