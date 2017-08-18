import java.util.*;
import java.io.*;
import java.lang.*;

class DeckOfCards
{

	public static void main(String[] args)
	{
	
		// make the cards
		String[] deck = new String[52]; // how many total
		String[] suits = {"Heart", "Diamond", "Spade", "Club"};
		String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		String[][]arr=new String[10][10];
		int l=0;
		
	
		for(int i=0;i<deck.length;i++)
		{
			deck[i]=suits[i/13] + " "+ ranks[i%13];
			//System.out.println(deck[i]);
		}

		for(int k=0;k<deck.length;k++)
		{
			int random=(int)(Math.random()*deck.length);
			String temp=deck[k];
			deck[k]=deck[random];
			deck[random]=temp;
			//System.out.println(deck[k]);
		}

		int i=0;
		for(i=0;i<4;i++)	
		{

			System.out.println("\nPlayer " + (i+1)+ " has \n");
			for(int j=0;j<9;j++)
			{
				arr[i][j]=deck[l];
				l++;
				System.out.println(arr[i][j]);
			}
			System.out.println();
		}

		// for(int i=0;i<4;i++)
		// {
		// 	System.out.println("Player" +i + "has \n");
		// 	for(int j=0;j<9;j++)
		// 	{
		// 		System.out.pr
		// 	}
		// }
	
	}


}

