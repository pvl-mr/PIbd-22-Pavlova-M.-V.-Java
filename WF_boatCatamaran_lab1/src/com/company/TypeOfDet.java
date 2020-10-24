package com.company;

public enum TypeOfDet {
    EMPTY,
    FLOAT_TYPE1,
    FLOAT_TYPE2,
    FLOAT_TYPE3;

    public static TypeOfDet fromNumeric(int n) {
        switch (n) {
            case 1:
                return FLOAT_TYPE1;
            case 2:
                return FLOAT_TYPE2;
            case 3:
                return FLOAT_TYPE3;
            default:
                return EMPTY;
        }
    }
}
