#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>

using namespace std;

int main(){
	//guessing game
	//declaring needed variables
	int secretnum, guess, chance;
	srand((unsigned) time(0));
	
	secretnum = rand() % 100;
	chance = 1;
	//welcome message
	cout << "Hello and Welcome to My Guessing game.\n\n\n" << "You have only 5 chances to guess the number\n" << "GIVE IT A TRY!\n";
	//hinting the user on number range
	if(secretnum >= 0 and secretnum <= 10){
		cout << "HINT: The number is fall in 0 to 10";
	}else if(secretnum >= 11 and secretnum <= 20){
		cout << "HINT: The number is fall in 11 to 20";
	}else if(secretnum >= 21 and secretnum <= 30){
		cout << "HINT: The number is fall in 21 to 30";
	}else if(secretnum >= 31 and secretnum <= 40){
		cout << "HINT: The number is fall in 31 to 40";
	}else if(secretnum >= 41 and secretnum <= 50){
		cout << "HINT: The number is fall in 41 to 50";
	}else if(secretnum >= 51 and secretnum <= 60){
		cout << "HINT: The number is fall in 51 to 60";
	}else if(secretnum >= 61 and secretnum <= 70){
		cout << "HINT: The number is fall in 61 to 70";
	}else if(secretnum >= 71 and secretnum <= 80){
		cout << "HINT: The number is fall in 71 to 80";
	}else if(secretnum >= 81 and secretnum <= 90){
		cout << "HINT: The number is fall in 81 to 90";
	}else if(secretnum >= 91 and secretnum <= 100){
		cout << "HINT: The number is fall in 91 to 100";
	}
	//guess game
	while(chance <=5){
		if(chance > 1){
			cout << "\nSorry Wrong Guess\n" << "Try Again: ";
		}else{
			cout << "\nGuess the Number: ";
		}
		cout << "\n>> ";
		cin >> guess;
		if(guess == secretnum){
			cout << "Congrats You guess right!";
			break;
		}else if(guess != secretnum and chance == 5){
			cout << "Sorry you are out of chances. Try again next time";
		}
		chance++;
	}
}
