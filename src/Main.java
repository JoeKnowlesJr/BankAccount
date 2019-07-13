public class Main {

    public static void main(String[] args) {
        BankAccount acct1 = new BankAccount();
        BankAccount acct2 = new BankAccount();
        acct1.deposit(123.45, BankAccount.AccountType.checking);
        acct1.deposit(543.21, BankAccount.AccountType.savings);
        acct2.deposit(345.67, BankAccount.AccountType.checking);
        acct2.deposit(765.43, BankAccount.AccountType.savings);

        System.out.printf("\r\n\tAccount 1 - %s", acct1.toString());
        System.out.printf("\r\n\tAccount 2 - %s", acct2.toString());
        System.out.println(BankAccount.getAllAccountsInfo());

        BankAccount acct3 = new BankAccount();
        acct1.deposit(50.50, BankAccount.AccountType.checking);
        acct1.deposit(70.70, BankAccount.AccountType.savings);
        acct2.deposit(40.40, BankAccount.AccountType.checking);
        acct2.deposit(10.10, BankAccount.AccountType.savings);
        acct3.deposit(140.40, BankAccount.AccountType.checking);
        acct3.deposit(110.10, BankAccount.AccountType.savings);

        System.out.printf("\r\n\tAccount 1 - %s", acct1.toString());
        System.out.printf("\r\n\tAccount 2 - %s", acct2.toString());
        System.out.printf("\r\n\tAccount 3 - %s", acct3.toString());
        System.out.println(BankAccount.getAllAccountsInfo());

        acct1.withdraw(174.74, BankAccount.AccountType.checking);
        acct2.withdraw(771.71, BankAccount.AccountType.savings);
        acct3.withdraw(200.00, BankAccount.AccountType.checking);

        System.out.printf("\r\n\tAccount 1 - %s", acct1.toString());
        System.out.printf("\r\n\tAccount 2 - %s", acct2.toString());
        System.out.printf("\r\n\tAccount 3 - %s", acct3.toString());
        System.out.println(BankAccount.getAllAccountsInfo());
    }
}
