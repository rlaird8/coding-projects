#include <iostream>
#include <fstream>
#include <string>

using namespace std;

struct Node
{
 
	string Number;
	string ElementName;
	string Symbol;
	string ATM;

  Node* next = nullptr;

  void printNode()
  {
    cout << Number << " ";
    cout << ElementName << " ";
    cout << Symbol << " ";
    cout << ATM << " ";
    cout << "\n-------------------------" << endl;
  }
	
};

class LinkedList
{
  private:
    Node* head;
    int count;

  public:
							// LinkedList Constructor
    LinkedList()
	{
      head = nullptr;
      count = 0;
    }

    void insert(string num, string name, string sym, string mass)
	{
      Node *newNode;    
      Node* ptr;

      newNode = new Node;
      newNode->Number = num;
      newNode->ElementName = name;
      newNode->Symbol = sym;
      newNode->ATM = mass;

      if (!head)
	  {
        head = newNode;
        count++;
      }
      else
	  {
        ptr = head;
        while (ptr->next){
          ptr = ptr->next;
        }
        ptr->next = newNode;
        count++;
      }
    }

    void searchNum(string num)			// this function allows the user to search for an element by its atomic number
	{	
      Node* ptr;

      ptr = head;

      while(ptr){
        if(ptr->Number.compare(num) == 0)
		{
          ptr->printNode();
          break;
        }
        ptr = ptr->next;
      }
    }

    void searchName(string name)		// this function allows the user to search for an element by its name
	{ 
        Node* ptr;
    ptr = head;

        while(ptr)
		{
          if(ptr->ElementName.compare(name) == 0)
		  {
            ptr->printNode();
            break;
          }
          ptr = ptr->next;
        }
      }
    
    void searchSym(string sym)			// this function allows the user to search for an element by its symbol
	{
       Node* ptr;

       ptr = head;

      while(ptr)
	  {
        if(ptr->Symbol.compare(sym) == 0)
		{
          ptr->printNode();
          break;
        }
        ptr = ptr->next;
      }
    }
    


    void displayList()				// this function displays the list of elements and their properties
	{
      Node* ptr;

      ptr = head; 

      while(ptr)
	  { 
        ptr->printNode();
        ptr = ptr->next;
      }
    }
};

int main()
{
  LinkedList tableList;
	fstream dataFile("Periodic.csv", ios::in);
	string temp;
    string Number;
	string ElementName;
	string Symbol;
	string ATM;
	
	getline(dataFile, temp);

	for (int i = 0; i < 118; i++)
	{
		getline(dataFile ,Number, ',');
		
		getline(dataFile , ElementName, ',');

		
		getline(dataFile , Symbol, ',');

		
		getline(dataFile , ATM, ',');
		
		getline(dataFile , temp);
		
    tableList.insert(Number, ElementName, Symbol, ATM);
    
	}

    bool repeat = true;
    while(repeat)
	{


      int choice;
      cout << endl << "Periodic Table of elements\n\nWhat would you like to do?\n" << endl <<
      "1. Print the full List of elements out.\n" <<
      "2. Search for an element by its Atomic Number.\n" <<
      "3. Search for an element by the Element's Name.\n" <<
      "4. Search for an element by its Symbol.\n" <<
      "5. Quit.\n" <<
      "Choice: ";
      cin >> choice;
      cout << "\n-----------------------------" << endl;

      switch(choice){
        case 1:{ 
          tableList.displayList();
          break;
        }
        case 2:{ 
          string ATN;
          cout << "Enter an ATN to search: ";
          cin >> ATN;
          tableList.searchNum(ATN);
          break;
        }
        case 3:{ 
          string name;
          cout << "Enter an element name to search: ";
          cin >> name;
          tableList.searchName(name);
          break;
        }
        case 4:{ 
          string sym;
          cout << "Enter a symbol to search: ";
          cin >> sym;
          tableList.searchSym(sym);
          break;
        }
        case 5:{ 
          repeat = false;
          cout << "Thanks for using Ryan's element search! Have a great day!\n";
          break;
        }
        default:{
          cout << "The choice entered is invalid, try again!\n";
          break;
        }
      }
    }
  
  return 0;
}