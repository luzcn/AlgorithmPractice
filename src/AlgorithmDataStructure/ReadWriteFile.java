package AlgorithmDataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The example to show how to use BufferedReader and BufferedWrite to read and
 * write a file
 * 
 * @author annie
 * 
 * @date Dec 22, 2012
 */
public class ReadWriteFile
{
	public void readwrite(File f)
	{
		BufferedReader br = null;
		BufferedWriter bw = null;

		try
		{
			br = new BufferedReader(new FileReader(f));
			String currentLine;
			while ((currentLine = br.readLine()) != null)
				System.out.println(currentLine);
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				if (br != null)
					br.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
