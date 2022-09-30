package com.programacionOO.libs;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

public class Util {
    public static final Scanner lector = new Scanner(System.in);

    /*==== MATH FUNCTIONS ====*/
    public static int random(int min, int max){
        Random r = new Random();
        return r.nextInt(max-min+1)+min;
    }
    public static double randomDouble(int min, int max){
        Random r = new Random();
        return r.nextDouble()*(max-min)+min;
    }
    public static float randomFloat(int min, int max){
        Random r = new Random();
        return r.nextFloat()*(max-min)+min;
    }
    public static float randomFloat(float min, float max){
        Random r = new Random();
        return r.nextFloat()*(max-min)+min;
    }
    public static String randomString(int longitud) {
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String num = "0123456789";
        String drum = abc.toLowerCase() + num;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < longitud; i++) {
            sb.append(drum.charAt(random(0,drum.length()-1)));
        }
        return sb.toString();
    }
    public static int factor(int n){
        if(n == 0 )return 1;
        else return n * factor(n-1);
    }
    public static long sumatori(int n) {
        long sum = 0;
        for(int i = n; i >= 1; i--) {
            sum+=i;
        }
        return sum;
    }

    /*==== IO FUNCTIONS ====*/
    public static String askString(String s) {
        System.out.println(s);
        return lector.nextLine();
    }
    public static String askString(String s, int minLength,int maxLength) {
        boolean isValid = false;
        String data;
        do {
            System.out.println(s);
            data = lector.nextLine();
            isValid = (data.length() >= minLength && data.length() <= maxLength);
            if (!isValid) {
                System.out.printf("Min string length = %s \nMax length = %s ",minLength, maxLength);
            }

        }while (!isValid);
        return data;
    }
    public static int askInteger(String s){
        boolean isValid = false;
        int data = 0;
        do {
            try {
                System.out.println(s);
                data = Integer.parseInt(lector.nextLine());
                isValid = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Enter numbers only");
            }
        }while (!isValid);
        return data;
    }
    public static int askInteger(String s, int min, int max) {
        boolean isValid = false;
        int data;
        do {
            data = askInteger(s);
            isValid = data >= min && data <= max;
            if (!isValid)
                System.out.printf("Number must be between %d - %d\n", min,max);
        }while (!isValid);
        return data;
    }
    public static double askDouble(String s) {
        boolean isValid = false;
        double data = 0;
        do {
            try {
                System.out.println(s);
                data = Double.parseDouble(lector.nextLine());
                isValid = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Enter numbers only");
            }
        }while (!isValid);
        return data;
    }
    public static long askLong(String s) {
        System.out.println(s);
        return Long.parseLong(lector.nextLine());
    }
    public static float askFloat(String s) {
        System.out.println(s);
        return Float.parseFloat(lector.nextLine());
    }
    public static boolean checkDNI(String input) {
        String dniChars = "TRWAGMYFPDXBNJZSQVHLCKE";
        //removing spaces
        String num = input.trim().replaceAll(" ", "").substring(0, 7);
        if (input.charAt(8) < 10) {
            return false;
        }
        //getting letter
        char letter = input.charAt(8);
        //getting num on letter position
        int valid = Integer.parseInt(num) % 23;
        if (input.length() != 9 && dniChars.charAt(valid) != letter) {
            return false;
        } else {
            return true;
        }
    }

    /*==== GEN FUNCTIONS ====*/
    public static int calcAge(Calendar birthDate) {
        Calendar actualDate = Calendar.getInstance();
        int years = actualDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
        int months = actualDate.get(Calendar.MONTH) - birthDate.get(Calendar.MONTH);
        int days = actualDate.get(Calendar.DAY_OF_MONTH) - birthDate.get(Calendar.DAY_OF_MONTH);
        // It is not yet the month of his birthday or
        // it is the month but the day has not arrived.
        if(months < 0 || (months == 0 && days < 0)) {
            years--;
        }
        return years;
    }
    public static char calcLetterDNI(int dni) {
        String table="TRWAGMYFPDXBNJZSQVHLCKE";
        int mod= dni % 23;
        return table.charAt(mod);
    }
    public static int calcularEdad(Calendar fechaNac) {
        Calendar fechaActual = Calendar.getInstance();
        int years = fechaActual.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int months = fechaActual.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int days = fechaActual.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
        // Aún no es el mes de su cumpleaños o
        // es el mes pero no ha llegado el día.
        if(months < 0 || (months==0 && days < 0)) {
            years--;
        }
        return years;
    }
    public static GregorianCalendar generarMayorEdad(int minYear){
        int currentYear = new GregorianCalendar().get(Calendar.YEAR);
        currentYear-=18;
        return new GregorianCalendar(Util.random(minYear, currentYear),
                Util.random(Calendar.JANUARY, Calendar.DECEMBER), Util.random(1,28));
    }

    /**
     * Generates a random date from year to now
     * @param minYear
     * @return
     */
    public static GregorianCalendar generateDate(int minYear){
        int currentYear = new GregorianCalendar().get(Calendar.YEAR);
        return new GregorianCalendar(Util.random(minYear, currentYear),
                Util.random(Calendar.JANUARY, Calendar.DECEMBER), Util.random(1,28));
    }
    /**
     * Generates a random date from year to now
     * useful to ensure all dates are adult (18|21)
     * @param minYear
     * @param adultAge
     * @return
     */
    public static GregorianCalendar generateDate(int minYear, int adultAge){
        int currentYear = new GregorianCalendar().get(Calendar.YEAR);
        currentYear -= adultAge;
        return new GregorianCalendar(Util.random(minYear, currentYear),
                Util.random(Calendar.JANUARY, Calendar.DECEMBER), Util.random(1,28));
    }

    /**
     * Random DNI generator, does not ensure unique results
     * @return String with a full DNI
     */
    public static String randomDNI(){
        String dniChars="TRWAGMYFPDXBNJZSQVHLCKE";
        int num = (int)Math.floor((Util.randomFloat(0.2f,0.8f) * 99999999) + 1);
        int pos = num % 23;
        return  num + "" + dniChars.charAt(pos);
    }
    public static boolean validarDNI(String input) {
        String dniChars = "TRWAGMYFPDXBNJZSQVHLCKE";
        //removing spaces
        String num = input.trim().replaceAll(" ", "").substring(0, 7);
        if (input.charAt(8) < 10) {
            return false;
        }
        //getting letter
        char letter = input.charAt(8);
        //getting num on letter position
        int valid = Integer.parseInt(num) % 23;
        if (input.length() != 9 && dniChars.charAt(valid) != letter) {
            return false;
        } else {
            return true;
        }
    }

    /*==== ARRAY FUNCTIONS ====*/
    public static void showArray(int a[]){
        System.out.printf("[");
        for (int i = 0; i < a.length; i++) {
            System.out.printf(" %d",a[i]);
        }
        System.out.printf(" ]\n");
    }
    public static void showArray(double a[]){
        System.out.printf("[");
        for (int i = 0; i < a.length; i++) {
            System.out.printf(" %.2f",a[i]);
        }
        System.out.printf(" ]\n");
    }
    public static void showArray(char a[]){
        System.out.printf("[");
        for (int i = 0; i < a.length; i++) {
            System.out.printf(" %c",a[i]);
        }
        System.out.printf(" ]\n");
    }

    public static void showParArray(int a[]) {
        for (int i = 0; i < a.length; i+=2) {
            if (a[i] % 2 == 0) {
                System.out.printf("Position array[%d] = %d \n",
                        i , a[i]);
            }
        }
    }
    public static int[] randomArrayInt(int size, int min, int max) {
        int a[] = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = Util.random(min, max);
        }
        return a;
    }
    public static double[] randomArrayDouble(int size, int min, int max) {
        double a[] = new double[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = Util.randomDouble(min, max);
        }
        return a;
    }
    /**
     * Possible filter value by integer
     * @param rate set 0 to default
     * @param a array
     * @return media of double array
     */
    public static double mediaArray(double[] a, int rate) {
        double result = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= rate) {
                result = a[i] + result;
            }
        }
        return result / a.length;
    }
    public static double[] reverseArray(double[] a) {
        double[] newArray = new double[a.length];
        int cont = 0;
        for (int i = a.length; i >= 0; i--) {
            newArray[cont++] = a[i];
            // cont++;
        }
        return newArray;
    }

    /**
     * Search in the array to multiplo and print them
     * @param a
     * @param multi
     *
     **/
    public static void showMultiploArray(int a[], int multi) {
        for (int i = 1; i < a.length; i++) {
            if (multi != 0 && a[i] % multi == 0 ) {
                System.out.printf("Position array[%d] = %d , multiplo %d \n",
                        i , a[i], multi);
            }
            if (multi == 0) {
                System.out.printf("Position array[%d] = %d , multiplo %d \n",
                        i, 0, 0);
            }
        }
    }

    public static int[] insertArray(int arrayLength){
        int a[] = new int[arrayLength];
        for (int i = 0; i < a.length; i++) {
            a[i] = Util.askInteger("Insert value for position " + i);
        }
        return a;
    }
}
