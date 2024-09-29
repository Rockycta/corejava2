![alt text](https://github.com/Rockycta/corejava2/blob/d5d6ecadd5cdbc9dae1f8524f0a512c6c2670b2e/Errors_and_solutions/Screenshot%20(41).png)

![alt text](https://github.com/Rockycta/corejava2/blob/d5d6ecadd5cdbc9dae1f8524f0a512c6c2670b2e/Errors_and_solutions/Screenshot%20(43).png)

![alt text](https://github.com/Rockycta/corejava2/blob/d5d6ecadd5cdbc9dae1f8524f0a512c6c2670b2e/Errors_and_solutions/Screenshot%20(44).png)

![alt text](https://github.com/Rockycta/corejava2/blob/d5d6ecadd5cdbc9dae1f8524f0a512c6c2670b2e/Errors_and_solutions/Screenshot%20(45).png)

![alt text](https://github.com/Rockycta/corejava2/blob/4243352ebc275647798764d8dd339b0ac1c306c2/Errors_and_solutions/ProjectStructureAndItsNames.png)

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
![alt-text](https://github.com/Rockycta/corejava2/blob/ae343776c051b2288554e5841335dfd3ffdb8027/Errors_and_solutions/Screenshot%20(48).png)