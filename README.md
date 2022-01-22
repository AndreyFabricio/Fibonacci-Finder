# Fibonacci-Finder
This project generates the Fibonacci sequence to a number or to the closest Nth number in the sequence

## Requirements
- To run the program you need java jre version 1.8.0 or higher that can be found [here](https://java.com/en/download/manual.jsp)

## What does this program do?
- The program accepts a value from the user, says whether or not the value is in the Fibonacci sequence and prints the sequence up to that value or to the value closest to it

## Limitations

- The maximum value that the program can accept is 7540113804746346429
- The value 7540113804746346429 is a limitation caused by the type of number (Long) handled by the program
- Longs can only store numbers from -9223372036854775808 to 9223372036854775808. See more: [Long](https://docs.oracle.com/javase/7/docs/api/java/lang/Long.html)
- Because of the maximum value the program can only generate up to 93 positions of the Fibonacci sequence
