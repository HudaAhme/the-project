import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by DELL on 26/10/2022.
 */
public class Controll {

   private FlavorAndPrice[]alllavorss;
    private double price;

    public Controll() throws FileNotFoundException
    {
       alllavorss=new FlavorAndPrice[10000];
        price=0;
        new ArrayList<>();
        readlavorrsAndPrice();
    }



    public boolean AddloverrrsAndPrice(String favorss,double price)
    {
        int conter=0;
        if (price < alllavorss.length)
        {
            FlavorAndPrice L=new FlavorAndPrice(favorss,price);

          alllavorss[ conter]=L;
            conter++;
            return  true;

        }
        else
            return  false;
    }

    public double searchforprice(double price)
    {
        boolean found=false;
        int p=0;
        while (!found&&p<alllavorss.length)
        {
            if(alllavorss[p]!=null) {
                if (alllavorss[p].getPrice() == price) {
                    found = true;
                }else p++;
            }else
                p++;
        }
        if (p>alllavorss.length)
        {
            return -1;
        }
        else
            return p;
    }

    public  boolean DeletelavorrsAndprice(double price){
       Scanner input=new Scanner(System.in);
       double index=searchforprice(price);

       // index=input.nextDouble();

        if (index !=-1){
            int i= (int) index;
            while (i<price)
            {
                alllavorss[i]=alllavorss[i+1];
                i++;
            }
            alllavorss[i]=null;
            price--;
            return true;}
        else return false;

        }



    public void readlavorrsAndPrice( ) throws FileNotFoundException

    {
        Scanner in = new Scanner(new File("D:\\EmployeesFile.txt"));
        in.useLocale(Locale.US);
        while (in.hasNext()) {
            double price = in.nextDouble();
            String lavor = in.next();

           alllavorss(price,lavor);
        }
        in.close();
    }

    private void alllavorss(double price, String lavorss) {
    }


    public void writelavorssAndprice() throws FileNotFoundException
    {
        PrintWriter write=new PrintWriter((new File("D:\\EmployeesFile.txt")));
        for (int i = 0; i <alllavorss.length ; i++) {
            write.write(alllavorss[i].getPrice()+"    "+alllavorss[i].getLavorss());

        }
        write.close();
    }

    public boolean check(FlavorAndPrice k) {
        for (int i = 0; i < price; i++) {
            if (alllavorss[i].equals(k))
                return true;


        }
        return false;

    }

    public FlavorAndPrice[] Display()
    {
        return alllavorss;
    }


   /* public boolean addNewEmployee(String flavors, double price) {
        flavors="f";
        price=0;

        return false;
    }

    public boolean DeletelavorrsAndpricee() {

        return DeletelavorrsAndprice(price);
    }*/
}
