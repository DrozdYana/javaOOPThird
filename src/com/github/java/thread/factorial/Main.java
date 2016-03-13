package com.github.java.thread.factorial;

public class Main {
public static void main(String[] args){
	FactorialCalculation calc=new FactorialCalculation();
	calc.factorialByThread(0, 100);
}
}
