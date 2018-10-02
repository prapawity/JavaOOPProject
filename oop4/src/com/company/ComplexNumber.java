package com.company;

public class ComplexNumber {
    double re, im;
    @Override
    public String toString(){
       return Double.toString(im);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ComplexNumber && ((ComplexNumber)(obj)).im == im && ((ComplexNumber)(obj)).re == re)
            return true;
        else return false;
    }

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static void main(String[] args) {
        ComplexNumber re = new ComplexNumber(1234, 12345);
        ComplexNumber re2 = new ComplexNumber(1234,12345);
        System.out.println(re.equals(re2));
    }
}
