package training.experis;

public class Polynomial {
    public double calculatePolynom(double x, double ... coef ){
        int degree = coef.length - 1;
        double result = 0;

        if (degree == 0){
            return coef[0];
        }

        if (x == 0){
            return coef[coef.length-1];
        }

        for (int i=0; i<coef.length; i++){
            result = result + (coef[i] * Math.pow(x,degree));
            degree--;
        }
        return result;
    }


    public void printPolynom(double ... coef) {
        StringBuilder str = new StringBuilder("P(x)=");
        int degree = coef.length - 1;

        if (degree == -1){
            str.append(0);
            System.out.println(str);
            return;
        }
        else if (degree == 0){
            str.append(coef[0]);
            System.out.println(str);
            return;
        }
        else if (degree == 1){
            str.append(coef[0] + "x + " + coef[1]);
            System.out.println(str);
            return;
        }

        str.append(coef[0] + "x^" + degree);
        degree--;

        for (int i = 1; i < coef.length; i++) {

            if (coef[i] == 0){
                continue;
            }

            else if (coef[i]  > 0){
                str.append(" + " + (coef[i]));
            }

            else if (coef[i]  < 0) {
                str.append(" - " + (-coef[i]));
            }

            if (i ==  coef.length-2) {
                str.append("x");
            }

            else if (i <  coef.length-2) {
                str.append("x^" + degree);
            }

            degree--;
        }
        System.out.println(str);
    }
}
