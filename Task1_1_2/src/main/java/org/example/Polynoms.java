package org.example;

public class Polynoms {
    private double[] coefficients;
    private double error_rate = 0.00001;


    public Polynoms(double[] inputCoef) {
        if (inputCoef.length == 0) {
            coefficients = new double[]{0};
            delZero();
        } else {
            coefficients = inputCoef.clone();
            delZero();
        }
        delZero();
    }

    public Polynoms(int[] inputCoef) {
        if (inputCoef.length == 0) {
            coefficients = new double[]{0};
        } else {
            coefficients = new double[inputCoef.length];
            for (int i = 0; i < inputCoef.length; i++) {
                coefficients[i] = inputCoef[i];
            }
        }
        delZero();
    }

    private String doubleToString(double x) {
        if (x % 1 == 0) {
            return String.valueOf((int) x);
        }
        return String.valueOf(x);
    }

    private boolean doubleEquals(double x, double y) {
        return Math.abs(x - y) < error_rate;
    }

    private void delZero() {
        int len = coefficients.length;
        while (len > 1 && doubleEquals(coefficients[len - 1], 0)) {
            len -= 1;
        }
        double[] newCoef = new double[len];
        System.arraycopy(coefficients, 0, newCoef, 0, len);
        coefficients = newCoef;
    }

    public double[] getCoefficients() {
        return coefficients.clone();
    }

    public Polynoms plus(Polynoms Polynoms) {
        double[] coef = Polynoms.getCoefficients();

        double[] res = new double[Math.max(coef.length, coefficients.length)];
        for (int i = 0; i < res.length; i++) {
            if (i < coef.length) {
                res[i] += coef[i];
            }
            if (i < coefficients.length) {
                res[i] += coefficients[i];
            }
        }
        return new Polynoms(res);
    }

    public Polynoms minus(Polynoms Polynoms) {
        var negCoef = Polynoms.getCoefficients();
        for (int i = 0; i < negCoef.length; i++) {
            negCoef[i] = -negCoef[i];
        }

        return plus(new Polynoms(negCoef));
    }

    public Polynoms times(Polynoms Polynoms) {
        double[] coef = Polynoms.getCoefficients();
        double[] newCoef = new double[coefficients.length + coef.length];

        for (int i = 0; i < coef.length; i++) {
            for (int j = 0; j < coefficients.length; j++) {
                newCoef[i + j] += coefficients[j] * coef[i];
            }
        }
        return new Polynoms(newCoef);
    }


    public double evaluate(double x) {
        double res = 0;
        double X = 1;
        for (double coefficient : coefficients) {
            res += coefficient * X;
            X *= x;
        }
        return res;
    }


    public Polynoms differentiate(int n) {
        double[] newCoef = new double[coefficients.length - n];

        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        for (int i = 0; i < newCoef.length; i++) {
            newCoef[i] = coefficients[i + n] * fact;
            fact = fact * (i + n + 1) / (i + 1);
        }
        return new Polynoms(newCoef);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        var Polynoms = (Polynoms) obj;

        double[] coef = Polynoms.getCoefficients();

        if (coefficients.length != coef.length) {
            return false;
        }
        for (int i = 0; i < coefficients.length; i++) {
            if (!doubleEquals(coefficients[i], coef[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        int len = coefficients.length;

        if (len > 2) {
            if (coefficients[len - 1] < 0) {
                str.append("- ");
            }
            str.append(doubleToString(Math.abs(coefficients[len - 1])));
            str.append("x^" + (len - 1));
        }

        for (int i = coefficients.length - 2; i > 0; i--) {
            if (coefficients[i] != 0) {
                if (coefficients[i] > 0) {
                    str.append(" + ");
                    if (coefficients[i] != 1) {
                        str.append(doubleToString(coefficients[i]));
                    }
                } else if (coefficients[i] < 0) {
                    str.append(" - ");
                    if (coefficients[i] != -1) {
                        str.append(doubleToString(-coefficients[i]));
                    }
                }
                if (i > 1) {
                    str.append("x^").append(i);
                } else {
                    str.append("x");
                }
            }
        }

        if (coefficients[0] < 0) {
            str.append(" - ").append(doubleToString(-coefficients[0]));
        } else if (len > 1 && coefficients[0] != 0) {
            str.append(" + ").append(doubleToString(coefficients[0]));
        } else if (len == 1) {
            str.append(doubleToString(coefficients[0]));
        }
        return str.toString();
    }
}