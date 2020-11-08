//David Alvarez
//COP2535.001
//uses a single stack to read postfix expressions and print their values

#include<iostream>
#include<fstream>
#include<string>
using std::ifstream;
using std::string;
using std::cout;
using std::endl;

class pfMath
{
private:
	struct StackNode
	{
		int number;
		StackNode* next;

		StackNode(int num, StackNode* nextP)
		{
			number = num;
			next = nextP;
		}
	};

	ifstream inputFile;
	StackNode* top;			//top node on the stack


	void openFile();
	void testFile();
	void closeFile();
	void readInput();
	void processData();

	void push(int);
	int pop();
	bool isEmpty();

public:
	pfMath();
	void driver();
};

//pfMath::pfMath
//default constructor
pfMath::pfMath()
{
	top = NULL;
}

//pfMath: openFile
//open the input file
void pfMath::openFile()
{
	inputFile.open("postfix.txt");

	testFile();
}

//pfMath: testFile
//test if the input file opened properly
void pfMath::testFile()
{
	using std::cerr;

	if (!inputFile)
	{
		cerr << "postfix.txt did not open properly";
		exit(1);
	}
}

//pfMath:closeFile
//close the input file
void pfMath::closeFile()
{
	inputFile.close();
}

//pfMath:readInput
//read in to the stack from the input file
void pfMath::readInput()
{
	int num;
	int answer;
	char ch;
	string str;

	while (inputFile.peek() != EOF)
	{
		cout << "new line in file" << endl;
		ch = inputFile.peek();
		//		cout << "ch = " << ch << endl;

		while (ch != '\n')
		{
			inputFile >> num;
			cout << "num = " << num << endl;

			if (!inputFile)   //character input
			{
				inputFile.clear();		//reset to a good read
//				ch = inputFile.get();
	//			ch = inputFile.peek();
	//			cout << "in if bad read ch = " << ch << endl;
				processData();
			}
			else
			{
				push(num);
			}
			ch = inputFile.peek();
			//			cout << "ch = " << ch << endl;
		}
		answer = pop();
		cout << "Answer = " << answer << endl;
		getline(inputFile, str);

	}
}

void pfMath::processData()
{
	int num1;		//number to be popped off the stack when operator encountered
	int num2;		//number to be popped off the stack when operator encountered
	int answer;		//number to be pushed onto the stack after computation
	char oper;		//operator character

	inputFile >> oper;
	cout << "oper = " << oper << endl;

	switch (oper)
	{
	case '+':
		num1 = pop();
		num2 = pop();
		cout << "num1 = " << num1 << "   num 2 = " << num2 << endl;
		answer = num2 + num1;
		push(answer);
		break;
	case '-':
		num1 = pop();
		num2 = pop();
		cout << "num1 = " << num1 << "   num 2 = " << num2 << endl;
		answer = num2 - num1;
		push(answer);
		break;
	case '*':
		num1 = pop();
		num2 = pop();
		cout << "num1 = " << num1 << "   num 2 = " << num2 << endl;
		answer = num2 * num1;
		push(answer);

		break;
	case '/':
		num1 = pop();
		num2 = pop();
		cout << "num1 = " << num1 << "   num 2 = " << num2 << endl;
		answer = num2 / num1;
		push(answer);
		break;
	}
}

void pfMath::push(int n)
{
	top = new StackNode(n, top);
}

int pfMath::pop()
{
	StackNode* temp;		//temporary pointer
	int val = 0;

	if (!(isEmpty()))
	{
		val = top->number;
		temp = top;
		top = top->next;
		delete temp;
	}

	return val;
}

bool pfMath::isEmpty()
{
	if (!top)
		return true;
	else
		return false;
}

void pfMath::driver()
{
	openFile();

	readInput();

	closeFile();
}

/*************************Main***************************/
int main()
{
	pfMath mathObj;

	mathObj.driver();
}