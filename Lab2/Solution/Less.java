import java.io.*;

public class Less extends GenericCommand { 

    public void handleCommand(String [] args) { 

		if(!args[0].equals("less")) someThingWrong(); //if arg[0]!="less" execute someThingWrong method

		if(args.length != 2) { 		//error handling for the less cmd
			System.out.println("Usage: less <filename>");
			return;
		}

        try (BufferedReader buffread = new BufferedReader(new FileReader(args[1]))) {		//trying out exceptions
            String str;						//declaring a string
            while ((str = buffread.readLine()) != null) {	//reading the file until the end of the file
                System.out.println(str);					//printing each line to the terminal
            }
            buffread.close();				//closing the file
            cmdCounter++;					//incrementing the command counter by 1
        }
        
        catch (IOException IOExp) {			//if try fails the control flow to here
            IOExp.printStackTrace();		//print IEO exception
        }
    }
}