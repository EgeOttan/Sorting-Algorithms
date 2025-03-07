/*
// Title: Homework2 Task1
// Author: Ege Ottan
// ID: 10168090218
// Section: 02
// Assignment: 2
// Description: This program implements and demonstrates various sorting algorithms, including Insertion Sort, Merge Sort, and Quick Sort,
// and a Car class for sorting by model year in descending order.
*/
import java.io.*;
import java.util.Random;
/*
// Class: Car
// Description: Represents a car with brand, model name, and model year.
// Implements Comparable to allow sorting by model year in descending order.
*/
class Car implements Comparable<Car> {
    private final String brand;
    private final String modelName;
    private final long modelYear;

    // Constructor: Initializes a Car object with brand, modelName, and modelYear.
    public Car(String brand, String modelName, long modelYear) {
        this.brand = brand;
        this.modelName = modelName;
        this.modelYear = modelYear;
    }
/*
// Summary: Returns the brand of the car.
// Postcondition: The car's brand is returned.
 */
    public String getBrand() {
        return brand;
    }
/*
// Summary: Returns the model name of the car.
// Postcondition: The car's model name is returned.
 */
    public String getModelName() {
        return modelName;
    }
/*
 // Summary: Returns the model year of the car.
 //Postcondition: The car's model year is returned.
 */
    public long getModelYear() {
        return modelYear;
    }
/*
// Summary: Compares two Car objects by model year in descending order.
// Precondition: A valid Car object to compare with.
// Postcondition: Returns a negative integer if this car's model year is greater,
// a positive integer if less, and 0 if equal.
 */
    @Override
    public int compareTo(Car other) {
        return Long.compare(this.modelYear, other.modelYear);
    }
/*
// Summary: Returns a string representation of the car.
// Postcondition: A string in the format ModelYear is returned.
 */
    @Override
    public String toString() {
        return brand + " " + modelName + " (" + modelYear + ")";
    }
}
/*
// Class: InsertionSort
// Description: Provides methods for sorting integer arrays in descending order using Insertion Sort.
 */
class InsertionSort {
    /*
    // Summary: Sorts an integer array in descending order using modified Insertion Sort.
    // Precondition: array is not null.
    // Postcondition: The input array is sorted in descending order.
     */
    public static void sortDescending(int[] array) {
        int N = array.length;
        for (int i = N - 2; i >= 0; i--) {
            for (int j = i; j < N - 1 && greater(array[j + 1], array[j]); j++) {
                exch(array, j, j + 1);
            }
        }
    }
    // Helper method to compare two integers.
    private static boolean greater(int v, int w) {
        return v > w;
    }
    // Helper method to exchange two elements in the array.
    private static void exch(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
/*
// Class: FloatInsertionSort
// Description: Provides methods for sorting float arrays in descending order using Insertion Sort.
 */
class FloatInsertionSort {
    /*
     // Summary: Sorts a float array in descending order using modified Insertion Sort.
    // Precondition: array is not null.
    // Postcondition: The input array is sorted in descending order.
     */
    public static void sortDescending(Float[] array) {
        int N = array.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && greater(array[j], array[j - 1]); j--) {
                exch(array, j, j - 1);
            }
        }
    }
/*
// Summary: Compares two float values to determine which is larger.
// Precondition: v and w are valid Float objects.
// Postcondition: Returns true if v is greater than w, otherwise false.
 */
    private static boolean greater(Comparable<Float> v, Comparable<Float> w) {
        return v.compareTo((Float) w) > 0;
    }
/*
// Summary: Swaps two elements in the float array.
// Precondition: i and j are valid indices in the array.
// Postcondition: The elements at indices i and j are exchanged.
 */
    private static void exch(Float[] array, int i, int j) {
        Float temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
/*
// Summary: Displays the elements of the float array.
// Precondition: Array is not null.
// Postcondition: The elements of the array are printed to the console in their current order.
 */
    public static void show(Float[] array) {
        for (Float value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
/*
 // Summary: Checks if the float array is sorted in descending order.
 // Precondition: Array is not null.
 // Postcondition: Returns true if the array is sorted in descending order, otherwise false.
 */
    public static boolean isSorted(Float[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(array[i - 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
/*
// Class: MergeSort
// Description: Implements the Merge Sort algorithm to sort an array of integers in descending order using a top-down approach.
 */
class MergeSort {
    private static int[] aux;
/*
// Summary: Sorts an integer array in descending order using Merge Sort.
// Precondition: Array is not null.
// Postcondition: The input array is sorted in descending order.
 */
    public static void sortDescending(int[] array) {
        aux = new int[array.length];
        sort(array, 0, array.length - 1);
    }
/*
// Summary: Recursive method for sorting a subarray.
// Precondition: lo and hi are valid indices of the array.
// Postcondition: The subarray between lo and hi is sorted in descending order.
 */
    private static void sort(int[] array, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(array, lo, mid);
        sort(array, mid + 1, hi);
        merge(array, lo, mid, hi);
    }
/*
// Summary: Merges two sorted subarrays into a single sorted subarray.
// Precondition: Subarrays [lo, mid] and [mid+1, hi] are sorted in descending order.
// Postcondition: The entire subarray [lo, hi] is sorted in descending order.
 */
    private static void merge(int[] array, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > hi) {
                array[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }
    }
}
/*
// Class: QuickSort
// Description: Implements the Quick Sort algorithm for sorting Comparable objects
// in descending order. Includes a shuffle method for improved performance.
 */
class QuickSort {
    /*
    // Summary: Sorts an array of Comparable objects in descending order.
    // Precondition: The array is not null and elements implement Comparable.
    // Postcondition: The array is sorted in descending order.
     */
    public static void sort(Comparable[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }
/*
 // Summary: Recursive method for sorting a subarray.
 // Precondition: lo and hi are valid indices of the array.
 // Postcondition: The subarray between lo and hi is sorted in descending order.
 */
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
/*
// Summary: Partitions the array around a pivot for descending order.
// Precondition: lo and hi are valid indices of the array.
// Postcondition: Elements greater than the pivot are on the left, and elements less than the pivot are on the right.
 */
    private static int partition(Comparable[] a, int lo, int hi) {
        Comparable pivot = a[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (greater(a[j], pivot)) {
                i++;
                exch(a, i, j);
            }
        }
        exch(a, i + 1, hi);
        return i + 1;
    }
/*
// Summary: Compares two Comparable objects for descending order.
// Precondition: v and w are valid Comparable objects.
// Postcondition: Returns true if v > w, otherwise false.
 */
    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }
/*
// Summary: Swaps two elements in the array.
// Precondition: i and j are valid indices of the array.
// Postcondition: The elements at indices i and j are exchanged.
 */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
/*
// Summary: Shuffles the array to avoid worst-case performance.
// Precondition: The array is not null.
// Postcondition: The elements of the array are randomly reordered.
 */
    private static void shuffle(Comparable[] a) {
        Random random = new Random();
        for (int i = a.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            exch(a, i, index);
        }
    }
}
/*
// Class: main
// Description: Demonstrates the usage of sorting algorithms on various data types,
// including integers, floats, and custom Car objects.
 */
public class main {
    /*
    // Summary: Reads integers from a file and returns them as an array.
    // Precondition: The file exists and contains a valid first line specifying the number of integers,
    // followed by the integers themselves, one per line.
    // Postcondition: Returns an array of integers read from the file.
     */
    public static int[] readIntegersFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        int size = Integer.parseInt(reader.readLine().trim());
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(reader.readLine().trim());
        }
        reader.close();
        return array;
    }
/*
// Summary: Main method demonstrating sorting algorithms.
// Precondition: Required input files and data are present.
// Postcondition: Outputs sorted arrays to the console.
 */
    public static void main(String[] args) {
        String fileName = "integers.txt";

        try {
            // Load integers from the file.
            int[] integersFromFile = readIntegersFromFile(fileName);

            // Display the integers loaded from the file.
            System.out.println("Integers loaded from file:");
            for (int num : integersFromFile) {
                System.out.print(num + " ");
            }
            System.out.println();
            // Sort the integers using the modified Insertion Sort algorithm.
            System.out.println("Sorted integers using modified Insertion Sort:");
            InsertionSort.sortDescending(integersFromFile);
            for (int num : integersFromFile) {
                System.out.print(num + " ");
            }
            System.out.println();
            // Sort and display a float array using the FloatInsertionSort class.
            System.out.println("Sorting float values:");
            Float[] floatArray = {78.5f, 12.3f, 23.1f, 45.9f, 67.4f};
            FloatInsertionSort.sortDescending(floatArray);
            FloatInsertionSort.show(floatArray);
            assert FloatInsertionSort.isSorted(floatArray);
            // Sort the integers using the modified Merge Sort algorithm.
            System.out.println("Sorted integers using modified Merge Sort:");
            MergeSort.sortDescending(integersFromFile);
            for (int num : integersFromFile) {
                System.out.print(num + " ");
            }
            System.out.println();

        } catch (IOException e) {
            // Handle any exceptions that occur while reading the file.
            System.err.println("Error reading file: " + e.getMessage());
        }
        // Create an array of Car objects to demonstrate object-based sorting.
        Car[] cars = {
                new Car("Volvo", "S60", 2013),
                new Car("Volkswagen", "Passat", 2012),
                new Car("Ford", "Mustang", 2019),
                new Car("Tesla", "Model Y", 2023),
                new Car("BMW", "3.20I", 2016),
                new Car("Audi", "A8", 2022),
                new Car("Mercedes", "GLC", 2024),
                new Car("Hyundai", "Tucson", 2020),
                new Car("Kia", "Picanto", 2023),
                new Car("Chevrolet", "Lacetti", 2011)
        };
        // Display the array of cars before sorting.
        System.out.println("\nBefore sorting:");
        for (Car car : cars) {
            System.out.println(car);
        }
        // Sort the Car objects in descending order by model year using Quick Sort.
        QuickSort.sort(cars);
        // Display the array of cars after sorting.
        System.out.println("\nAfter sorting in descending order by model year:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
