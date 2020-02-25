package ua.training;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TaskPart2 {
    /**
     * TASK1
     * RESULT: Compilation error
     * @throws IOException
     */
    /*public void task1() throws IOException {
        throw new Exception();
    }*/

    /**
     * TASK2
     * RESULT: Compiles
     */
    public void task2() throws Throwable {
        throw new Exception();
    }

    /**
     * TASK3
     * RESULT: Compilation error(Exception - CHECKED)
     */
    /*public void task3() {
        f3();
    }

    public void f3() throws Exception {
        throw new Exception();
    }*/

    /**
     * TASK4
     * RESULT: Compiles (RuntimeException - UNCHECKED)
     */
    public void task4() {
        f4();
    }

    public void f4() throws RuntimeException {
        throw new RuntimeException();
    }

    /**
     * TASK5
     * RESULT: Compilation error
     */
    /*public void task5() throws Exception{
        try{
            Throwable t = new Exception();
            throw t;
        }catch(Exception e){
             System.out.println("Caught");
        }
    }*/

    /**
     * TASK6
     * RESULT: Caught
     */
    public void task6() throws Throwable {
        try {
            Throwable t = new Exception();
            throw t;
        } catch (Exception e) {
            System.out.println("Caught");
        }
    }


    /**
     * TASK7
     * RESULT: Caught
     */
    public void task7(Object ref) throws Exception {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Caught");
        }
    }

    /**
     * TASK8
     * RESULT: Compiles (Throwable is stronger than IOException)
     */
    public class Parent8 {
        public void f() throws Throwable {}
    }

    class Child8 extends Parent8 {
        @Override
        public void f() throws IOException {}
    }

    /**
     * TASK9
     * RESULT: Compilation error (Throwable is stronger than IOException)
     */
    /*public class Parent9 {
        public void f() throws IOException {}
    }

    class Child9 extends Parent9 {
        @Override
        public void f() throws Throwable {}
    }*/


}
