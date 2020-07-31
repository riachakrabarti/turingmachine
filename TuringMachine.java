import java.util.HashSet;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Object.*;


public class TuringMachine{

	public HashSet<Instruction> instructions;
	public HashSet<String> alphabet;
	public HashMap<String, State> states;
	//public State currentState;

	public TuringMachine(){
		this.instructions =  new HashSet<Instruction>();
		this.alphabet = new HashSet<String>();
		this.states = new HashMap<String, State>();
	}

	public void buildTuringMachine(String filename){

		BufferedReader reader;
		try{
			reader = new BufferedReader(new FileReader(filename));// take in string and read file from there
			String line = reader.readLine();
			if(line == null){
				System.out.println("input error");
				System.exit(2);
			}
			if(!line.startsWith("states")){
				System.out.println("input error");
				System.exit(2);
			}
			String[] firstLine = line.split("\\s+");
			if(firstLine.length < 2){
				System.out.println("input error");
				System.exit(2);
			}
			int numStates = 0;
			try{
				numStates = Integer.parseInt(firstLine[1]); //find out number of states
			}
			catch(NumberFormatException e){
				System.out.println("input error");
				System.exit(2);
			}
			if(numStates <= 0){
				System.out.println("input error");
				System.exit(2);
			}
			for(int i = 0; i < numStates; i++){ //for the number of states, go
				line = reader.readLine();
				if(line == null){
					System.out.println("input error");
					System.exit(2);
				}
				if(line.startsWith("alphabet")){
					System.out.println("input error");
					System.exit(2);
				}
				int startState = 0;
				int endState = 0;
				String name;
				if(i == 0){
					startState = 1;	//almost like a boolean, start state value is 1 when it is the first line
				}
				String[] currentLine = line.split("\\s+"); //split by blank space
				if(currentLine.length == 1){	// if there is only one item on that space
					endState = 0;	//it is not an end state
				}
				else{
					if(currentLine[1].equals("-")){ //if it is a reject state
						endState = 1;	//end state value is 1
					}
					else if(currentLine[1].equals("+")){ //if it is an accept state
						endState = 2;		//end state value is 2
					}
					else{
						endState = 0; //failsafe
					}
				}
				name = currentLine[0];
				State newState = new State(endState, startState, name);
				states.put(name, newState); //add new state to the map of states
			}

			line = reader.readLine();
			String[] alphabetLine = null;
			if(line != null){
				alphabetLine = line.split("\\s+");
			}
			else{
				System.out.println("input error");
				System.exit(2);
			}
			if(!alphabetLine[0].equals("alphabet")){
				System.out.println("input error");
				System.exit(2);
			}
			int alphabetSize = 0;
			try{
				alphabetSize = Integer.parseInt(alphabetLine[1]);
			}
			catch(NumberFormatException e){
				System.out.println("input error");
				System.exit(2);
			}

			if(alphabetSize <= 0){
				System.out.println("input error");
				System.exit(2);
			}

			if(alphabetLine.length < (alphabetSize + 2)){
				System.out.println("input error");
				System.exit(2);
			}
			for(int a = 0; a < alphabetSize; a++){
				alphabet.add(alphabetLine[a+2]);
			}
			alphabet.add("_");


			while((line = reader.readLine()) != null){

				String[] instructionParts = line.split("\\s+");
			//	System.out.println(line);
				if(instructionParts.length == 5){
					if((!states.keySet().contains(instructionParts[0])) || (!(states.keySet().contains(instructionParts[2])))){
						System.out.println("input error");
						System.exit(2);
					}
					if((!alphabet.contains(instructionParts[1])) || (!alphabet.contains(instructionParts[3]))){
						System.out.println("input error");
						System.exit(2);
					}
					if((!instructionParts[4].equals("L")) && (!instructionParts[4].equals("R"))){
						System.out.println("input error");
						System.exit(2);
					}
					Instruction instruct = new Instruction(instructionParts[0], instructionParts[1], instructionParts[2], instructionParts[3], instructionParts[4]);
					for(Instruction inst : instructions){
						if(inst.getstate1().equals(instructionParts[0])){
							if(inst.getinput().equals(instructionParts[1])){
								System.out.println("input error");
								System.exit(2);
							}
						}
					}
					instructions.add(instruct);
				}


			}

		}
		catch(IOException e){
			System.out.println("input error");
			System.exit(3);
		}

	}

	public HashMap<String, State> getStates(){
		return this.states;
	}
	public HashSet<String> getAlphabet(){
		return this.alphabet;
	}
	public HashSet<Instruction> getInstructions(){
		return this.instructions;
	}

}
