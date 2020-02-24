package ua.training;

public class TaskPart1 {

    /**
     * TASK1
     * RESULT: Exception in thread "main" java.lang.StackOverflowError at ua.training.TaskPart1.task1Func(TaskPart1.java:13)...
     */
    public void task1() {
        task1Func(null);

    }

    public void task1Func(NullPointerException e) {
        try {
            throw e;
        } catch (NullPointerException npe) {
            task1Func(npe);
        }

    }

    /**
     * TASK2
     * System.out - adds to buffer, System.err - prints instantly, so System.err can possibly outrun System.out
     * RESULT: err can outrun system.out or otherwise
     */
    public void task2() {
        System.out.println("out");
        throw new Error();
    }

    /**
     * TASK3
     * No return statement in no void
     * RESULT: infinite loop
     */
    public int task3() {
        while (true) ;
    }

    /**
     * TASK4
     * frame example
     * RESULT:
     * f1 in
     * f2 in
     * f3 in
     * Exception in thread "main" java.lang.Error
     */
    public void task4() {
        f41();
    }

    public void f41() {
        System.out.println("f1 in");
        f42();
        System.out.println("f1 out");
    }

    public void f42() {
        System.out.println("f2 in");
        f43();
        System.out.println("f2 out");
    }

    public void f43() {
        System.out.println("f3 in");
        if (true) {
            throw new Error();
        }
        System.out.println("f3 out");
    }

    /**
     * TASK5
     * Nonlocal control transfer
     * RESULT:
     * f1 in
     * f2 in
     * f3 in
     * f1 catch
     * f1 out
     */
    public void task5() {
        f51();
    }

    public void f51() {
        System.out.println("f1 in");
        try {
            f52();
        } catch (Error err) {
            System.out.println("f1 catch");
        }
        System.out.println("f1 out");
    }

    public void f52() {
        System.out.println("f2 in");
        f53();
        System.out.println("f2 out");
    }

    public void f53() {
        System.out.println("f3 in");
        if (true) {
            throw new Error();
        }
        System.out.println("f3 out");
    }


    /**
     * TASK6
     * Trow in catch
     * RESULT: Exception in thread "main" java.lang.Error
     */
    public void task6() {
        try {
            throw new RuntimeException();
        }
        catch (RuntimeException e){
            throw new Error();
        }
        catch(Error e){
            System.out.println("error caught");
        }
    }

    /**
     * TASK7
     * Finally #1
     * RESULT:
     * try
     * finally
     * Exception in thread "main" java.lang.RuntimeException
     */
    public void task7() {
        try {
            System.out.println("try");
            throw new RuntimeException();
        }
        finally {
            System.out.println("finally");
        }
    }

    /**
     * TASK8
     * Finally #2
     * RESULT:
     * try
     * finally
     */
    public void task8() {
        try {
            System.out.println("try");
            return;
        }
        finally {
            System.out.println("finally");
        }
    }

    /**
     * TASK9
     * Finally #3
     * RESULT: try
     */
    public void task9() {
        try {
            System.out.println("try");
            System.exit(42);
        }
        finally {
            System.out.println("finally");
        }
    }

    /**
     * TASK10
     * Finally #4: finally return overwrite try return
     * RESULT: 1
     */
    public void task10() {
        System.out.println(f10());
    }
    public int f10(){
        try{
            return 0;
        }
        finally{
            return 1;
        }
    }

    /**
     * TASK11
     * Finally #5: finally return can clean try errors and exceptions
     * RESULT: 1
     */
    public void task11() {
        System.out.println(f11());
    }
    public int f11(){
        try{
            throw new RuntimeException();
        }
        finally{
            return 1;
        }
    }

    /**
     * TASK12
     * Finally #6 finally errors overwrite try errors
     * RESULT: Exception in thread "main" java.lang.Error
     */
    public void task12() {
        System.out.println(f12());
    }
    public int f12(){
        try{
            throw new RuntimeException();
        }
        finally{
            throw new Error();
        }
    }

}
