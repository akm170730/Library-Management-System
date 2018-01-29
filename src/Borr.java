import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class Borr {
 public static void main(String[] args) {
        BufferedReader br;
        File borrower=new File("D:\\Course\\Database Design\\Assignments\\1\\1\\Borrower.csv");
        try
        {
            FileWriter writer = new FileWriter(borrower); 
            br = new BufferedReader(new FileReader("D:\\Course\\Database Design\\Assignments\\1\\1\\borrowers.csv"));
            String line=null;
            line=br.readLine();
            int count = 0;
            while ((line=br.readLine())!=null)
            {
                String [] borr = line.split(",");
                String cardid = borr[0];
                String ssn = borr [1];
                String fname = borr[2]; 
                String lname = borr[3];
                String email = borr[4];
                String address = borr[5];
                String city = borr[6];
                String state = borr[7];
                String phone = borr[8];
                writer.append(cardid+"\t"+ssn+"\t"+fname+"\t"+lname+"\t"+email+"\t"+address+","+city+","+state+"\t"+phone+"\n");
                writer.flush();
                count++;
            }
            System.out.println(count);
            writer.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }   
}