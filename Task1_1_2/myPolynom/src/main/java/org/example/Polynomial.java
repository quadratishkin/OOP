package org.example;

import java.util.Arrays;

public class Polynomial
{
    final private int[] coefficients;

    private int[] delZero(int[] arr) {
        int nulls = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                nulls++;
            } else {
                break;
            }
        }

        int[] newArr = new int[arr.length - nulls];
        System.arraycopy(arr, 0, newArr, 0, newArr.length);

        return newArr;
    }


    public Polynomial(int[] new_coefficients)
    {
        this.coefficients = Arrays.copyOf(new_coefficients, new_coefficients.length);
    }

    public Polynomial plus(Polynomial secondPol) // sum of two polynomials
    {
        int max = Math.max(this.coefficients.length, secondPol.coefficients.length);
        int[] newArr = new int[max];

        for (int i = 0; i < secondPol.coefficients.length; i ++)
        {
            newArr[i] += secondPol.coefficients[i];
        }
        for (int i = 0; i < this.coefficients.length; i ++)
        {
            newArr[i] += this.coefficients[i];
        }
        newArr = delZero(newArr);
        return new Polynomial(newArr);
    }

    public Polynomial minus(Polynomial second) // subtrahend two polynomials
    {
        int maxLength = Math.max(this.coefficients.length, second.coefficients.length);
        int[] newArr = new int[maxLength];

        for (int i = 0; i < second.coefficients.length; i++)
        {
            newArr[i] -= second.coefficients[i];
        }
        for (int i = 0; i < this.coefficients.length; i++)
        {
            newArr[i] += this.coefficients[i];
        }
        newArr = delZero(newArr);
        return new Polynomial(newArr);
    }

    public Polynomial times(Polynomial times) // multiply two polynomials
    {
        int maxLength = this.coefficients.length + times.coefficients.length;
        int[] newArr = new int[maxLength];

        for (int i = 0; i < this.coefficients.length; i ++)
        {
            for (int j = 0; j < times.coefficients.length; j ++)
            {
                newArr[i+j] += this.coefficients[i] * times.coefficients[j];
            }
        }
        newArr = delZero(newArr);
        return new Polynomial(newArr);
    }

    public Polynomial differentiate(int n)
    {
        int[] result = Arrays.copyOf(this.coefficients, this.coefficients.length);
        if (n == 0)
        {
            result = delZero(result);
            return new Polynomial(result);
        }
        result[this.coefficients.length - 1] = 0;
        for (int i = 0; i < this.coefficients.length - 1; i++)
        {
            result[i] = this.coefficients[i+1] * (i+1);
        }
        result = delZero(result);
        return new Polynomial(result).differentiate(n-1);
    }

    public int evaluate(int x)
    {
        int res = this.coefficients[0];
        for (int i = 1; i < this.coefficients.length; i++)
        {
            res += (int) (Math.round(Math.pow(x, i)) * this.coefficients[i]);
        }
        return res;
    }

    @Override
    public String toString()
    {
        var stroka = "";
        boolean beginning = Boolean.TRUE;
        for (int i = this.coefficients.length - 1; i >= 0; i--)
        {
            if (this.coefficients[i] != 0)
            {
                if (beginning)
                {
                    beginning = Boolean.FALSE;
                }
                else
                {
                    stroka = stroka.concat(" + ");
                }

                if (this.coefficients[i] != 1)
                {
                    stroka = stroka.concat("" + this.coefficients[i]);
                }
                if (i > 1)
                {
                    stroka = stroka.concat("x^" + i);
                }
                if (i == 1)
                {
                    stroka = stroka.concat("x");
                }
            }
        }
        return stroka;
    }

    public int[] getCoefficients() {
        int[] copy = new int[coefficients.length];
        System.arraycopy(coefficients, 0, copy, 0, coefficients.length);
        return copy;
    }

}