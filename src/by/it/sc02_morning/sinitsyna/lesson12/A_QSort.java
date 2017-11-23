package by.it.sc02_morning.sinitsyna.lesson12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
Это тот случай когда задача A будет довольно сложной.
Если вы не решите ее за предложенное время, на ближайшем занятии
мы обсудим верное решение. Оно довольно простое, но не очевидное.

Задача. Видеорегистраторы и площадь.

На площади установлены камеры.
Известны данные о том, когда каждая из них включалась и выключалась (отрезки работы)
Известен список событий на площади (время начала каждого события).
Вам необходимо определить для каждого события сколько камер его записали.

В первой строке задано два целых числа:
    число включений камер (отрезки) 1<=n<=50000
    число событий (точки) 1<=m<=50000.

Следующие n строк содержат по два целых числа ai и bi (ai<=bi) -
координаты концов отрезков (время работы одной какой-то камеры).
Последняя строка содержит m целых чисел - координаты точек (время начала каждого события).
Все координаты не превышают 10E8 по модулю (!).

Точка считается принадлежащей отрезку, если она находится внутри него или на границе.

Для каждой точки в порядке их появления во вводе выведите,
скольким отрезкам она принадлежит.
    Sample Input:
    2 3
    0 5
    7 10
    1 6 11
    Sample Output:
    1 0 0

Подсказки и проверка решения:
1) самый быстрый алгоритм имеет сложность O(n log n)
2) этот код имеет внутренний класс Segment, можно добавить другие по аналогии
3) заготовку программы придется довольно изрядно доработать
*/

public class A_QSort {

    class Event implements Comparable<Event> {
        int time;
        int type;
        int index;

        public Event(int time, int type) {
            this.time = time;
            this.type = type;
        }

        public Event(int time, int type, int index) {
            this.time = time;
            this.type = type;
            this.index = index;
        }


        @Override
        public String toString() {
            return "{" + time + ", " + type+"}";
        }

        @Override
        public int compareTo (Event other) {
            int result=this.time-other.time;
            if (result==0)
                result=-this.type+other.type;
            return result;
        }
    }

    //отрезок
    private class Segment  implements Comparable<Segment> {
        int start;
        int stop;

        Segment(int start, int stop) {
            this.start = start;
            this.stop = stop;
            //тут можно доделать конструктор на случай если
            //концы отрезков придут в обратном порядке
        }

        @Override
        public int compareTo(Segment otherSegment) {
            //подумайте, что должен возвращать компаратор отрезков
            //и нужен ли он вообще.
            return this.stop - otherSegment.stop;
        }

        @Override
        public String toString() {
            return "(" + start + ":" + stop + ')';
        }
    }

    int[] getAccessory(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //число отрезков отсортированного массива
        int n = scanner.nextInt();
        Segment[] segments=new Segment[n];
        //число точек
        int m = scanner.nextInt();
        int[] points=new int[m];
        int[] result=new int[m];

        Event[] events=new Event[2*n+m];
        int counterEvent=0;
        //читаем сами отрезки
        for (int i = 0; i < n; i++) {
            //читаем начало и конец каждого отрезка
            segments[i]=new Segment(scanner.nextInt(),scanner.nextInt());
            events[counterEvent++]=new Event (segments[i].start, +1);
            events[counterEvent++]=new Event (segments[i].stop, -1);
        }
        System.out.println("segments="+ Arrays.toString(segments));
        //читаем точки
        for (int i = 0; i < m; i++) {
            points[i]=scanner.nextInt();
            events[counterEvent++]=new Event (points[i],0,i);
        }
        System.out.println("points="+ Arrays.toString(points));
        //тут реализуйте логику задачи
        //ОБЯЗАТЕЛЬНО с применением быстрой сортировки

        System.out.println("events1="+Arrays.toString(points));
        Arrays.sort(events);
        System.out.println("events2="+Arrays.toString(points));

        int onCam=0;
        int i=0;
        for (Event e:events) {
            if (e.type!=0) {
                onCam = onCam + e.type;
            }
            else
                result[e.index]=onCam;
        }
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }
    void QuickSort(int a[], int left, int right){
        if (left >= right)
            return;
            int m = partition(a, left, right);
        QuickSort(a, left, m-1);
        QuickSort(a, m + 1, right);
        }
    void QuickSort(Segment [] a, int left, int right) {
        if (left >= right)
            return;
        int m = partition(a, left, right);
        QuickSort(a, left, m - 1);
        QuickSort(a, m + 1, right);
    }

    void QuickSort(int [] a){QuickSort(a,0,a.length-1);}
    void QuickSort(Segment [] a){QuickSort(a,0,a.length-1);}


    int partition(int[] a, int left, int right) {
        int x=a[left];
        int j=left;
        for (int i = left+1; i <= right; i++) {
            if (a[i]<=x){
                j = j+1;
                int tmp=a[j];
                a[j]=a[i];
                a[i]=tmp;
            }
        }
        int tmp=a[j];
        a[j]=a[left];
        a[left]=tmp;
        return j;
    }
    int partition(Segment[] a, int left, int right) {
        int j = left;
        Segment x = a[left];
        for (int i = left + 1; i < right; i++) {
            if (a[i].compareTo(x) <= 0) {
                j = j + 1;
                Segment tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }
        Segment tmp = a[j];
        a[j] = a[left];
        a[left] = tmp;
        return j;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/sc02_morning/sinitsyna/lesson12/dataA.txt");
        A_QSort instance = new A_QSort();
        int[] result=instance.getAccessory(stream);
        System.out.println("result="+ Arrays.toString(result));
    }
}