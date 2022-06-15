package com.example.arithmetic.sort.ch8heap;

import lombok.SneakyThrows;
import org.springframework.cglib.core.internal.Function;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * MonitorVehicleTracker
 * <p/>
 * 基于监视器的机动车追踪器实现
 *
 * @author Brian Goetz and Tim Peierls
 */
public class MonitorVehicleTracker {
    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }

    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint loc = locations.get(id);
        if (loc == null)
            throw new IllegalArgumentException("No such ID: " + id);
        loc.x = x;
        loc.y = y;
    }

    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
        Map<String, MutablePoint> result = new HashMap<String, MutablePoint>();

        for (String id : m.keySet())
            result.put(id, new MutablePoint(m.get(id)));

        return Collections.unmodifiableMap(result);
    }
}

class BadListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !list.contains(x);
        if (absent)
            list.add(x);
        return absent;
    }
}

class FunctionInterface{
    private ArrayList<Integer> elementData;

    public FunctionInterface(ArrayList<Integer>  elementData) {
        this.elementData = elementData;
    }

    public void supplier(Integer n,Supplier<?> supplier){
        for (int i = 0; i < n; i++) {
            System.out.println(supplier.get());
        }
    }

    public void consumer(Consumer<?> consumer){

    }
    public void function(Function<?,?> function){

    }
    public void unaryOperator(UnaryOperator<?> unaryOperator){

    }

    public void predicate(Predicate<Integer> filter){
        for (Integer o : elementData) {
            if (filter.test(o)){
                System.out.println(o);
            }
        }

    }
}
class Test1 {
    public static void main(String[] args) {
        FunctionInterface functionInterface = new FunctionInterface(new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }});
        ArrayList<Integer> integers = new ArrayList<>() {{
            add(3);
            add(4);
            add(5);
        }};
        functionInterface.predicate(n->integers.contains(n));
        System.out.println("-------");
        String haha = new String("haha");
        functionInterface.supplier(10,() -> "haha");
    }
}
