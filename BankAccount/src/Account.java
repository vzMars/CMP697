public class Account implements AccountInterface {
    private Person owner;
    private final double RATE = 0.0435;
    private double balance;
    private long acctNumber;

    public Account(Person owner, long acctNumber, double initialBalance) {
        this.owner = owner;
        this.acctNumber = acctNumber;
        this.balance = initialBalance;
    }

    @Override
    public double deposit(double amount) {
        this.setBalance(this.balance + amount);
        return this.balance;
    }

    @Override
    public double withdraw(double amount, double fee) {
        this.setBalance(this.balance - (amount + fee));
        return this.balance;
    }

    @Override
    public double withdraw(double amount) {
        this.setBalance(this.balance - amount);
        return this.balance;
    }

    @Override
    public double addInterest() {
        this.setBalance(this.balance + (this.balance * this.RATE));
        return this.balance;
    }

    @Override
    public double increment() {
        this.setBalance(this.balance + 1);
        return this.balance;
    }

    @Override
    public double decrement() {
        this.setBalance(this.balance - 1);
        return this.balance;
    }

    @Override
    public Person getOwner() {
        return this.owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public long getAcctNumber() {
        return this.acctNumber;
    }

    public void setAcctNumber(long acctNumber) {
        this.acctNumber = acctNumber;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRate() {
        return this.RATE;
    }

    public static void main(String[] args) {
        Person john = new Person("John", 29, "000-00-0000", "123 Main St");
        Account account = new Account(john, 123456789, 100);

        System.out.println(account.getBalance());
        System.out.println(account.deposit(20.00));
        System.out.println(account.withdraw(120.00, 5));
    }
}
