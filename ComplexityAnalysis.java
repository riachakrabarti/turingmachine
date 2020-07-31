import java.sql.Time;
import java.util.HashSet;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Object.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class ComplexityAnalysis{


	public static void main(String[] args){

		TuringMachine tm = new TuringMachine();
		//Scanner sc = new Scanner(System.in); //read for file name
		if(args.length >= 1){
			String filename = args[0];
			tm.buildTuringMachine(filename);
			if(args.length >= 2){
				runTM(tm, args[1]);
			}
			else{
				runTM(tm, "empty.tape");
			}
		}



	}

	public static void runTM(TuringMachine tm, String tapeFile){

		ArrayList<String> output = new ArrayList<String>(100000);
		int n = 0;

		State currentState = new State();
		Set<String> stateNames = tm.getStates().keySet();
		for(String name : stateNames){
			if(tm.getStates().get(name).getStartState() == 1){ //find start state
				currentState = tm.getStates().get(name); //set current state to the start state
			}
		}
		boolean allBlanks = true;
		int steps = 0; //initialize number of steps
		Instruction currentInstruction = new Instruction("no state1", "no input", "no state2", "no output", "L");

		//Scanner scanny = new Scanner(System.in);
		//String tapeFile = scanny.next();
		//StringBuilder toStr = new StringBuilder
		BufferedReader reader;
		try{
			reader = new BufferedReader(new FileReader(tapeFile));
			int read;
			while((read = reader.read()) != -1){
				/*for(int a = 0; a < read.length(); a++){
					String letter = read.charAt(a) + "";
					//letter = toStr.toString();
					if(!letter.contains(" ")){
						output.add(letter);
					}
				}*/
				StringBuilder toStr = new StringBuilder();
				toStr.append((char)read);
				String letter = toStr.toString();
				if((!letter.contains(" ")) && (!letter.contains("\n"))){ // weird logic here but more of a checker
					if(!letter.equals("_")){
						allBlanks = false;
					}
					output.add(letter);
					n++;
				}


			}
			//if tape is blank
			if(allBlanks == true){
				//System.out.println("gets here");
				//System.out.println("accepted");
				for(Instruction inst : tm.getInstructions()){
					if(inst.getstate1().equals(currentState.getName()) && (inst.getinput().equals("_"))){ //set the current instruction to the current state and input
						currentInstruction = inst;
					}

				}
				if(currentInstruction.getstate1().contains(" ")){
					//System.out.println("not accepted");
					//System.out.println(n);
					System.out.println(steps);
					//System.out.println("_");
					System.exit(1);
				}
				else if((tm.getStates().get(currentInstruction.getstate2()).getEndState() == 1) || !(tm.getInstructions().contains(currentInstruction))){
					//System.out.println("not accepted");
					//System.out.println(n);
					System.out.println(steps);
					//System.out.println("_");
					System.exit(1);
				}
				else if(tm.getStates().get(currentInstruction.getstate2()).getEndState() == 2){
					//System.out.println("accepted");
					//System.out.println(n);
					System.out.println(steps);
					//System.out.println("_");
					System.exit(0);
				}
				else{
					//System.out.println("gets here");
					System.out.println("input error");
					System.exit(2);
				}

			}
			//Check tape syntax
			for(int d = 0; d < output.size(); d++){
				//System.out.println("checking tape syntax");
				if(!(tm.getAlphabet().contains(output.get(d)))){
					if(!(output.get(d).equals("_"))){
						//System.out.println("gets here");

						System.out.println("input error");
						System.exit(2);
					}

				}
			}
			//System.out.println(output);

			//System.out.println(currentInstruction.getstate1());

			int ptr = 0; //pointer for the tape

			while((currentState.getEndState() != 1) || (currentState.getEndState() != 2)){
				//System.out.println(ptr);
				//System.out.println(output);
				for(Instruction i : tm.getInstructions()){
					if(i.getstate1().equals(currentState.getName()) && (i.getinput().equals(output.get(ptr)))){ //set the current instruction to the current state and input
						currentInstruction = i;
					}

				}
				/*System.out.println(currentState.getName());
				System.out.println(currentInstruction.getstate1());
				System.out.println(output.get(ptr));*/
				if(!tm.getInstructions().contains(currentInstruction)){
					//System.out.println("gets here");
					//System.out.println(currentInstruction.getstate1() + " " + output.get(ptr) + currentState.getName());
					//System.out.println("not accepted");
					System.out.println(n);
					System.out.println(steps);

					for(int x = 0; x < output.size(); x++){
					//	System.out.print(output.get(x));
					}
					System.exit(1);
				}
				output.set(ptr, currentInstruction.getoutput());	//set the current output in the array list to the output (instead of the input)
				if(currentInstruction.getdirection().equals("L")){ // if the instruction says move left
					if(ptr == 0){
						currentState = tm.getStates().get(currentInstruction.getstate2()); //dont move left if you're at the beginning, just change to next state
						if(currentState.getEndState() == 1){

							System.out.println("not accepted");
							System.out.println(n);

							System.out.println(steps);
							for(int x = 0; x < output.size(); x++){
							//	System.out.print(output.get(x));
							}
							System.exit(1);
						}
						else if(currentState.getEndState() == 2){
							System.out.println("accepted");
							System.out.println(n);
							System.out.println(steps);
							for(int x = 0; x < output.size(); x++){
							//	System.out.print(output.get(x));
							}
							System.exit(0);
						}
						//recently added
						else if(currentState.getEndState() == 0){
							for(Instruction i : tm.getInstructions()){
								if(i.getstate1().equals(currentState.getName()) && (i.getinput().equals(output.get(ptr)))){ //set the current instruction to the current state and input
								currentInstruction = i;
								}
							}
						}
						else{
							//System.out.println("gets here");
							System.out.println("input error");
							System.out.println(currentState.getName());
							//System.out.println(currentInstruction.getinput());
							for(int x = 0; x < output.size(); x++){
							//	System.out.print(output.get(x));
							}
							System.exit(2);
						}
					}
					else{
						ptr = ptr - 1;	//if not at first position change left
						currentState = tm.getStates().get(currentInstruction.getstate2()); //set to next state
					}
				}
				else if(currentInstruction.getdirection().equals("R")){ //change right
					if(ptr == (output.size()-1)){
						//output.add("_");
						for(Instruction inst : tm.getInstructions()){
							if(inst.getstate1().equals(currentState.getName()) && (inst.getinput().equals("_"))){ //set the current instruction to the current state and input
								currentInstruction = inst;
							}

						}
						if((tm.getStates().get(currentInstruction.getstate2()).getEndState() == 1) || !(tm.getInstructions().contains(currentInstruction))){
							steps++;

						//	System.out.println("not accepted");
							System.out.println(n);
							System.out.println(steps);
							for(int x = 0; x < output.size(); x++){
						//		System.out.print(output.get(x));
							}
							System.exit(1);
						}
						else if(tm.getStates().get(currentInstruction.getstate2()).getEndState() == 2){
							steps++;
						//	System.out.println("accepted");
							System.out.println(n);
							System.out.println(steps);
							for(int x = 0; x < output.size(); x++){
						//		System.out.print(output.get(x));
							}
							System.exit(0);
						}
						else if((tm.getStates().get(currentInstruction.getstate2()).getEndState() == 0) ){
							output.add("_");
						}
						else{
							//System.out.println("gets here");
							System.out.println("input error");
							for(int x = 0; x < output.size(); x++){
								System.out.print(output.get(x));
							}
							System.out.println(currentState.getName());
							System.exit(2);
						}
					}
					ptr = ptr +1;	//set the pointer right
					currentState = tm.getStates().get(currentInstruction.getstate2()); //change to next state
				}
				else{
					System.out.println("No valid direction"); //just a checker
				}
				steps++; //increment steps
				currentInstruction = new Instruction("no state1", "no input", "no state2", "no output", "L");
			}
			if(currentState.getEndState() == 1){

				System.out.println("not accepted");
				System.out.println(n);
				System.out.println(steps);
				for(int x = 0; x < output.size(); x++){
			//		System.out.print(output.get(x));
				}
				System.exit(1);
			}
			else if(currentState.getEndState() == 2){
				System.out.println("accepted");
				System.out.println(n);
				System.out.println(steps);
				for(int x = 0; x < output.size(); x++){
			//		System.out.print(output.get(x));
				}
				System.exit(1);
			}
			else{

				System.out.println("input error");
				//System.out.println(currentState.getName());
				System.out.println(currentInstruction.getinput());
				for(int x = 0; x < output.size(); x++){
					System.out.print(output.get(x));
				}
				System.exit(2);
			}

		}
		catch(IOException e){

			System.out.println("input error");
			System.exit(3);

		}




	}
}
