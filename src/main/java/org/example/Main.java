package org.example;

import java.util.Random;

public class Main {
    // static int min = 0;
    // static int max = 2000;
    public static void main(String[] args) {
        /*Первый семинар.
        1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
        Пункты реализовать в методе main
        *Пункты реализовать в разных методах
        int i = new Random().nextInt(k); //это кидалка случайных чисел!)*/
        int max = 2000;
        int i = new Random().nextInt(max);
        String b = Integer.toBinaryString(i);
        char bit = b.charAt(0);
        int n = b.length();
        System.out.println(String.format("i = %1$d",i));
        System.out.println(String.format("Старший бин %1$s - это %2$s по счету %3$s",b,bit,n));
        if (i>Short.MAX_VALUE)
            System.out.println("Не возможно создать массив данной размерности");
        else {
            int count = 0;
            int size = Short.MAX_VALUE - i;
            int[] tmp1 = new int[size];
            for(int j = 0; j<size; j++){
                if(j%n==0){
                    tmp1[j] = j;
                    count++;
                }
            }
            int[] m1 = new int[count];
            count=0;
            for(int j=0;j<tmp1.length;j++){
                if(tmp1[j]!=0) {
                    m1[count] = tmp1[j];
                    System.out.println(m1[count]);
                    count++;
                }
            }
        }
    }
}