import java.util.Scanner;
public class CorrectAtm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Atm[] user = {
            new Atm("satya",110209946502L,102005,25000,3),
            new Atm("ramesh",110209946503L,200510,1200,3),
            new Atm("aditya",110209946504L,112008,100000,3),
            new Atm("Srujan",110209946505L,200811,15000,3)
        };
        System.out.println("WELCOME TO XYZ ATM");
        System.out.println("Enter account number");
        long accno = sc.nextLong();
        boolean found = false;
        for(int i=0;i<user.length;i++){
            if(user[i].accno==accno){
                found=true;

                System.out.println("WELCOME "
                        + user[i].name);

                while(user[i].limit>0){

                    System.out.println("Enter PIN");
                    int pin=sc.nextInt();

                    if(pin==user[i].pin){

                        while(true){

                            System.out.println(
                                    "\n1.Deposit\n2.Withdraw\n3.Check Balance\n4.Change PIN\n5.Exit");

                            int opt=sc.nextInt();

                            if(opt==1){

                                System.out.println("Enter amount");
                                double amt=sc.nextDouble();

                                user[i].balance+=amt;

                                System.out.println(
                                        "Deposited Successfully");

                            }

                            else if(opt==2){

                                System.out.println(
                                        "Enter amount");

                                double amt=sc.nextDouble();

                                if(amt<=user[i].balance){

                                    user[i].balance-=amt;

                                    System.out.println(
                                            "Withdraw Successful");

                                }

                                else{
                                    System.out.println(
                                            "Insufficient balance");
                                }

                            }

                            else if(opt==3){
                                System.out.println("Balance = "+ user[i].balance);
                            }

                            else if(opt==4){

                                System.out.println(
                                        "Enter old PIN");

                                int old=sc.nextInt();

                                if(old==user[i].pin){

                                    System.out.println(
                                            "Enter new 6 digit PIN");

                                    int newpin=sc.nextInt();

                                    int temp=newpin;
                                    int count=0;

                                    while(temp>0){
                                        temp/=10;
                                        count++;
                                    }

                                    if(count==6){

                                        user[i].pin=newpin;

                                        System.out.println(
                                                "PIN Changed Successfully");

                                    }

                                    else{
                                        System.out.println(
                                                "PIN must contain 6 digits");
                                    }

                                }

                                else{
                                    System.out.println(
                                            "Old PIN incorrect");
                                }

                            }

                            else if(opt==5){

                                System.out.println(
                                        "Thank you for using XYZ ATM");

                                System.exit(0);

                            }

                            else{
                                System.out.println(
                                        "Invalid option");
                            }

                        }

                    }

                    else{

                        user[i].limit--;

                        if(user[i].limit>0){

                            System.out.println(
                                    "Wrong PIN. Attempts left: "
                                            + user[i].limit);

                        }

                        else{

                            System.out.println(
                                    "Account blocked for 24 hours");

                        }

                    }

                }

                break;
            }
        }

        if(!found){
            System.out.println("Account not found");
        }

        
    }
}

class Atm{

    String name;
    long accno;
    int pin;
    double balance;
    int limit;

    public Atm(
            String name,
            long accno,
            int pin,
            double balance,
            int limit)
        {

        this.name=name;
        this.accno=accno;
        this.pin=pin;
        this.balance=balance;
        this.limit=limit;
    }

    public String toString(){

        return this.name+" "+this.accno+" "+this.pin+" "+this.balance;
    }
}




