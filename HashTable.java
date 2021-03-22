package csi;
import java.util.Random;
import java.util.Arrays;
/*
 * Creates a hash table of 199 items and does the average of 10 trials to get average number of collisions 
 * @author Vyanna Hill
 * @version 1.0
 */

public class Hashtables {
	static int collisions;
	static int Hashavg;
	static int [] hash= new int [199];
	// static variables can be used in any method, not fixed to main method
	// the hash table now has is 199 slots than 128
	
	public static void main(String[] args) {
		int s=0;
		do {
			Random generator= new Random();
			int [] value= new int [1000];
			//creates an array of a 1000 objects
			
			for(int i =0;i < value.length; i++) {
				value[i]= generator.nextInt(999)+1;
			}
			// fills the array with 1000 random numbers
			
			hashfunc(value);
			System.out.println("the hastable created by k mod 199: "+Arrays.toString(hash)+"\nThe number of collisions this hash was:"+collisions);
			System.out.println("----------------------------");
			//prints out the hash table with the values of the random array in their correct positions plus the number of collision produced 
			
			Hashavg=Hashavg+collisions;
			// adds collision count to the collision average
			Arrays.fill(hash,0);
			collisions=0;
			// resets counter and hash table to zero, so it doesn’t over count
			s++;
			
		}while(s<10);
		System.out.println("-------------------------------");
		System.out.println("The average amount of collision: "+ Hashavg/10);
	}
	//while loop will do the hash table 10 times and print the average amount of collisions
	
	public static void hashfunc(int [] value) {
		int index;
		int [] count= new int [199];
		// acts as dupe hash table, keeps track of the collision at each position 
		
		for(int a=0;a<value.length;a++) {
			int i=1;
			int b= value[a];
			index= b % 199;
			// does the hash function of k mod 199
			
			if((hash[index])==0) {
				hash[index]=b;
			}else{
				index= (index + i*i)% 199;
				i++;
				if((hash[index])==0) {
					hash[index]=b;
				}else {
				count[index]++;
				collisions++;
				}
			}	
		}
		// For the length of value,it will hash each item in the array and placed the value as the index
		// If the position in the hash table is empty, it will fill the random value into hash array in the index position
		// If it's not empty, it will quadratic probe to find the next  empty slot. If found it will insert into that slot and not count
		// i will increment thr each iteration. If the next spot is full, then it will count as a collision
		
		for(int c=0;c<count.length;c++) {
			System.out.println("At index:"+c+"\tcollisions:"+count[c]);
		}
		//To see at what position in the Hash table has the most collisions,For loops prints index in the hash and the max collisions
		// This for loop is unnecessary, I just wanted to see what positions usually had the max collisions
		
	}
	

}
