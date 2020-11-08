//David Alvarez
//COP2535.001
//use a linked list to manage inventory items

#include<iostream>
#include<string>
using std::string;

class LinkedList {
private:

	struct Node {				//list node structure that holds an inventory string item
		string item;			//and a pointer to the next node
		Node* next;
		Node(string item1, Node* next1 = nullptr)
		{
			item = item1;
			next = next1;
		}
	};

	Node* head;
	
	void userMenu();
	void validateChoice(int&);
	void addToEnd();
	void addToBeg();
	void removeLast();
	void removeFirst();
	void removeName();
	void displayItems();
	
public:
	LinkedList();
	~LinkedList();
	
	void driver();
};

/*************************LinkedList Methods**************************/
//LinkedList: LinkedList
//constructor
LinkedList::LinkedList()
{
	head = nullptr;		//List head pointer
}

//inventoryMgmt: userMenu
//display menu of functions to user
void LinkedList::userMenu()
{
	using std::cout;
	using std::endl;
	using std::cin;

	//local variable
	int choice;

	cout << "Please select a function:	" << endl;
	cout << "1. Add an item to the end of the list" << endl;
	cout << "2. Add an item to the beginning of the list" << endl;
	cout << "3. Remove the last item in the list" << endl;
	cout << "4. Remove the first item in the list" << endl;
	cout << "5. Remove an item by name" << endl;
	cout << "6. Display the items in the list" << endl;
	cout << "7. Exit" << endl << endl;
	cin >> choice;

	validateChoice(choice);

	switch (choice)
	{
	case 1: addToEnd();
		break;
	case 2: addToBeg();
		break;
	case 3: removeLast();
		break;
	case 4: removeFirst();
		break;
	case 5: removeName();
		break;
	case 6: displayItems();
		break;
	case 7: exit(0);
	}
}

//inventoryMgmt: validateChoice
//validate user input of an integer
void LinkedList::validateChoice(int& i)
{
	using std::cin;
	using std::cerr;
	using std::endl;

	while (!cin || i < 1 || i > 7)
	{
		cerr << "Invalid entry, please try again: ";
		cin.clear();
		fseek(stdin, 0, SEEK_END);
		cin >> i;
		fseek(stdin, 0, SEEK_END);
	}
}

//LinkedList: addToEnd
//add an item to the end of the list
void LinkedList::addToEnd()
{
	using std::cin;

	string input;
	Node* ptr = head;

	std::cout << "Enter an item to add to the end of the list: ";
	fseek(stdin, 0, SEEK_END);
	cin.clear();
	std::getline(cin, input);

	if (head == nullptr)
		head = new Node(input);
	else
	{
		while (ptr->next != nullptr)
			ptr = ptr->next;
		ptr->next = new Node(input);
	}

	std::cout << "\"" << input << "\"" << " was added to the list" << std::endl << std::endl;

	userMenu();
}

//LinkedList: addToBeg
//add an item to the beginning of the list
void LinkedList::addToBeg()
{
	using std::cin;

	//local variable
	string input;

	std::cout << "Enter an item to add to the beginning of the list: ";
	fseek(stdin, 0, SEEK_END);
	cin.clear();
	std::getline(cin, input);

	head = new Node(input, head);

	std::cout << "\"" << input << "\"" << " was added to the list" << std::endl << std::endl;

	userMenu();
}

//LinkedList: removeEnd
//delete an item from the end of the list
void LinkedList::removeLast()
{
	using std::cout;
	using std::endl;
	
	//local variables
	string value;
	Node* ptr = head;
	Node* temp = ptr;

	if (head == nullptr)
		cout << "*Empty list, nothing to delete*" << endl << endl;
	else if (head->next == nullptr)
	{
		value = head->item;
		head = head->next;
		delete ptr;
		cout << "\"" << value << "\"" << " removed" << endl << endl;
	}
	else
	{
		while (ptr->next != nullptr)
		{
			temp = ptr;
			ptr = ptr->next;
		}
		if (ptr)
		{
			temp->next = ptr->next;
			value = ptr->item;
			delete ptr;
		}
		cout << "\"" << value << "\"" << " removed" << endl << endl;
	}


	userMenu();
}

//LinkedList: removeBeg
//remove first item in the list
void LinkedList::removeFirst()
{
	using std::cout;
	using std::endl;

	//local variables
	Node* ptr = head;
	string value;

	if (head == nullptr)
		cout << "*Empty list, nothing to delete*" << endl << endl;
	else
	{
		head = head->next;
		value = ptr->item;
		delete ptr;

		cout << "\"" << value << "\"" << " removed" << endl << endl;
	}
	
	userMenu();
}

//LinkedList: removeName
//remove a list item by value
void LinkedList::removeName()
{
	using std::cout;
	using std::cin;
	using std::endl;

	//local variables
	string input;
	Node* ptr = head;
	Node* temp = head;

	if (!head)
	{
		std::cerr << "*The list is empty*" << endl << endl;
		userMenu();
	}
	
	cout << "Enter the name of the item you'd like to remove: ";
	fseek(stdin, 0, SEEK_END);
	cin.clear();
	std::getline(cin, input);


	if (head->item == input)
	{
		ptr = head;
		head = head->next;
		delete ptr;

		cout << "\"" << input << "\"" << " removed" << endl << endl;
		userMenu();
	}

	while (ptr != nullptr && ptr->item != input)
	{
		temp = ptr;
		ptr = ptr->next;
	}

	if (ptr == nullptr)
	{
		cout << "*Item not found*" << endl << endl;
	}
	else if (ptr)
	{
		temp->next = ptr->next;
		delete ptr;

		cout << "\"" << input << "\"" << " removed" << endl << endl;
	}

	userMenu();
}

//LinkedList: displayItems
//display list items
void LinkedList::displayItems()
{
	using std::cout;
	using std::endl;

	//local variable
	Node* ptr = head;

	cout << "*****************" << endl;
	cout << "**List Contents**" << endl;
	cout << "*****************" << endl;

	if (ptr == nullptr)
	{
		std::cerr << "*Error* Empty list" << endl << endl;
		userMenu();
	}
	else
	{
		while (ptr != nullptr)
		{
			cout << ptr->item << endl;
			ptr = ptr->next;
		}
	}
	
	cout << "*****************" << endl << endl;

	userMenu();
}

//LinkedList: ~LinkedList
//destructor
LinkedList::~LinkedList()
{
	while (head != 0)
	{
		Node* p = head;
		head = head->next;
		delete p;
	}
}

//LinkedList: driver
//call the order of functions
void LinkedList::driver()
{
	userMenu();
}

/**********************Main**************************/
int main()
{
	LinkedList list;

	list.driver();

	system("pause");

	return 0;
}