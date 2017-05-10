package com.example.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Created by GBR8657 on 4/27/2017.
 */
public class LambdaExample {
    public static void main(String[] args) {

        List<Integer> numbers;// = Arrays.asList(1,2,3,4,5,6,7,8,9);
        numbers = new ArrayList<>();
        for(int i=0;i<10000;i++){
            numbers.add(i);
        }
        // Step1
        /*Consumer<Integer> consumer = new Consumer<Integer>(){
            public void accept(Integer i){
                System.out.print("\t" + i);
            }
        };*/
        // Step2
        //Consumer<Integer> consumer = (Integer i) -> System.out.print("\t" + i);
        // Step3
        //Consumer<Integer> consumer = i -> System.out.print("\t" + i);
        //numbers.forEach(consumer);

        // Step4
        /*numbers.forEach(i -> {
            int sum=0;
            if(i>10) {
                sum += i;
                System.out.print("\t" + sum);
            }
        });*/

        System.out.println("Sum of numbes: " + addNumbersUsingIterator(numbers));
        //System.out.println("Sum of numbes: " + addNumbersUsingStream(numbers));
    }

    // This is called sequential program, can't easily be parallelized.
    private static long addNumbersUsingIterator(List<Integer> numbers) {
        long startTime = System.currentTimeMillis();
        Iterator<Integer> number = numbers.iterator();
        long sum = 0;
        while (number.hasNext()) {
            long num = number.next();
            if (num > 10) {
                sum += num;
            }
        }
        System.out.println("time taken for addNumbersUsingIterator: " + (System.currentTimeMillis() - startTime));
        return sum;
    }

    private static long addNumbersUsingStream(List<Integer> numbers) {
        long startTime = System.currentTimeMillis();
        long result = numbers.stream().filter(i -> i > 10).mapToLong(i -> i).sum();
        System.out.println("time taken for addNumbersUsingStream: " + (System.currentTimeMillis() - startTime));
        return result;
    }
}
