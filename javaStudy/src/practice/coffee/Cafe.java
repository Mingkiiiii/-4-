package practice.coffee;
import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private String name;
    private List<Coffee> coffees;

    public Cafe(String name) {
        this.name = name;
        this.coffees = new ArrayList<>();
    }

    public void addCoffee(Coffee coffee) {
        coffees.add(coffee);
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }

    public String getName() {
        return name;
    }

    public void printMenu() {
        for (int i = 0; i < coffees.size(); i++) {
            System.out.println((i + 1) + ". " + coffees.get(i).toString());
        }
    }

    public Coffee getCoffee(int index) {
        return coffees.get(index);
    }
}