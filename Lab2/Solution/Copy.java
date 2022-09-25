import java.io.*;

public class Copy extends GenericCommand { 

    public void handleCommand(String [] args) { 

		if(!args[0].equals("copy")) someThingWrong(); //if arg[0]!="copy" execute someThingWrong method

		if(args.length != 3) { 				//error handling for the copy command
			System.out.println("Usage: copy <filename> <destination_path>");	//print error handling message to the terminal
			return;
		}

        try {
            BufferedReader buffread = new BufferedReader(new FileReader(args[1]));	//initialize a new bufferead object
            File file1 = new File(args[2], args[1]);		//create a new file object
            BufferedWriter buffwrite = new BufferedWriter(new FileWriter(file1.getAbsolutePath()));		//create bufferwriter by getting the absolute path
            String str;

            while ((str = buffread.readLine()) != null) {
                buffwrite.write(str+"\n");			//until the end of the file,write to current file
            }
            buffread.close();		//close reading file
            buffwrite.close();		//close writing file
            cmdCounter++;			//increment command counter by 1
        }

        catch (IOException IOExp) {
            IOExp.printStackTrace();		//if try fails print IOException
        }
    }
}
