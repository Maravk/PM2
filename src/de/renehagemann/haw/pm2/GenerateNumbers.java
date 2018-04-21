package de.renehagemann.haw.pm2;

import java.io.*;
import java.util.*;

/**
 * @author René Hagemann
 */

public class GenerateNumbers {
    private complexMutable[] numbers = new complexMutable[1000];
    private A_complex c = new complexImmutable(-0.7, 0.2);

    /**
     * Creates a number of complex numbers based on the rule z(n+1) = z(n)*z(n)+c with z(0) = 0
     */
    public GenerateNumbers(){
        numbers[0] = new complexMutable(0, 0);
        for(int i = 1; i < numbers.length; i++){
            numbers[i] = MathUtils.exp(numbers[i - 1]);
            numbers[i].add(c);
        }
    }

    /**
     * Gives back the generated number array
     * @return complexMutable[]
     */
    public complexMutable[] getNumbers(){
        return numbers;
    }

    /**
     * Writes the given complex number array in the given file
     * @param filename  To write the information in
     * @param input     Complex numbers to write into the file
     */
    public static void writeNumbers(String filename, A_complex[] input){
        try (PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(filename)))){
            for(int i = 0; i < input.length; i++){
                fileWriter.println(input[i].toString());
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    /**
     * Reads complex numbers from the given file and returns them as a list
     * @param filename  The file to read from
     * @return          The complex numbers as a list
     */
    public static ArrayList<complexImmutable> readList(String filename){
        ArrayList<complexImmutable> numbers = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(new File(filename)))){
            String line;
            while((line = in.readLine()) != null){
                int index = line.indexOf(" i");
                String a = line.substring(0, index);
                String b = line.substring(index + 1, line.length());
                numbers.add(new complexImmutable(Double.parseDouble(a), Double.parseDouble(b)));
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return numbers;
    }

    /**
     * Reads complex numbers from the given file and returns them as an array
     * @param filename  The file to read from
     * @return          The complex numbers as an array
     */
    public static complexImmutable[] readArray(String filename){
        ArrayList<complexImmutable> list = GenerateNumbers.readList(filename);
        complexImmutable[] array = new complexImmutable[list.size()];
        for(int i = 0; i < array.length; i++){
            array[i] = list.get(i);
        }
        return array;
    }

    /**
     * Creates a number of complex numbers, writes them to a file, reads them in a list and an array, sorts them and finally writes them back into separate files
     */
    public static void main(){
        GenerateNumbers create = new GenerateNumbers();

        GenerateNumbers.writeNumbers("generate.txt", create.getNumbers());

        ArrayList<complexImmutable> numberList = GenerateNumbers.readList("generate.txt");
        complexImmutable[] numberArray = GenerateNumbers.readArray("generate.txt");

        numberList.sort(Comparator.comparingDouble(A_complex::getValue));
        Arrays.sort(numberArray, Comparator.comparingDouble(A_complex::getValue));

        complexImmutable[] temp = new complexImmutable[numberList.size()];
        temp = (complexImmutable[]) numberList.toArray();

        GenerateNumbers.writeNumbers("list.txt", temp);
        GenerateNumbers.writeNumbers("array.txt", numberArray);
    }
}
