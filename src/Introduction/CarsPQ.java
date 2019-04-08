package src.Introduction;

// Find n cars which are nearest to me, if I am at origin.

import java.util.Comparator;
import java.util.PriorityQueue;

public class CarsPQ implements Comparator<Car> {
    public static void main(String[] args) {
        int a[] = {2, 6, -5, 9, -3, 89};
        int b[] = {81, 56, -65, 78, 1, 7};
        PriorityQueue<Car> pq = new PriorityQueue<>(new CarsPQ());
        for (int i = 0; i < 6; i++) {
            pq.add(new Car(a[i], b[i], i));
        }
        while (!pq.isEmpty()) {
            System.out.println("Car ID is " + pq.peek().id + " x cord is " + pq.peek().x + " y cord is " + pq.peek().y + " with distance " + pq.peek().distance());
            pq.remove();
        }
    }

    public int compare(Car a, Car b) {
        return a.distance() - b.distance();
    }
}

class Car {
    int x;
    int y;
    int id;

    Car(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    int distance() {
        return x * x + y * y;
    }
}
