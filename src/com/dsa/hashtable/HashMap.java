package com.dsa.hashtable;

import java.util.LinkedList;

public class HashMap<K,V> {
 private final int SIZE=10;
 private LinkedList<Cell<K,V>> [] items;
 
 public HashMap(){
	 items=(LinkedList<Cell<K,V>>[]) new LinkedList[SIZE];
 }
 
 
 public static void main(String args[]){
	 HashMap<String, String> map= new HashMap();
	 map.put("1", "nfx");
	 map.put("2", "google");
	 map.put("3", "abc1");
	 
	 assert("google".equals(map.get("1")));
	 System.out.println("CHK_2:"+map.get("4"));
	 
 }
 
 
 //HashCode
 private int getHashIndex(K key){
	 return key.toString().length() % items.length;
 }
 
 //put
 public void put(K key,V value){
	 int hashIndex=getHashIndex(key);
	 if(items[hashIndex]==null){
		 items[hashIndex]= new LinkedList<Cell<K,V>>();
	 }
	 //Check for collision
	 LinkedList<Cell<K,V>> startNode=items[hashIndex];
	 for(Cell<K,V> cell:startNode){
		 if(cell.equivalent(key)){
			 startNode.remove(cell);
		 }
	 }
	 //Add the node
	 Cell<K,V> cell = new Cell<K,V>(key,value);
	 startNode.add(cell);
 }
 //get
 
 public V get(K key){
	 int hashIndex=getHashIndex(key);
	 if(items[hashIndex]==null){
		 return null;
	 }else{
		 LinkedList<Cell<K,V>> startNode=items[hashIndex];
		 for(Cell<K,V> cell:startNode){
			 if(cell.equivalent(key)){
				 return cell.getValue();
			 }
		 }
	 }
	 return null;
 }
	
 class Cell<K,V>{
    private K key;
    private V value;
    
    public Cell(K key,V value){
    	this.key=key;
    	this.value=value;
    }
    
    public V getValue(){
    	return value;
    }
    
    public boolean equivalent(K k){
    	return k.equals(key);
    }
 }
}
