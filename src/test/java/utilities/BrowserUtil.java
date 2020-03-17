package utilities;

public class BrowserUtil {

    public static void wait(int seconds){

        try {
            Thread.sleep(1000 * seconds);
        }catch(InterruptedException e){
            e.printStackTrace();
            //it shows on the console which kind of exception,
            // reason of exception
            //throws postpone the solution to someone else
            //try-catch you solve problem , handle it directly


        }
    }
}
