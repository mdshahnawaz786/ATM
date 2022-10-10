import java.util.*;


class Person{
    String name;
    int ac_no;
    int balance;
    int PIN;

    public Person(String name, int ac_no, int balance, int PIN){
        this.name=name;
        this.ac_no=ac_no;
        this.balance=balance;
        this.PIN=PIN;
    }
}

class ATM{
    ArrayList<Person>accounts;
    public ATM(){
        accounts=new ArrayList<>();
    }

    private Person getPerson(String entered_name, int entered_ac_no){

        Person p = null;

        for(int i=0; i<accounts.size(); i++){
            Person curr_Person = accounts.get(i);

            if(curr_Person.name.equals(entered_name) && curr_Person.ac_no==entered_ac_no){
                p=curr_Person;
                break;
            }
        }
        return p;
    }

    public void withdrawCash(Person p, int entered_pin, int amount){
        if(p.PIN==entered_pin){
            if(p.balance < amount){
                System.out.println("Insufficient fund, available bal is "+ p.balance);
            }else{
                p.balance=p.balance-amount;
                System.out.println("Transacton sucessfull " + amount + " available bal is " + p.balance);
            }

        }else{
            System.out.println("Entered pin is wrong");
        }
    }

    public void withdrawCash(String entered_name, int entered_ac_no, int entered_pin, int amount){
        Person p = getPerson(entered_name, entered_ac_no);

        if(p==null){
            System.out.println("No such accounts details");
            return;
        }
        withdrawCash(p, entered_pin, amount);
    }

    public void depositCash(Person p, int amount){
        p.balance = p.balance+amount;
        System.out.println("New balance is "+ p.balance);
    }

    public void depositCash(String entered_name, int entered_ac_no, int amount){
        Person p = getPerson(entered_name, entered_ac_no);

        if(p==null){
            System.out.println("No such account details");
            return;
        }
        depositCash(p, amount);
    }

    public void getBalance(Person p, int entered_pin){
        if(p.PIN==entered_pin){
            System.out.println("Available balance is "+p.balance);
        }else{
            System.out.println("Entered pin is wrong");
            return;
        }
    }

    public void getBalance(String entered_name, int entered_ac_no, int entered_pin){
        Person p = getPerson(entered_name, entered_ac_no);

        if(p==null){
            System.out.println("No such account details");
        }
        getBalance(p, entered_pin);
    }

    public void changePin(Person p, int old_pin, int new_pin){
        if(p.PIN==old_pin){
            System.out.println("Pin changed sucessfully");
            p.PIN=new_pin;
        }else{
            System.out.println("old pin is wrong");
        }
    }
}


public class Practice {
    public static void main(String[] args) {
        ATM Bank = new ATM();

        Person p1 = new Person("A", 1, 1000, 1234);
        Bank.accounts.add(p1);
            
        Bank.withdrawCash(p1,1234,100);
        Bank.withdrawCash(p1, 1111, 500);
        Bank.withdrawCash(p1, 1234, 50000);

        Bank.withdrawCash("A", 1, 1234, 100000);

         Bank.depositCash(p1, 10000);
        Bank.depositCash("A", 1, 100);

        Bank.getBalance(p1, 1234);
         Bank.getBalance("A",1, 1234);

         Bank.changePin(p1, 1234, 0000);

         Bank.changePin(p1, 1234, 0000);

         Bank.withdrawCash(p1,1234,100);
         Bank.withdrawCash(p1, 1111, 500);
         Bank.withdrawCash(p1, 1234, 50000);
 
         Bank.withdrawCash("A", 1, 1234, 100000);
 
          Bank.depositCash(p1, 10000);
         Bank.depositCash("A", 1, 100);
 
         Bank.getBalance(p1, 1234);
          Bank.getBalance("A",1, 1234);
    }
}
