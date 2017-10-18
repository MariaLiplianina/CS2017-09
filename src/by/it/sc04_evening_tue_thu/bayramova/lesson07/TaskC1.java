package by.it.sc04_evening_tue_thu.bayramova.lesson07;
/*
Три массива
1.  Введите с клавиатуры 20 чисел, сохраните их в список и рассортируйте по трём другим спискам:
    Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
    Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2.  Статический метод void printList(List<Integer> list) должен выводить на экран
    все элементы переданного ему списка list, каждый элемент - с новой строки.
3.  Используя метод printList выведите ваши три списка на экран.
    Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC1 {
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer>a=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        for (int i=0; i<20; i++) {
            a.add(sc.nextInt());
        }
        ArrayList<Integer>a1=new ArrayList<Integer>();
        ArrayList<Integer>a2=new ArrayList<Integer>();
        ArrayList<Integer>a3=new ArrayList<Integer>();
        for (int i = 0; i < a.size(); i++) {
            Integer x = a.get(i);
            if (x%2==0) {
                a1.add(x);
            }
            if (x%3==0) {
                a2.add(x);
            }
            else if(x%2!=0) {
                a3.add(x);
            }


        }
        printList(a2);
        printList(a1);
        printList(a3);


    }

    private static void printList(List<Integer> list) {
        for (Integer aList : list) System.out.println(aList);
    }


}
