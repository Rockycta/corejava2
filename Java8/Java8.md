java8.md

#Functional inteface

Predicate

```java
@FunctionalInterface
public interface Predicate<T>{
	boolean test(T t)
}
```

For more interface use following 
https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html


Consumer
```java
@FunctionalInterface
public interface Consumer<T>{
	void accept(T t)
}
```

For more information, use the following.
https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html


Supplier
```java
@FunctionalInterface
public interface Supplier<T>{
	T get()
}
```

For more information, use the following.
https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html


Function
```java
@FunctionalInterface
public interface Function<T,R>{
	R apply(T t)
}

Parameters:
t - the function argument
R - Returns the function result
```

For more information, use the following
https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html

Filter
```java
Stream<T> filter(Predicate<? super T> predicate)
Returns a stream consisting of the elements of this stream that match the given predicate.
```

Map

```java
<R> Stream<R>	map(Function<? super T,? extends R> mapper)
Returns a stream consisting of the results of applying the given function to the elements of this stream.
```

```java
Comparator

@FunctionalInterface
public interface Comparator<T> {
	int compare(T o1, T o2);
}



@FunctionalInterface
public interface Callable<V> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    V call() throws Exception;
}


@FunctionalInterface
public interface Runnable {
    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see     java.lang.Thread#run()
     */
    public abstract void run();
}

```

# How to print the contents of MAP or LIST using java8?
First Well verse with forEach method present in the LIST interface and MAP interface, it is as follows.

```java
List:
default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }

Map:
default void forEach(BiConsumer<? super K, ? super V> action) {
        Objects.requireNonNull(action);
        for (Map.Entry<K, V> entry : entrySet()) {
            K k;
            V v;
            try {
                k = entry.getKey();
                v = entry.getValue();
            } catch (IllegalStateException ise) {
                // this usually means the entry is no longer in the map.
                throw new ConcurrentModificationException(ise);
            }
            action.accept(k, v);
        }
    }

```

You want to print the contents of Orders using java8, so how to print it?
first understand what are the contents of List type Orders.
so Orders list contain Order object.
forEach already contain logic of iterating over the objects so we just have to provide implementation for consumer.


list.forEach(System.out::println)

If we write above statement for printing the contents of Orders then output will be like 

com.rocky.in.Order@4783da3f
com.rocky.in.Order@378fd1ac

it is because Orders list object contains Order object, you are printing objects hence the issue.

understand what Order contains 

```java
public class Order {

    String name;
    int price;
}
```

Order object is as above so we have to write below code to print contents of Orders LIST <br>
orders.forEach(a->System.out.println(a.getName()+" "+a.getPrice()));


# Comparator functional interface and it's examples

```java
public class SortingDemo {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);
        al.add(21);
        al.add(32);
        al.add(5);
        al.add(8);
		
	    System.out.println("Elements Before Sorting ::" + al);
		
		Collections.sort(al, new ElementsSortingComparator());
		
		Collections.sort(al, (o1, o2) -> {
            return (o1 > o2) ? 1 : (o1 < o2) ? -1 : 0;
        });
		
        System.out.println("Elements After Sorting :: " + al);
		
}

Internal implementation of Sort method
======================================

Collections.java:
 public static <T> void sort(List<T> list, Comparator<? super T> c) {
        list.sort(c);
    }
	
Whatever we have given comparator, it is passed as argument and sort method is called on List we passed.


List:
default void sort(Comparator<? super E> c) {
        Object[] a = this.toArray();            // this means List here because sort method is called on list. List is converted to Array here.
        Arrays.sort(a, (Comparator) c);
        ListIterator<E> i = this.listIterator();
        for (Object e : a) {
            i.next();
            i.set((E) e);
        }
    }
	
Arrays:
public static <T> void sort(T[] a, Comparator<? super T> c) {
        if (c == null) {    // if no comparator is passed then it goes to sort(a) it is meant for natural sorting order.
            sort(a);
        } else {
            if (LegacyMergeSort.userRequested)
                legacyMergeSort(a, c);
            else
                TimSort.sort(a, 0, a.length, c, null, 0, 0);
        }
    }
	
Arrays:	
	public static void sort(Object[] a) {
        if (LegacyMergeSort.userRequested)
            legacyMergeSort(a);
        else
            ComparableTimSort.sort(a, 0, a.length, null, 0, 0);
    }
	
see this comprableTimeSort.sort method.



if the comparator is given then, it uses following logic

 public static <T> void sort(T[] a, Comparator<? super T> c) {
        if (c == null) {
            sort(a);
        } else {
            if (LegacyMergeSort.userRequested)
                legacyMergeSort(a, c);
            else
                TimSort.sort(a, 0, a.length, c, null, 0, 0);
        }
    }

It uses TimeSort.sort if comparator given

static <T> void sort(T[] a, int lo, int hi, Comparator<? super T> c,
                         T[] work, int workBase, int workLen) {
        assert c != null && a != null && lo >= 0 && lo <= hi && hi <= a.length;

        int nRemaining  = hi - lo;
        if (nRemaining < 2)
            return;  // Arrays of size 0 and 1 are always sorted

        // If array is small, do a "mini-TimSort" with no merges
        if (nRemaining < MIN_MERGE) {
            int initRunLen = countRunAndMakeAscending(a, lo, hi, c);
            binarySort(a, lo, hi, lo + initRunLen, c);
            return;
        }

........



 private static <T> int countRunAndMakeAscending(T[] a, int lo, int hi,
                                                    Comparator<? super T> c) {
        assert lo < hi;
        int runHi = lo + 1;
        if (runHi == hi)
            return 1;

        // Find end of run, and reverse range if descending
        if (c.compare(a[runHi++], a[lo]) < 0) { // Descending
            while (runHi < hi && c.compare(a[runHi], a[runHi - 1]) < 0)
                runHi++;
            reverseRange(a, lo, runHi);

See above it is calling compare method.
```