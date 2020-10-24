package com.company;

public enum Detail {

    ONE,
    TWO,
    THREE,
    EMPTY;

    public static Detail toNum(int n){
        switch (n){
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            default:
                return EMPTY;

        }
    }

}
