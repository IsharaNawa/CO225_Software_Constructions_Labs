public class Quit extends GenericCommand { 

    /* Quit command 
     * Only quit should be there. 
     * no arguments, 
     */ 
    public void handleCommand(String [] args) { 

		if(!args[0].equals("quit")) someThingWrong(); 

		if(args.length != 1) { 
			System.out.println("Usage: quit");
			return;
		}

		/***
		* ###### You need to print the number of commands 
		* that was executed before exiting
		*/

		System.out.println("Executed "+cmdCounter+" commands since starting");//printing the corrsponding message

		/* OK, so just die */ 
		System.exit(0); 
    }

}