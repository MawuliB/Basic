//two number calculator
#include <iostream>
#include <string>
#include <cmath>

using namespace std;

//function to get maximum number
double getmax(double num1, double num2) {
	double result;
	if(num1 >= num2){
		result = num1;
	}else{
		result = num2;
}
return result;
}
//functio to get minimum number
double getmin(double num1, double num2) {
	double result;
	if(num1 <= num2){
		result = num1;
	}else{
		result = num2;
	}
	return result;
}
//function to get result for basic operation 
double opt(int opt, double num1, double num2) {
	double result;
	if(opt == 1){
		result = num1 + num2;
	}else if(opt == 2){
		result = num1 - num2;
	}else if(opt == 3){
		result = num1 * num2;
	}else if(opt == 4){
		result = num1 / num2;
	}else{
		cout << "wrong input";
	}
	return result;
}
//main function
int main() {
	// declaring needed variables
	double number1, number2;
	int choice = 0;
	double out = 0;
	//message to welcome user
	cout << "Hello and welcome to my Two Number Calculator\n\n";
	//getting the two numbers from the user 
	cout << "Enter first number: ";
	cin >> number1;
	cout << "Enter second number: ";
	cin >> number2;
	//getting the type of calculation the user want
	cout << "/n Do you want to: \n" << "Add -> 1     Subtract -> 2     Multiply -> 3\n" << "Divide -> 4     Get Maximum -> 5     Get Minimum -> 6\n" << "\n\n>> ";
	cin >> choice;
	//calling the rigth function based on the choice of user, to solve the question
	/*if(choice == 1){
		out = opt(1, number1, number2);
	} else if(choice == 2){
		out = opt(2, number1, number2);
	} else if(choice == 3){
		out = opt(3, number1, number2);
	} else if(choice == 4){
		out = opt(4, number1, number2);
	} else if(choice == 5){
		out = getmax(number1, number2);
	} else if(choice == 6){
		out = getmin(number1, number2);
	} else{
		cout << "Wrong Input";
	}*/
	//alternative for calling the right function
	switch(choice){
		case 1:
			out = opt(1, number1, number2);
			break;
		case 2:
			out = opt(2, number1, number2);
			break;
		case 3:
			out = opt(3, number1, number2);
			break;
		case 4:
			out = opt(4, number1, number2);
			break;
		case 5:
			out = getmax(number1, number2);
			break;
		case 6:
			out = getmin(number1, number2);
			break;
		default:
			cout << "Invalid";
			break;
			
	}
	//print the final result
	cout << "\n\nThe Answer is " << out;
	return 0;
}
