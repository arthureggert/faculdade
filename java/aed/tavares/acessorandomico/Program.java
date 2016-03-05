package br.com.ahe.aed.tavares.acessorandomico;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Program
{
    public static void main(String[] args)
    {
        try
        {
            // Create a new random access file.
            RandomAccessFile raf = new RandomAccessFile(
                "C:\\RandomFile.txt", "rw");

            // Write some data to the file.
            raf.writeBoolean(true);     
            raf.writeBoolean(true);
            raf.writeBoolean(false);     
            raf.writeBoolean(false);
            raf.writeInt(2147483647);     
       
        
            raf.writeDouble(3.14);
           

            // Reposition the file pointer to position 4.
            raf.seek(4);

            // Read in the next char from the file.
            int i = raf.readInt();
            
        //    char c = raf.readChar();
            System.out.println("The char at position 4 is " + i);

            // Close the file.
            raf.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex.toString());
        }
    }
}


