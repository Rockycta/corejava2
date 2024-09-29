![alt text](https://github.com/Rockycta/corejava2/blob/d5d6ecadd5cdbc9dae1f8524f0a512c6c2670b2e/Errors_and_solutions/Screenshot%20(41).png)

![alt text](https://github.com/Rockycta/corejava2/blob/d5d6ecadd5cdbc9dae1f8524f0a512c6c2670b2e/Errors_and_solutions/Screenshot%20(43).png)

![alt text](https://github.com/Rockycta/corejava2/blob/d5d6ecadd5cdbc9dae1f8524f0a512c6c2670b2e/Errors_and_solutions/Screenshot%20(44).png)

![alt text](https://github.com/Rockycta/corejava2/blob/d5d6ecadd5cdbc9dae1f8524f0a512c6c2670b2e/Errors_and_solutions/Screenshot%20(45).png)

![alt text](https://github.com/Rockycta/corejava2/blob/4243352ebc275647798764d8dd339b0ac1c306c2/Errors_and_solutions/ProjectStructureAndItsNames.png)

What is the issue with following program

```java
package com.rocky.in;
import java.util.Scanner;
public class CountCharacter {
    public static void main(String[] str){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the strings where characters to be counted");
        String charCount = scanner.nextLine();
        void countChar(charCount);
    }
    public void countChar(String str){

    }

}

```
Line number 8, while calling a method, why you want to use "void", you were getting weired error for that.

![alt text](https://github.com/Rockycta/corejava2/blob/ae343776c051b2288554e5841335dfd3ffdb8027/Errors_and_solutions/Screenshot%20(47).png)

What is the issue with following program

```java
package com.rocky.in;
import java.util.Scanner;
public class CountCharacter {
    public static void main(String[] str){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the strings where characters to be counted");
        String charCount = scanner.nextLine();
        countChar(charCount);
    }
    public void countChar(String str){

    }

}
```
line number 8, non static method can't be reference from static context.

![alt-text](https://github.com/Rockycta/corejava2/blob/ae343776c051b2288554e5841335dfd3ffdb8027/Errors_and_solutions/Screenshot%20(48).png)


###########################################################################

```java
   char[] ch = str.toCharArray();
   for(int i=0;i<ch.length;i++){
       Map<Character,Integer> hm = new HashMap<>();
       if(hm.containsKey(ch[i])){
           
       }
   }
   
   
#  Replace above program with enchanced for loop
  
  
   
   char[] ch = str.toCharArray();
   for (char c : ch) {
     Map<Character, Integer> hm = new HashMap<>();
       if (hm.containsKey(c)) {

        }
    }
```	

# How to print Map contents in java

There are several ways to print the contents of a Map in Java:

1. Using a for-each loop:

Map<String, Integer> myMap = new HashMap<>();
// ... populate the map

for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}

Note that even though it is called for-each loop, only for is used  ie for(), it is just for saying.

2. Using the forEach method:

myMap.forEach((key, value) -> System.out.println(key + " = " + value));

3. Using the entrySet() method and an iterator:

Set<Map.Entry<String, Integer>> entries = myMap.entrySet();
Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
while (iterator.hasNext()) {
    Map.Entry<String, Integer> entry = iterator.next();
    System.out.println(entry.getKey() + " = " + entry.getValue());
}

4. Using the keySet() method and a for-each loop:
for (String key : myMap.keySet()) {
    System.out.println(key + " = " + myMap.get(key));
}


5. Using a stream and forEach:

myMap.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));



###########################################################################################

# What is the issue with this code

```java
 @Override
    public int categoryDiscounts(Order order) {

        if(order.getPrice()<10){
            return (order.getPrice()) * 10 / 100;
        } else if (order.getPrice()<20 && order.getPrice()<10) {
            return (order.getPrice())*20/100;
        } else if (order.getPrice()>20) {
            return (order.getPrice())*30/100;
        }
        
    }
```

![alt text](https://github.com/Rockycta/corejava2/blob/96b7a256c698d57b67bddc20add78eb442abf70b/Errors_and_solutions/Screenshot%20(49).png)

Solution

```java
   @Override
    public int categoryDiscounts(Order order) {

        if(order.getPrice()<10){
            return (order.getPrice()) * 10 / 100;
        } else if (order.getPrice()<20 && order.getPrice()<10) {
            return (order.getPrice())*20/100;
        } else  {
            return (order.getPrice())*30/100;
        }

    }
```
	
	