import java.sql.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.*;
import java.util.HashMap;

public class Library {
    public static void main(String[] args) {
        BufferedReader br;
        File book = new File("D:\\Course\\Database Design\\Assignments\\1\\1\\Book.csv");
        File Authors = new File("D:\\Course\\Database Design\\Assignments\\1\\1\\Authors.csv");
        File Book_Auth = new File("D:\\Course\\Database Design\\Assignments\\1\\1\\Book_Auth.csv");
        try
        {
            FileWriter writer = new FileWriter(book); 
            FileWriter writer1 = new FileWriter(Authors);
            FileWriter writer2 = new FileWriter(Book_Auth);
            String line;
            HashMap<String,Integer> hmap = new HashMap<String,Integer>();
            br = new BufferedReader(new FileReader("D:\\Course\\Database Design\\Assignments\\1\\1\\books.csv"));
            line=br.readLine();
            int count = 0;
            
            int cx=0;
            while ((line=br.readLine())!=null)
            {
                String [] books = line.split("\t");
                String isbn = books[1];
                String title = books[2];
                String author = books[3];
                String cover = books[4];
                String publisher = books[5];
                String pages = books[6];
                
                title=title.replaceAll("&amp;","");
                author=author.replaceAll("&amp;","");
                publisher=publisher.replaceAll("&amp;","");
                author=author.replaceAll(";","");
                
                String [] authors= author.split(",");
                for(int i=0;i<authors.length;i++)
                {
                    if(hmap.containsKey(authors[i]))
                    {
                        writer2.append(hmap.get(authors[i])+"\t"+isbn+"\n");
                        writer2.flush();
                    }
                    else 
                    {
                        cx=cx+1;
                        hmap.put(authors[i],cx);
                        writer1.append(cx+"\t"+authors[i]+"\n");
                        writer1.flush();
                        writer2.append(cx+"\t"+isbn+"\n");
                        writer2.flush();
                    }
                }
                writer.append(isbn+"\t"+title+"\t"+cover+"\t"+publisher+"\t"+pages+"\n");
                writer.flush();
                count++;
            }  
            writer.close();
            System.out.println(count);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       
    }
}
