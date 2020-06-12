package machine;

public class Machine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    private State state;
    private boolean power;

    public Machine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
        this.state = State.MAIN;
        this.power = false;
    }

    public void start(String input) {
        switch (this.state) {
            case MAIN:
                action(input);
                break;
            case BUY:
                buy(input);
                break;
            case FILL_WATER:
                fillWater(input);
                break;
            case FILL_MILK:
                fillMilk(input);
                break;
            case ADD_BEANS:
                addBeans(input);
                break;
            case ADD_CUPS:
                addCups(input);
                break;
        }
    }

    private void action(String input) {
        switch (input) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino" +
                        ", back - to main menu:");
                this.state = State.BUY;
                break;

            case "fill":
                System.out.println("Write how many ml of water do you want to add:");
                this.state = State.FILL_WATER;
                break;

            case "take":
                take();
                System.out.println();
                returnToMain();
                break;

            case "remaining":
                display();
                returnToMain();
                break;

            case "exit":
                powerOff();
                break;

            default:
                break;
        }
    }

    private void buy(String input) {
        switch (input) {
            case "1":
                buyEspresso();
                returnToMain();
                break;

            case "2":
                buyLatte();
                returnToMain();
                break;

            case "3":
                buyCappuccino();
                returnToMain();
                break;

            case "back":
                returnToMain();
                break;

            default:
                break;
        }

    }

    private void buyEspresso() {
        if (water >= 250 && beans >= 16 && cups >= 1) {
            water -= 250;
            beans -= 16;
            cups--;
            money += 4;
            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();

        } else if (water < 250) {
            System.out.println("Sorry, not enough water!");
            System.out.println();

        } else if (beans < 16) {
            System.out.println("Sorry, not enough coffee beans!");
            System.out.println();

        } else if (cups == 0) {
            System.out.println("Sorry, not enough cups cups!");
            System.out.println();
        }
    }


    private void buyLatte() {
        if (water >= 350 && milk >= 75 && beans >= 20 && cups >= 1) {
            water -= 350;
            milk -= 75;
            beans -= 20;
            cups--;
            money += 7;
            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();

        } else if (water < 350){
            System.out.println("Sorry, not enough water!");
            System.out.println();

        } else if (milk < 75) {
            System.out.println("Sorry, not enough milk!");
            System.out.println();

        } else if (beans < 20) {
            System.out.println("Sorry, not enough coffee beans!");
            System.out.println();

        } else if (cups == 0){
            System.out.println("Sorry, not enough disposable cups!");
            System.out.println();
        }
    }

    private void buyCappuccino() {
        if (water >= 200 && milk >= 100 && beans >= 12 && cups >= 1) {
            water -= 200;
            milk -= 100;
            beans -= 12;
            cups--;
            money += 6;
            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();

        } else if (water < 200){
            System.out.println("Sorry, not enough water!");
            System.out.println();

        } else if (milk < 100) {
            System.out.println("Sorry, not enough milk!");
            System.out.println();

        } else if (beans < 12){
            System.out.println("Sorry, not enough coffee beans!");
            System.out.println();

        } else if (cups == 0){
            System.out.println("Sorry, not enough cups cups!");
            System.out.println();
        }
    }

    private void returnToMain(){
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        this.state = State.MAIN;
    }

    private void fillWater(String input){
        water += Integer.parseInt(input);
        System.out.println("Write how many ml of milk do you want to add:");
        this.state = State.FILL_MILK;
    }

    private void fillMilk(String input){
        milk += Integer.parseInt(input);
        System.out.println("Write how many grams of coffee beans do you want to add:");
        this.state = State.ADD_BEANS;

    }

    private void addBeans(String input){
        beans += Integer.parseInt(input);
        System.out.println("Write how many disposable cups do you want to add:");
        this.state = State.ADD_CUPS;
    }

    private void addCups(String input){
        cups += Integer.parseInt(input);
        System.out.println();
        returnToMain();
    }

    private void take(){
        System.out.println();
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }

    private void display(){
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.beans + " of coffee beans");
        System.out.println(this.cups + " of disposable cups");
        System.out.println("$" + this.money + " of money");
        System.out.println();
    }

    public void powerOn() {
        this.power = true;
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        this.state = State.MAIN;
    }

    private void powerOff(){
        this.power = false;
        this.state = State.STOP;
    }

    public boolean isPowered() {
        return this.power;
    }
}
