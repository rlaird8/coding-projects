#include <iostream>
#include <string>
#include <ctime>
#include <fstream>

using namespace std;

const int WINNING_AMOUNT = 3500;

class Space
{
private:
    // everything needs a getter
    // only if something needs to be changed it needs a setter
    string type;
    string color;
    string name;
    int owner;
    int location;
    int price;
    int rent;

public:
    Space() // default constructor
    {
        type = "";
        color = "";
        name = "";
        owner = -1;
        location = -1;
        price = 0;
        rent = 0;
    }
    ~Space() {}

    Space(string t) // overloaded constructor
    {
        type = t;
    }

    Space(string t, string c, string n, int o, int l, int p, int r) // overloaded constructor
    {
        type = t;
        color = c;
        name = n;
        owner = o;
        location = l;
        price = p;
        rent = r;
    }
    string getType()
    {
        return type;
    }
    void setOwner(int o)
    {
        owner = o;
    }
    int getOwner()
    {
        return owner;
    }

    string getColor()
    {
        return color;
    }

    string getName()
    {
        return name;
    }

    int getLocation()
    {
        return location;
    }

    int getPrice()
    {
        return price;
    }

    int getRent()
    {
        return rent;
    }

    void display()
    {
        cout << "type: " << type << " "
             << "Color: " << color << " "
             << "Name: "
             << name << " "
             << "Owner: " << owner << " "
             << "Location: "
             << location << " "
             << "Price: " << price << " "
             << "Rent: " << rent << endl;
    }
};

class Player
{
private:
    int money = 1500;
    int location = 0;
    int roll;
    int pNumber;

public:
    Player() // default constructor
    {
        int pNumber = 0;
        int money = 0;
        int location = -1;
        int roll = 0;
    }
    Player(int m, int l, int r, int p)
    {
        money = m;
        location = l;
        roll = r;
        pNumber = p;
    }
    ~Player() {}

    void setMoney(int m)
    {
        money = m;
    }
    void setPlayer(int num)
    {
        pNumber = num;
    }
    void setLocation(int l)
    {
        location = l;
    }
    int getMoney()
    {
        return money;
    }
    int getLocation()
    {
        return location;
    }
    int getRoll()
    {
        return roll;
    }
    int getpNum()
    {
        return pNumber;
    }
    // buy
    // rent
    int move()
    {

        int d1, d2, result;
        d1 = rand() % 6 + 1;
        d2 = rand() % 6 + 1;

        result = d1 + d2;
        location += result;
        location %= 40;
        roll = result;
        return location;
    }
};

struct Card
{
    string name;
    string desc;
    int x;
    void fillCard(string n, string d, int y)
    {
        name = n;
        desc = d;
        x = y;
    }
};

class CommunityChest
{
private:
    Card *chestDeck;
    int size = 5;

public:
    CommunityChest()
    {
        chestDeck = new Card[5];
        chestDeck[0].fillCard("Doctors", "Doctors fee. Pay $50", -50);
        chestDeck[1].fillCard("Holiday", "Holiday fund matures. Receive $100", 100); // good
        chestDeck[2].fillCard("Income", "Income tax refund. Collect $20", 20);       // good
        chestDeck[3].fillCard("Life", "Life insurance matures. Collect $100", 100);  // good
        chestDeck[4].fillCard("Pay", "Pay school fees of $50", -50);                 // good
    }
    Card randomCard()
    { // random fuction for cards
        int num;
        num = rand() % 5 + 0;
        return chestDeck[num];
    }
};

class Chance
{
private:
    Card *chanceDeck;
    int size = 5;

public:
    Chance()
    {
        chanceDeck = new Card[5];
        chanceDeck[0].fillCard("Bankerror", "Bank error in your favor. Collect $200", 200);
        chanceDeck[1].fillCard("Pay", "Pay hospital fees $100", -100);                        // good
        chanceDeck[2].fillCard("Speeding", "Speeding fine $15", -15);                         // good
        chanceDeck[3].fillCard("building", "Your building loan matures, collect $150.", 150); // good
        chanceDeck[4].fillCard("Bank", "Bank pays you dividend of $50.", 50);                 // good
    }
    Card randomCard()
    { // random fuction for cards
        int num;
        num = rand() % 5 + 0;
        return chanceDeck[num];
    }
};

int main()
{
    srand(time(0)); // always has to be in main
    ofstream outFile;
    outFile.open("Log.txt");
    if (!outFile)
    {
        outFile << "file not found";
    }
    else
    {
        outFile << "Lets the games begin!"
                << "\n\n";

        // Coners
        Space go("Start", "None", "Go", -2, 0, 200, 0);
        Space jail("Jail", "None", "Jail/Just Visting", -2, 10, 0, 0);
        Space free("Free", "None", "Free Parking", -2, 20, 0, 0);
        Space GoToJail("To Jail", "None", "Go to Jail", -2, 30, 50, 0);

        // Taxes
        Space incomeTax("Taxes", "None", "Income Tax", -2, 4, 200, 150);
        Space luxuryTax("Taxes", "None", "Luxury Tax", -2, 38, 150, 150);

        // utilities
        Space electric("utilities", "None", "Electric company", -1, 12, 150, 75);
        Space water("utilities", "None", "Water works", -1, 28, 150, 75);

        // Properties
        Space med("Property", "Brown", "Mediterranean Avenue", -1, 1, 60, 2);
        Space baltic("Property", "Brown", "Baltic Ave", -1, 3, 60, 4);
        Space oriental("Property", "light blue", "Oriental Ave", -1, 6, 100, 6);
        Space vermont("Property", "light blue", "Vermont Ave", -1, 8, 100, 6);
        Space connecticut("Property", "light blue", "Connecticut Ave", -1, 9, 120, 8);
        Space charles("Property", "Pink", "St.Charles place", -1, 11, 140, 10);
        Space states("Property", "Pink", "States Ave", -1, 13, 140, 10);
        Space virginia("Property", "Pink", "Virginia Ave", -1, 14, 160, 12);
        Space james("Property", "Yellow", "St.James place", -1, 16, 180, 14);
        Space tennessee("Property", "Yellow", "Tennessee Ave", -1, 18, 180, 14);
        Space New("Property", "Yellow", "New york Ave", -1, 19, 200, 16);
        Space Kentucky("Property", "Orange", "Kentucky Ave", -1, 21, 220, 18);
        Space indiana("Property", "Orange", "Indiana Ave", -1, 23, 220, 18);
        Space illinois("Property", "Orange", "Illinois Ave", -1, 24, 240, 20);
        Space atlantic("Property", "Light Yellow", "Atlantic Ave", -1, 26, 260, 22);
        Space ventorAve("Property", "Light Yellow", "Ventor Avenue", -1, 27, 260, 22);
        Space marvinGardens("Property", "Light Yellow", "Marvin Gardens", -1, 29, 280, 24);
        Space pacificAve("Property", "Green", "Pacific Avenue", -1, 31, 300, 26);
        Space northCarolinaAve("Property", "Green", "North Carolina Avenue", -1, 32, 300, 26);
        Space pennsylvaniaAve("Property", "Green", "Pennsylvania Avenue", -1, 34, 320, 28);
        Space parkPlace("Property", "Blue", "Park Place", -1, 37, 350, 35);
        Space boardwalk("Property", "Blue", "Boardwalk", -1, 39, 400, 50);

        // Chance
        Space chance1("Chance", "None", "Chance cards", -2, 7, 0, 0);
        Space chance2("Chance", "None", "Chance cards", -2, 22, 0, 0);
        Space chance3("Chance", "None", "Chance cards", -2, 36, 0, 0);

        // Community Chests
        Space community1("Community", "None", "Community Chest", -2, 2, 0, 0);
        Space community2("Community", "None", "Community Chest", -2, 17, 0, 0);
        Space community3("Community", "None", "Community Chest", -2, 33, 0, 0);

        // Railroads
        Space reading("Railroad", "None", "Reading Railroad", -1, 5, 200, 25);
        Space Penn("Railroad", "None", "Pennsylvania Railroad", -1, 15, 200, 25);
        Space BO("Railroad", "None", "B & O Railroad", -1, 25, 200, 25);
        Space shortLine("Railroad", "None", "Short Line Railroad", -1, 35, 200, 25);

        Space arr[40];
        arr[0] = go;
        arr[1] = med;
        arr[2] = community1;
        arr[3] = baltic;
        arr[4] = incomeTax;
        arr[5] = reading;
        arr[6] = oriental;
        arr[7] = chance1;
        arr[8] = vermont;
        arr[9] = connecticut;
        arr[10] = jail;
        arr[11] = charles;
        arr[12] = electric;
        arr[13] = states;
        arr[14] = virginia;
        arr[15] = Penn;
        arr[16] = james;
        arr[17] = community2;
        arr[18] = tennessee;
        arr[19] = New;
        arr[20] = free;
        arr[21] = Kentucky;
        arr[22] = chance2;
        arr[23] = indiana;
        arr[24] = illinois;
        arr[25] = BO;
        arr[26] = atlantic;
        arr[27] = ventorAve;
        arr[28] = water;
        arr[29] = marvinGardens;
        arr[30] = GoToJail;
        arr[31] = pacificAve;
        arr[32] = northCarolinaAve;
        arr[33] = community3;
        arr[34] = pennsylvaniaAve;
        arr[35] = shortLine;
        arr[36] = chance3;
        arr[37] = parkPlace;
        arr[38] = luxuryTax;
        arr[39] = boardwalk;

        int numOfPlayers;
        cout << "How many players are playing?" << endl;
        cin >> numOfPlayers;
        Player *pList;
        pList = new Player[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++)
        {
            pList[i].setPlayer(i);
        }
        bool winFlag = false;
        int currentPlayer = 0;
        CommunityChest community;
        Chance chance;
        while (winFlag == false)
        {
            int oldLocation = pList[currentPlayer].getLocation();
            int location = pList[currentPlayer].move();
            outFile << "Player " << pList[currentPlayer].getpNum() << " rolled a " << pList[currentPlayer].getRoll() << endl;
            if (oldLocation > location)
            {
                pList[currentPlayer].setMoney(pList[currentPlayer].getMoney() + 200);
                outFile << "Player " << pList[currentPlayer].getpNum() << " passed GO! They receive $200" << endl;
                outFile << "Player " << pList[currentPlayer].getpNum() << " now has $" << pList[currentPlayer].getMoney() << endl;
            }
            string tempType = arr[location].getType();
            if (tempType == "Property" || tempType == "Railroad" || tempType == "utilities")
            {
                if (arr[location].getOwner() == -1)
                {
                    int newAmount = pList[currentPlayer].getMoney() - arr[location].getPrice();
                    pList[currentPlayer].setMoney(newAmount);                                                                                                            // paying the price for the location
                    arr[location].setOwner(currentPlayer);                                                                                                               // set the owner of the property to currentPlayer
                    outFile << "Player " << pList[currentPlayer].getpNum() << " has bought " << arr[location].getName() << " for $" << arr[location].getPrice() << endl; // print transaction in Log.txt
                    outFile << "Player " << pList[currentPlayer].getpNum() << " now has $" << pList[currentPlayer].getMoney() << endl;
                }
                else if (arr[location].getOwner() == currentPlayer)
                {

                    outFile << "Player " << currentPlayer << " has landed on a location they own" << endl;
                }
                else
                {
                    pList[currentPlayer].setMoney(pList[currentPlayer].getMoney() - arr[location].getRent());
                    pList[arr[location].getOwner()].setMoney(pList[arr[location].getOwner()].getMoney() + arr[location].getRent());
                    outFile << "Player " << pList[currentPlayer].getpNum() << " has paid Player " << arr[location].getOwner() << " $" << arr[location].getRent() << ", landed on " << arr[location].getName() << endl;
                    outFile << "Player " << pList[currentPlayer].getpNum() << " now has $" << pList[currentPlayer].getMoney() << endl;
                    outFile << "Player " << arr[location].getOwner() << " now has $" << pList[arr[location].getOwner()].getMoney() << endl;
                }
            }
            else if (tempType == "Taxes")
            {
                pList[currentPlayer].setMoney(pList[currentPlayer].getMoney() - arr[location].getRent());
                outFile << "Player " << pList[currentPlayer].getpNum() << " landed on " << arr[location].getName() << " and paid $" << arr[location].getRent() << endl;
                outFile << "Player " << pList[currentPlayer].getpNum() << " now has $" << pList[currentPlayer].getMoney() << endl;
            }

            else if (tempType == "Community")
            {
                outFile << "player landed on community" << endl;
                Card myCard = community.randomCard();
                outFile << "Player " << pList[currentPlayer].getpNum() << " has drew the card, " << myCard.desc << endl;
                pList[currentPlayer].setMoney(pList[currentPlayer].getMoney() + myCard.x);
                outFile << "Player " << pList[currentPlayer].getpNum() << " new $" << pList[currentPlayer].getMoney() << endl;
            }
            else if (tempType == "Chance")
            {
                outFile << "player landed on chance" << endl;
                Card myCard2 = chance.randomCard();
                outFile << "Player " << pList[currentPlayer].getpNum() << " has drew the card, " << myCard2.desc << endl;
                pList[currentPlayer].setMoney(pList[currentPlayer].getMoney() + myCard2.x);
                outFile << "Player " << pList[currentPlayer].getpNum() << " new $" << pList[currentPlayer].getMoney() << endl;
            }
            else if (tempType == "Start")
            {
                outFile << "Player " << pList[currentPlayer].getpNum() << " landed on GO" << endl;
            }
            else if (tempType == "To Jail")
            { // go to jail
                pList[currentPlayer].setMoney(pList[currentPlayer].getMoney() - arr[location].getRent());
                // pList[currentPlayer].setLocation(arr[location].get)
                outFile << "Player " << pList[currentPlayer].getpNum() << " went to jail" << endl;
                outFile << "Player " << pList[currentPlayer].getpNum() << " paid $50 to get out of jail" << endl;
                outFile << "Player " << pList[currentPlayer].getpNum() << " now has $" << pList[currentPlayer].getMoney() << endl;
            }

            // check for a winner
            for (int i = 0; i < numOfPlayers; i++)
            {
                if (pList[i].getMoney() >= WINNING_AMOUNT)
                {
                    winFlag = true;
                    outFile << "Player " << i << " has won with $" << pList[i].getMoney() << "!!!" << endl;
                    break;
                }
            }
            currentPlayer++;
            currentPlayer %= numOfPlayers;
        }
    }

    outFile.close();

    return 0;
}