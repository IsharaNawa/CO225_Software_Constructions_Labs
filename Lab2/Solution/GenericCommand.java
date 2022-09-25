/*******************************************************************
                 Skeleton code 
********************************************************************/

public class GenericCommand { 
    /* this is the generic command 
     * your commands should reimplement this
     */

    public void handleCommand(String [] args) { 
	    System.out.println("Command not implemented!");
    }

    public void someThingWrong() { 
        System.out.println("Something Wrong in code!!!");
        System.exit(-1);
    }

    public static int cmdCounter = 0;	//declaring this static variable to count number of commands
}

