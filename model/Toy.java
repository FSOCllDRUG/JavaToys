package model;

public class Toy {
    private String name;
    private int rate;
    private int id;
    private int count;


    public Toy(int id, String name, int rate) {
        this.name = name;
        this.rate = rate;
        this.id = id;
    }

    //Adding a specified amount to the count of the toy.

    public void add(int amount){
        this.count += amount;
    }


    //Calculates and returns the probability of the toy being chosen.
    public int getProbability(){
        return this.count * this.rate;
    }

    //Getter method for rate of toy.
    public int getRate() {
        return rate;
    }

    //Setter method for rate of toy.
    public void setRate(int rate) {
        this.rate = rate;
    }

    //Returns a string representation of the toy and rate.
    @Override
    public String toString() {
        return name + " (" + rate +")";
    }
}