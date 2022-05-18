package com.prashant.java8features.interfaces;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface // it checks at the compile time if only one abstract method is present or not.
public interface FunctionalInterfaceDemo {
	public void getData(); // only one abstract method allowed
	default void printMessage() {
		getAge();
	}
	static void printMessages() { // directly can be called directly by the name of the interface
	}
	
	private int getAge() { // when a method is to be used inside the interface only and not outside of the method.
		return 34;
	}
}

/* why we use functional interface ?
 * 
 * 
 * we can use lambda expressions to instantiate 
 * them and avoid using bulky anonymous class implementation*/



class functionalInterfaceImplementation{
	//different functional interfaces
	//consumer functional interface

	/*it has four method in it apart from apply() rest of the methods are default methods
	 *apply()
	andThen()
	compose()
	identity() // static method*/
	//function functional interface
	Function<Integer, Integer> f = (val)-> {val = val*val;
	return val;};
	public int getVal() {
		return this.f.apply(45);
	}
	//predicate functional interface
	//return type is boolean , one input is required
	//methods:
	/*boolean test(),rest of the methods are default methods.*/
	Predicate<Integer> p = (val)-> val > 0;
	public boolean isValGreaterThanZero() {
		return this.p.test(45);
	}
	
	//Supplier functional interface
	//does not require any input , gives output
	Supplier<Integer> s = ()->45;
	public int getDefaultValueOfSupplierInterface() {
		return this.s.get();
	}
	
	//Consumer functional interface 
	//does  require an input and does not give any output
	// it is useful if you want to have some sysout you can put it in the consumer interface
	Consumer<Integer> c = (val)-> System.out.println(val);
	public void printValValue() {
		c.accept(45);
	}
	
	
	// anonymous implementation of the interface
	
	interface Dummy{
		public void printMyName();
	}
	
//	class Abc implements Dummy{
//
//		@Override
//		public void printMyName() {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	}
	class MainTemp{
		
		public void main(String a[]) {
			Dummy d  = new Dummy() {
				@Override
				public void printMyName() {
					System.out.println("some message");
				}
			};
			Dummy d2 = ()->{
				System.out.println();
			};
			d2.printMyName();
			d.printMyName();
		
			
			
		}
	}
	
	
	
	////////////////////////////////////////Base64//////////////////////
	String str = Base64.getEncoder().encodeToString("this is my confidential password".getBytes());
	String strDecoded = new String( Base64.getDecoder().decode(str));
	
}

