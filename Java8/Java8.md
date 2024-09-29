java8.md


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

Order object is as above so we have to write below code to print contents of Orders LIST
orders.forEach(a->System.out.println(a.getName()+" "+a.getPrice()));

