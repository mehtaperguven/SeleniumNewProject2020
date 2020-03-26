package ExtraPracticesJavaSelenium;

import java.util.*;

public class FindPriceFromWebsite {
    public static void main(String[] args) {
        List<String >priceLstStr= new ArrayList<>(Arrays.asList("99.99","149.99","79.99","149.99","299.99","599.99"));
        priceLstStr.add("999.99");
        System.out.println("priceLstStr = " + priceLstStr);

    String price="100.99";
    double priceNum=Double.parseDouble(price);
        System.out.println("priceNum = " + priceNum);
//but we want to get List<Double>
        List<Double> prices=new ArrayList<>();
        for (String each:priceLstStr){
            prices.add(Double.parseDouble(each));
        }
        System.out.println("prices "+prices);
        // how do I get max price , min , average
        //  remove items above average
        //  get the unique prices


     //   System.out.println(max);
        double max=prices.get(0);
        for (int i=0;i<prices.size();i++){

            if (prices.get(i)>max){

                max=prices.get(i);
            }

        }
        System.out.println("for loop max is "+max);
        double maxx=prices.get(0);
        for (Double each:prices){
            if (maxx<each){
                maxx=each;
            }
        }
        System.out.println("for each max  is  "+maxx);


        //finding average
        double sum=0.0;
        for (Double each: prices) {
            sum+=each;
        }

        double avrg=sum/prices.size();
        System.out.println("Average is "+ avrg);

        //Listing elements over the average

        List<Double>overAverage=new LinkedList<>();
        for (Double each:prices){
            if (each>avrg){
                overAverage.add(each);
            }
        }
        System.out.println("overAverage  ==="+overAverage);

        //  get the unique prices
        // each and every collection implementation classes has constructor to accept another Collection object
        // to copy whatever is inside
        Set<Double> uniquePrices = new HashSet<>( prices );
        System.out.println("uniquePrices = " + uniquePrices);
        // what if we want to have a list that contains Product name , price
        // List<Product>  :
        // Try to do this task at home :  Create a product classes , 2 encapsulated fields name , price
        // toString , Constructor
        // Create List of Product , fill up this list , using actual search result you got from amazon



    }




}
