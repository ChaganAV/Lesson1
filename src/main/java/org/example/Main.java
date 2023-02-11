package org.example;

import java.util.Random;

public class Main {
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
        System.out.println(String.format("Старший бит %1$s - это %2$s по счету %3$s",b,bit,n));
        // найдем кратные
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
            StringBuffer sb1 = new StringBuffer();
            sb1.append("m1 [");
            for(int j=0;j<tmp1.length;j++){
                if(tmp1[j]!=0) {
                    m1[count] = tmp1[j];
                    sb1.append(m1[count]);
                    count++;
                    if(count < m1.length-1) sb1.append(",");
                    else sb1.append("]");
                }
            }
            System.out.println(sb1.toString());
        }
        //System.out.println();
        // ищем некратные
        int size2 = Short.MAX_VALUE;
        //System.out.printf(String.format("%1$d",size2));
        int[] negative = new int[size2];
        int count = 0;
        for(int j = Short.MIN_VALUE; j < 0; j++){
            if (j%n==0) {
                negative[count] = j;
                count++;
            }
        }
        int[] positive = new int[i];
        for(int j = 0; j < i; j++){
            if(j%n==0) {
                positive[j] = j;
            }
        }

        int count1 = 0;
        for(int j = 0; j < negative.length; j++)// по массиву от Short.MIN_VALUE до 0
            if (negative[j]!=0) count1++;
        int count2 = 0;
        for(int j = 0; j < positive.length; j++)// от 0 до i
            if (positive[j]!=0) count2++;

        StringBuilder sb2 = new StringBuilder();
        sb2.append("m2 [");
        int sizeAll = count1+count2;
        int[] m2 = new int[sizeAll];
        for(int j = 0; j<count1;j++){ // заполним отрицательными
            if(negative[j]!=0){
                m2[j]=negative[j];
                sb2.append(m2[j]);
                sb2.append(",");
            }
        }
        count = 0;
        for(int j = count1; j < sizeAll; j++) { // заполним положительными
            if(positive[count]!=0){
                m2[j]=positive[count];
                sb2.append(m2[j]);
                if(j<sizeAll-1) sb2.append(",");
                else sb2.append("]");
            }
            else{
                if(j==sizeAll-1) sb2.append("]");
            }
            count++;
        }
        System.out.println(sb2.toString());
        //int a = 0;
    }
}