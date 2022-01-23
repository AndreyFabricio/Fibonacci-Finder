# Fibonacci-Finder

This program accepts a value from the user, says whether or not the value is in the Fibonacci sequence and prints the sequence up to that value or to the value closest to it in the sequence

## Requirements

- To run the program you need java jre version 1.8.0 or higher that can be found [here](https://java.com/en/download/manual.jsp)

## Installing

- The program does not need to be installed, just download the Jar file and run it
- The Jar file can be downloaded by clicking [here](https://github.com/AndreyFabricio/Fibonacci-Finder/releases/download/1.0.2/FibonacciFinder.jar)

## Common problems

**The program does not open on my machine**

If you didn't, try download the java jre version 1.8.0 or higher that can be found [here](https://java.com/en/download/manual.jsp)

**The program is asking to select a default program to run**

Right click on the Jar file, then go to "Open With..." and then click "More Applications". In the list that opened you must choose the option "Java(TM) Platform SE Binary" and then click ok

![Jar](https://github.com/AndreyFabricio/Fibonacci-Finder/blob/main/FibonacciFinder%20images/default-java-open.png)

## Limitations

- The maximum value that the program can accept is 7540113804746346429
- The value 7540113804746346429 is a limitation caused by the type of number (Long) handled by the program
- Longs can only store numbers from -9223372036854775808 to 9223372036854775808. *See more:* [Long](https://docs.oracle.com/javase/7/docs/api/java/lang/Long.html)
- Because of the maximum value the program can only generate up to 93 positions of the Fibonacci sequence

## The program Running

The program home screen

![1](https://github.com/AndreyFabricio/Fibonacci-Finder/blob/main/FibonacciFinder%20images/1.PNG)

Example of error (invalid value)

![2](https://github.com/AndreyFabricio/Fibonacci-Finder/blob/main/FibonacciFinder%20images/2.PNG)

Another example of error (negative number)

![3](https://github.com/AndreyFabricio/Fibonacci-Finder/blob/main/FibonacciFinder%20images/3.PNG)

Another example of error (not a [Long](https://docs.oracle.com/javase/7/docs/api/java/lang/Long.html))

![4](https://github.com/AndreyFabricio/Fibonacci-Finder/blob/main/FibonacciFinder%20images/4.PNG)

Example of the program running with a number that is not in the Fibonacci sequence

![5](https://github.com/AndreyFabricio/Fibonacci-Finder/blob/main/FibonacciFinder%20images/5.PNG)

Example of the program running with a number that is in the Fibonacci sequence

![6](https://github.com/AndreyFabricio/Fibonacci-Finder/blob/main/FibonacciFinder%20images/6.PNG)

Another example of the program running with a number that is in the Fibonacci sequence

![7](https://github.com/AndreyFabricio/Fibonacci-Finder/blob/main/FibonacciFinder%20images/7.PNG)

Example of a big number that is a [Long](https://docs.oracle.com/javase/7/docs/api/java/lang/Long.html) and is not in the Fibonacci sequence

![8](https://github.com/AndreyFabricio/Fibonacci-Finder/blob/main/FibonacciFinder%20images/8.PNG)
