package ua.training;

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




}
