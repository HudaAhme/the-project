import java.beans.Statement;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by DELL on 26/10/2022.
 */
public class Option implements Floavr {

    private double price;
    private String flavor;
    private int choice;
    static Controll o;

    static {
        try {
            o = new Controll();
        } catch (FileNotFoundException e) {
            throw  new RuntimeException(e);
        }
    }

    Scanner input = new Scanner(System.in);

    public Option() throws FileNotFoundException {} ;

  //private ArrayList<Floavr>all;
   private ArrayList<Option>all;



   public boolean all()
    {

        try{
            Option o=new Option();
            for (int i = 0; i < all.size(); i++) {
               all.get(i).toString();
                o.all.toArray();

                   all.toArray();
               System.out.println(all.toString());


            }
            all.add(o);
            return true;


        } catch (Exception e) {
            return false;
        }
    }


    public Option(String flavors, double price) throws FileNotFoundException {
        o = new Controll();
        o.readlavorrsAndPrice();

    }

    public void DisplaylavorrsAndPrice() throws FileNotFoundException{

        while (true) {
            System.out.println("choose number 0___3");
            System.out.println("1:Add flavor and  price       2:delete flavor and price       ");
            System.out.println("3:Display menu                0:Exit     ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    Add();
                    break;
                case 2:
                    Delete();
                    break;
                case 3:
                    menu();
                    break;


                case 0:
                    o.writelavorssAndprice();
                    System.out.println("Exit");
                    System.exit(0);

                default:
                    System.out.println("NO THING ");

            }

        }
    }

    public void Add() {
        double price;
        String flavor;
        System.out.println("enter the flavors and price ");
        flavor = input.next();
        price = input.nextDouble();

        boolean Repetion = o.check(new FlavorAndPrice(flavor, price));

        if (Repetion) {
            System.out.println("this is found ");
        } else {
            boolean Add = o.AddloverrrsAndPrice(flavor, price);

            if (Add) {


                System.out.println("Done Add");






            } else
                System.out.println("Can not Add");
        }

    }

    public void menu() {
        FlavorAndPrice[] all = o.Display();
        for (int i = 0; i < all.length; i++) {
            if (all[i] != null)

                System.out.println(all[i].toString());

        }



    }

    public void Delete() {
        System.out.println("Enter your want delete price");
        double price = input.nextDouble();
        boolean delete = o.DeletelavorrsAndprice(price);
        if (delete) {
            System.out.println("Done delete"+price);
        } else

            System.out.println("The price not found");

    }


    @Override
    public String toString() {
        return "Option{" +
                "all=" + all +
                '}';
    }






  }


