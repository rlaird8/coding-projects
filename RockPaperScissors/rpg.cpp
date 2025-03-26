#include <iostream>
#include <cmath>
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <cstdlib>
#include <string>
#include <cstring>
#include <fstream>
using namespace std;


 
class Player{
public:
	int choice;
    string name;
	Player(string newName){
		name = newName;
	}
	void randomChoice(){
		choice = (rand()%3);
	}
};

Player playGame(Player a, Player b);


fstream outputFile("project3RyanLaird.txt", ios::app);

int main(){
	//ofstream outputFile;
	
			srand(time(0));
	
	cout << "---Rock, Paper, Scissors---" << endl << endl << endl;
	outputFile << "---Rock, Paper, Scissors---" << endl << endl << endl;
    cout << "In these games, Rock = 0, Paper = 1, Scissors = 2" << endl << endl;
	outputFile << "In these games, Rock = 0, Paper = 1, Scissors = 2" << endl << endl;
	
					Player p1 ("Player 1");
					Player p2 ("Player 2");
					Player p3 ("Player 3");
					Player p4 ("Player 4");
					Player p5 ("Player 5");
					Player p6 ("Player 6");
					Player p7 ("Player 7");
					Player p8 ("Player 8");
				    string result = playGame(playGame(playGame(p1, p2), playGame(p3,p4)), playGame(playGame(p5, p6), playGame(p7,p8))).name;

cout << "\nThe winner of the tournament is: " << result << endl;
outputFile << "\nThe winner of the tournament is: " << result << endl;


	return 0;
outputFile.close();
}





// ofstream&
Player playGame(Player a, Player b){
	//ofstream outputFile;
    int heads = 0;
	int tails = 1;
	
    // keeps track of scores
    int win = 0;
    int tie = 0;
    int lose = 0;
    int p1win = 0;
	int p2win = 0;
	
	
	for(int x = 1; x<4; x++)
	{

	a.randomChoice();
	b.randomChoice();
	

	cout << a.name << " chose: " << a.choice << endl;
	outputFile << a.name << " chose: " << a.choice << endl;
    cout << b.name << " chose: " << b.choice << endl;
	outputFile << b.name << " chose: " << b.choice << endl;

		if(a.choice ==0 && b.choice== 1){
			 cout << b.name << " wins. Paper beats rock." << endl;
			 outputFile << b.name << " wins. Paper beats rock." << endl;
			 p2win++;
			 }
		else if(a.choice == 1 && b.choice == 2){
			 cout << b.name << " wins. Scissors beats paper." << endl;
			 outputFile << b.name << " wins. Scissors beats paper." << endl;
			 p2win++;
			 }
		else if( a.choice == 2 && b.choice == 0){
			 cout << b.name << " wins. Rock beats scissors." << endl;
			 outputFile << b.name << " wins. Rock beats scissors." << endl;
			 p2win++;
			 }
		else if(a.choice ==1 && b.choice== 0){
			 cout << a.name << " wins. Paper beats rock." << endl;
			 outputFile << a.name << " wins. Paper beats rock." << endl;
			 p1win++;
			 }
		else if(a.choice == 2 && b.choice == 1){
			 cout << a.name << " wins. Scissors beats paper." << endl;
			 outputFile << a.name << " wins. Scissors beats paper." << endl;
			 p1win++;
			 }
		else if( a.choice == 0 && b.choice == 2){
			 cout << a.name << " wins. Rock beats scissors." << endl;
			 outputFile << a.name << " wins. Rock beats scissors." << endl;
			 p1win++;
			 }
			 
			 
			 
		else if( a.choice == b.choice)
		{
			int flip = (rand()%2);
			cout << "Both players chose the same outcome so they tied, I am going to flip a coin to decide who wins. 0 equals heads, 1 equals tails." << endl;
			outputFile << "Both players chose the same outcome so they tied, I am going to flip a coin to decide who wins. 0 equals heads, 1 equals tails." << endl;
			cout << a.name << " chooses heads, the toss is: " << flip << endl;
			outputFile  << a.name << " chooses heads, the toss is: " << flip << endl;
			if(flip == 0)
			{
				cout << a.name << " won the toss. The coin landed on heads." << endl;
				outputFile << a.name << " won the toss. The coin landed on heads." << endl;
				p1win++;
			}
			else
			{
				cout << b.name << " won the toss. The coin landed on tails." << endl; 
				outputFile << b.name << " won the toss. The coin landed on tails." << endl; 
				p2win++;
			}

		}

         cout << a.name << " total wins: " << p1win << endl;
		 outputFile << a.name << " total wins: " << p1win << endl;
		 cout << b.name << " total wins: " << p2win << endl;
		 outputFile << b.name << " total wins: " << p2win << endl;

		if(p1win == 2){
	cout << a.name << " won the series.\n" << endl << endl;
	outputFile << a.name << " won the series.\n" << endl << endl;
			return a;
		}
		else if (p2win == 2){
	cout << b.name << " won the series.\n" << endl << endl;
	outputFile << b.name << " won the series.\n" << endl << endl;
			return b;
		}

	}
	
}









