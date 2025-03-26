#include <iostream>
#include <vector>
#include <typeinfo>

using namespace std;

class Account
{        
    protected: 
        double balance;
    public:
        Account(double b)
        {
            if(b < 0)
            {
                balance = 0;
                cout << "Invalid input.";
            }
            else
            {
                balance = b;
            }
        }

    virtual void runAccount()
    {
        double a = 0;

        cout << "How much money do you want to withdraw from your account?:" << endl;
        cin >> a;
        debit(a);


        cout << "How much money do you want to deposit into your account?:" << endl;
        cin >> a;
        credit(a);


    }
    
    double getBalance()
    {
        return balance;
    }

    virtual void credit(double c)
    {
        if(c > 0)
        {
            balance += c;
        }
        else
        {
            cout << "Can not add negative balance. " << endl;
        }
    }
    virtual void debit(double d)
    {
        if(d >= 0)
        {
            balance -= d;
        }
        else
        {
            cout << "Can not deduct negative balance. " << endl;
        }
    }
    virtual void display()
    {
        cout << "balance $" << balance << endl;
    }

};

class Checking: public Account
{
    double fee;

    public:
    Checking(double b, double f):Account(b)
    {
        if(f < 0)
        {
            fee = 0;
            cout << "Invalid input.";
        }
        else
        {
            fee = f;
        }
    }
    void credit(double c) override
    {
        if(c > 0)
        {
            balance += c - fee;
        }
        else
        {
            cout << "Can not add negative balance. " << endl;
        }
    }
    void debit(double d) override
    {
        if(d >= 0)
        {
            balance -= d + fee;
        }else
        {
            cout << "Can not deduct negative balance. " << endl;
        }
    }

    void display() override
    {
        cout << "balance $" << balance << " fee $" << fee << endl;
    }
};

class Saving: public Account
{
    double rate;

    public:
    Saving(double b, double r): Account(b)
    {
        if(r < 0)
        {
            rate = 0;
            cout << "Invalid input" << endl;
        }
        else
        {
            rate = r;
        }
    }

    void runAccount() override
    {
        double a = 0;

        cout << "How much money do you want to withdraw from your account?:" << endl;
        cin >> a;
        debit(a);

        cout << "How much money do you want to deposit into your account?:" << endl;
        cin >> a;
        credit(a);
        interest();


    }
    void interest()
    {
        balance += balance * rate;
    }

    void display() override
    {
        cout << "balance $" << balance << " Rate %" << rate * 100 << endl;
    }
};

int main()
{

    Account a1(3000.0);
    Checking c1(3000.0, 1.0);
    Saving s1(3000.00, .01);

    vector <Account*> accounts;

    accounts.push_back(&a1);
    accounts.push_back(&c1);
    accounts.push_back(&s1);

    accounts[0]->display();
    accounts[1]->display();
    accounts[2]->display();
    
    double a; 
    double b;
    int choice;
    for(Account* acc: accounts){


        acc->runAccount();

        acc->display();
    }

    return 0;
}