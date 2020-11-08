//David Alvarez
//COP2535.001
//uses a binary tree to store employee information and allow for search of that info

#include<iostream>
#include<string>
#include<fstream>
#include<sstream>

using std::cout;
using std::cin;
using std::endl;
using std::string;
using std::ifstream;
using std::getline;


class EmployeeInfo
{
private:
	struct TreeNode
	{
		int eID;
		string name;
		TreeNode* left;
		TreeNode* right;

		TreeNode(int num, string n, TreeNode* lp = NULL, TreeNode* rp = NULL)
		{
			eID = num;
			name = n;
			left = lp;
			right = rp;
		}
	};

	TreeNode* tree = NULL;

	ifstream inputFile;

	void openFile();
	void testFile();
	void processFile();
	void closeFile();

	void insert(int, string);
	void prompt();
	void validateEID(int&);
	void validateChoice(char&);
	void searchTree(int);

public:
	void driver();
};

//employeeInfo: openFile
//open the input file
void EmployeeInfo::openFile()
{
	inputFile.open("employee.txt");

	testFile();
}

//EmployeeInfo: testFile
//test that the input file opened properly
void EmployeeInfo::testFile()
{
	if (!inputFile)
	{
		std::cerr << "employee.txt did not open properly";
		exit(1);
	}
}

//EmployeeInfo: processFile
//process the input file
void EmployeeInfo::processFile() 
{
	using std::istringstream;

	string line, first, last, fullName;
	int idNum;

	while (getline(inputFile, line))
	{
		istringstream istr(line);

		istr >> idNum >> first >> last;
		fullName = first + " " + last;

		//cout << idNum << " " << fullName << endl;	//testing purposes

		insert(idNum, fullName);
	}
}

//EmployeeInfo: closeFile
//close the input file
void EmployeeInfo::closeFile()
{
	inputFile.close();
}

//EmployeeInfo: insert
//insert a leaf into the tree
void EmployeeInfo::insert(int num, string name)
{
	if (tree == NULL)
	{
		tree = new TreeNode(num, name);
		return;
	}

	TreeNode* p = tree;

	while (p != NULL)
	{
		if (num <= p->eID)
		{
			if (p->left == NULL)
			{
				p->left = new TreeNode(num, name);
				return;
			}
			else
				p = p->left;
		}
		else
		{
			if (p->right == NULL)
			{
				p->right = new TreeNode(num, name);
				return;
			}
			else
				p = p->right;
		}
	}
}

//EmployeeInfo: promptUser
//prompt the user for an ID number to search for
void EmployeeInfo::prompt()
{
	int eID;
	char again = 'Y';

	while (again == 'Y')
	{
		cout << "Enter an employee ID number to search for: ";
		cin >> eID;
		validateEID(eID);
		searchTree(eID);
		cout << "Would you like to search again (Y/N)? ";
		cin >> again;
		again = toupper(again);
		validateChoice(again);
	}
	
}

//EmployeeInfo validateEID
//validate user integer input
void EmployeeInfo::validateEID(int& i)
{
	while (!cin || i < 0)
	{
		cout << "Invalid input, try again: ";
		cin.clear();
		fseek(stdin, 0, SEEK_END);
		cin >> i;
		fseek(stdin, 0, SEEK_END);
	}
}

//EmployeeInfo: validate
//validate user character input
void EmployeeInfo::validateChoice(char& c)
{
	while (c != 'Y' && c != 'N')
	{
		cout << "Invalid input (Y/N only), try again: ";
		cin.clear();
		fseek(stdin, 0, SEEK_END);
		cin >> c;
		c = toupper(c);
		fseek(stdin, 0, SEEK_END);
	}
}

//EmployeeInfo: searchTree
//search the tree for an employee ID number and return their name
void EmployeeInfo::searchTree(int num)
{
	TreeNode* p = tree;
	bool rootEmployee = false;

	if (p == NULL)
	{
		cout << num << "does not exist in the tree." << endl << endl;
	}

	if (p->eID == num)
	{
		cout << num << " is associated with employee " << p->name << endl << endl;
		rootEmployee = true;
	}

	while (p->eID != num)
	{
		if (p->eID > num)
			p = p->left;
		else
			p = p->right;

		if (p == NULL)
		{
			cout << num << " does not exist in the tree." << endl << endl;
			return;
		}
	}

	if (rootEmployee == false)
		cout << num << " is associated with employee " << p->name << endl << endl;
}

void EmployeeInfo::driver()
{
	openFile();

	processFile();

	closeFile();

	prompt();
}
int main()
{
	EmployeeInfo eInfoObj;

	eInfoObj.driver();

}