package com.vinayakaz.prac;

//@FunctionalInterface
public interface MyInteface2 extends MyInterface1{

    String name = "Helllo MOTO";
    
   
    
    default String getName2() {
        return "hgvb";
    }
    
}

