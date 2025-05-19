import java.io.FileInputStream;

public class ExceptionHandling {

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Divisor should not be zero");
        }

//        for (int i = 1; i <= 10000; i++) {
//            System.out.println(i);
//        }

        // process file

        System.out.println("Finally done with loop");
        System.out.println("Now divide");
        try {
            int result = dividend / divisor;
            return result;

//            return dividend / divisor;
        }
        catch (ArithmeticException e) {
//            System.out.println("An error occurred while trying to divide " + dividend + "/" + divisor);

            // log the exception
            System.out.println("error message is: "+e.getMessage());

            // throw the exception
//            throw new ArithmeticException();
        }
        finally {
            System.out.println("Finally block");
        }
        return 4323;
    }

    public void justThrowChecked() throws Exception {
        throw new Exception("Just felt like it");
    }

    public void justThrowUnchecked()  {
        throw new ArithmeticException("Just felt like it");
    }

}
