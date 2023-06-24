package model;

import java.util.HashMap;
import java.util.Random;

public class ToyMachine {
    private HashMap<Toy, Integer> toys;

    /**
     * Constructor for ToyMachine class.
     * Initializes toys HashMap.
     */
    public ToyMachine() {
        this.toys = new HashMap<>();
    }

    // Adds a toy to the toy machine. If the toy already exists in the machine, its count is incremented.
    public void add(Toy toy) {
        Integer count = 0;
        if (toys.containsKey(toy)) {
            count = toys.get(toy);
        }
        toys.put(toy, ++count);
    }

    /**
     * Prints the list of toys in the machine and their counts.
     */
    public void printToys(){
        for (Toy toy : toys.keySet()) {
            System.out.println("In machine: " + toy + ": " + toys.get(toy));
        }
    }

    //Returns a string containing the list of toys in the machine and their counts.
    public String getToysList(){
        StringBuilder result = new StringBuilder();
        for (Toy toy : toys.keySet()) {
            result.append("In machine: ").append(toy).append(": ").append(toys.get(toy)).append("\n");
        }
        return result.toString();
    }

    /**
     * Removes a toy from the machine. If the toy count is 1, the toy is removed from the HashMap.
     * If the toy count is greater than 1, the toy count is decremented.
     */
    private void remove(Toy toy) {
        Integer count = toys.get(toy);
        if (count == 1) {
            toys.remove(toy);
        } else {
            toys.put(toy, --count);
        }
        
    }

    /**
     * Returns the total count of toys in the machine.
     */
    public int getToysCount() {
        int count = 0;
        for (Toy toy : toys.keySet()) {
            count += toys.get(toy);
        }
        return count;
    }

    /**
     * Returns the next toy to be dispensed from the machine.
     * The probability of each toy being dispensed is proportional to its absolute weight.
     *
     * @return Next toy to be dispensed 
     */
    public Toy getNext() {
        HashMap<Toy, Integer> rates = new HashMap<>();
        int fullRate = 0;
        for (Toy toy : toys.keySet()) {
            int toyRate = toy.getRate();
            int toyCount = toys.get(toy);
            int rate = toyRate * toyCount;
            rates.put(toy, fullRate + rate);
            fullRate += rate;
        }
        int test = 0;
        if (fullRate > 0 ){
            test = 1 + new Random().nextInt(fullRate);
        }

        for (Toy toy : rates.keySet()) {
            int rate = rates.get(toy);
            if (test <= rate) {
                remove(toy);
                return toy;
            }
        }

        return null;

    }

}