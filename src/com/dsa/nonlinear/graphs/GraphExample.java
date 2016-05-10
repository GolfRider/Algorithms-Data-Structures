package com.dsa.nonlinear.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


//Node
class Nodee {
	String data;
	
	public Nodee(String data){
		this.data=data;
	}
}

//Graph : Holds the Nodes
class Graph {

	private Map<Nodee,List<Nodee>> edges=new HashMap<>();
  
	//1. Add edge
	public void addEdge(Nodee src,Nodee dest){
		List<Nodee> neighbors=edges.get(src);
		if(neighbors==null){
          neighbors=new ArrayList<>();
          edges.put(src, neighbors);
		}
		neighbors.add(dest);
	}
	
	//print Node
	private void printNode(Nodee node){
		System.out.println("Node:"+node.data);
	}
	
	//2. Get Neighbors
	private List<Nodee> getNeighbors(Nodee node){
		if(edges.get(node)==null){
			return Collections.emptyList();
		}else{
			return Collections.unmodifiableList(edges.get(node));
		}
	}
	
	private List<Nodee> getNeighborsReverse(Nodee node){
		if(edges.get(node)==null){
			return Collections.emptyList();
		}else{
			List<Nodee> list=new ArrayList<Nodee>(Collections.unmodifiableList(edges.get(node)));
			Collections.reverse(list);
			return list;			
		}
	}
	
	//3. Breadth First Search [BFS]
	public void searchBFS(Graph graph,Nodee source){
		//Empty Graph
		if(graph==null){  return; }
		
		Queue<Nodee> queue= new LinkedList<>();
		Set<Nodee> visitedNodes=new HashSet<>();
		queue.add(source);  //visitedNodes.add(current); ?
		
		while(!queue.isEmpty()){
			
			Nodee current=queue.remove();
			visitedNodes.add(current);
			//Visit neighbors ?
			for(Nodee neighbor:graph.getNeighbors(current)){
				if(!visitedNodes.contains(neighbor)){    //Traverse Unvisited Neighbors
					visitedNodes.add(neighbor);
					queue.add(neighbor);					
				}
			}
			printNode(current);			
		}
    }
	
	//4. Depth First Search [DFS]
	public void searchDFS(Graph graph,Nodee source){
		//Empty Graph
		if(graph==null){  return; }
				
		Stack<Nodee> stack = new Stack<>();
		Set<Nodee> visitedNodes=new HashSet<>();
		stack.push(source);
		
		while(!stack.isEmpty()){
		  Nodee current=stack.pop();
		  visitedNodes.add(current);  //Visit only after pop
		  printNode(current);  
		  
		  //Add unvisited nodes to stack
		  //for(Nodee node:graph.getNeighbors(current)){         // RIGHT-TO-LEFT Traversal
		    for(Nodee node:graph.getNeighborsReverse(current)){	 //LEFT-TO-RIGHT Traversal
		    	if(!visitedNodes.contains(node)){
				  stack.push(node);   
			  }
		  }
		}
	}
	
	
	public boolean checkPathDFS(Graph graph,Nodee source,Nodee dest){
		//Empty Graph
		if(graph==null){  return false; }
		if(source==dest){
			return true;
		}
        				
		Stack<Nodee> stack = new Stack<>();
		Set<Nodee> visitedNodes=new HashSet<>();
		stack.push(source);
		
		while(!stack.isEmpty()){
		  Nodee current=stack.pop();
		  visitedNodes.add(current);  //Visit only after pop
		  printNode(current);  
		  
		  if(current==dest){
			  return true;
		  }
		  
		  //Add unvisited nodes to stack
		  //for(Nodee node:graph.getNeighbors(current)){         // RIGHT-TO-LEFT Traversal
		    for(Nodee node:graph.getNeighborsReverse(current)){	 //LEFT-TO-RIGHT Traversal
		    	if(!visitedNodes.contains(node)){
				  stack.push(node);   
			  }
		  }
		}
		return false;
	}
	
	//5. DFS Recursive
	public void dfsRecursive(Graph graph,Nodee source){
		/*source.visted=true;
		 * printNode(source);
		 * for(Nodee node:source.getNeighbors()){
		 *    if(!node.visisted){
		 *       dfsRecursive(node);
		 *     }
		 *  }   
		 * 
		 */
	}
}


public class GraphExample{
  
	public static void main(String args[]){
		
		//Prepare the Nodes
		Nodee A=new Nodee("A");
		Nodee B=new Nodee("B");
		Nodee C=new Nodee("C");
		Nodee D=new Nodee("D");
		Nodee E=new Nodee("E");
		Nodee F= new Nodee("F");
		
		//Add the edges
		Graph graph = new Graph();
		graph.addEdge(A, B);
		graph.addEdge(A, C);
		graph.addEdge(A, D);
		graph.addEdge(B, E);
		graph.addEdge(B, F);
		graph.addEdge(C, F);
		
		graph.searchBFS(graph, A);
		System.out.println("----------------");
		graph.searchDFS(graph, A);
		
		stateMachine();
	}
	
	public static void stateMachine(){
		Graph graph=new Graph();
		Nodee new_=new Nodee("New");
		Nodee running=new Nodee("Running");
		Nodee suspend= new Nodee("Suspended");
		Nodee terminated=new Nodee("Terminated");
		
		graph.addEdge(new_, running);
		graph.addEdge(running, suspend);
		graph.addEdge(suspend,running);
		graph.addEdge(suspend,terminated);
		graph.addEdge(running,terminated);
		
		boolean pathExists=graph.checkPathDFS(graph, running, new_);
		System.out.println("PATH_EXISTS:"+pathExists);
	}
	 
}


