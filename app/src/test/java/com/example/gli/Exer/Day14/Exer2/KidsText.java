package com.example.gli.Exer.Day14.Exer2;

import org.junit.Test;


public class KidsText {
    @Test
    public void main(){
        Kids k = new Kids();
        k.setYearsOld(15);
        Kids k1 = new Kids(1,0,18);
        k1.printAge();
        k1.employeed();
//        k1.manOrWoman();
    }

}
