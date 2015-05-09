package logicTesting;

import java.util.ArrayList;

public class Node {
	public ArrayList<Synapse> outputSynapses;
	public int currentState;
	public int nextStateBuffer;
	public int x;
	public int y;
	
	public Node(int x, int y){
		this.x = x;
		this.y = y;
		currentState = 0;
		nextStateBuffer = 0;
		outputSynapses = new ArrayList<Synapse>();
	}
	public void addSynapse(int recipientNodeX, int recipientNodeY){
		outputSynapses.add(new Synapse(x, y, recipientNodeX, recipientNodeY));
	}
	public void output(){
		for(int i = 0; i < outputSynapses.size(); i++){
			if(outputSynapses.get(i).usageWeight >= currentState && currentState != 0){
				outputSynapses.get(i).sendSignal(); //add usageweight stuff here
			}
		}
	}
	public void acceptInput(){
		currentState = nextStateBuffer;
		nextStateBuffer = 0;
	}
	
}