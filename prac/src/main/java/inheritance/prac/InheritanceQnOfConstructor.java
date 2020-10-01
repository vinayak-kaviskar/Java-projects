package inheritance.prac;

public class InheritanceQnOfConstructor{

    /** CHANGES TO BE MADE ARE WRITTEN IN COMMENTS */
    
    class A{
       private String var1;

       A(String var1){
           this.var1 = var1;
       }
    }
           
    class B extends A{

        B(){                      
               //as A has only parameterized constructor we need to call super("dummystring") here because 
                // the default constructor which jvm calls inernally is not present in class A as we have added 
            // a new constructor manually in class A
        }
        
        public void doThis(){
            System.out.print(var1);  // the var1 should be protected not private in class A
        }

    }
    
    public static void main(String[] args) {       

        InheritanceQnOfConstructor ex = new InheritanceQnOfConstructor();
        
        ex.doIntialization();
    }

    private void doIntialization() {
        B b1 = new A();   // Because we cant hold object of parent in reference of child also typecasting  object of A into B will not work here because we cannot convert object of parent child into class child 
        A a1 = new A();   // this will not work as class A has no non-paramterized constructor now as we have added a paramterized constructor in class A  
        A a2 = new B();    // will work only if super("dummy") method is added in constructor of B at first line 
        B b2 = new B();    // will work only if super("dummy") method is added in constructor of B at first line
    }
    
}













            
            























