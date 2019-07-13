import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class BankAccount {
    private static int numberOfAccounts;
    private static double accountsTotal;
    private String acctNumber;
    private double checkingBalance;
    private double savingsBalance;

    BankAccount() {
        BankAccount.numberOfAccounts++;
        acctNumber = getRandomAccountNumber();
        checkingBalance = savingsBalance = 0.0;
    }

    @Contract(pure = true)
    static int getNumberOfAccounts() { return numberOfAccounts; }

    @Contract(pure = true)
    static double getAccountsTotal() { return accountsTotal; }

    static String getAllAccountsInfo() {
        return String.format("\r\n\tNumber of accounts: %d\r\n\tTotal balance: %.2f\r\n\r\n",
                numberOfAccounts, accountsTotal);
    }

    @NotNull
    private String getRandomAccountNumber() {
        StringBuilder retVal = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            retVal.append(new Random().nextInt(10));
        }
        return retVal.toString();
    }

    String getAcctNumber() { return acctNumber; }

    public double getCheckingBalance() { return checkingBalance; }

    public double getSavingsBalance() { return savingsBalance; }

    double deposit(double amount, @NotNull AccountType account){
        double retVal = 0;
        switch(account) {
            case savings:
                savingsBalance += amount;
                accountsTotal += amount;
                retVal = savingsBalance;
                break;
            case checking:
                checkingBalance += amount;
                accountsTotal += amount;
                retVal = checkingBalance;
                break;
        }
        return retVal;
    }

    private void nsf() {
        System.out.println("\r\n\r\n\r\n\tInsufficient Funds!\r\n\r\n\r\n");
    }

    double withdraw(double amount, @NotNull AccountType account){
        double retVal = 0;
        switch(account) {
            case savings:
                if (savingsBalance > amount) {
                    savingsBalance -= amount;
                    accountsTotal -= amount;
                } else nsf();
                retVal = savingsBalance;
                break;
            case checking:
                if (checkingBalance > amount) {
                    checkingBalance -= amount;
                    accountsTotal -= amount;
                } else nsf();
                retVal = checkingBalance;
                break;
        }
        return retVal;
    }

    @Override
    public String toString() {
        return String.format("\r\n\tAcct #: %s" +
                "\r\n\tChecking: %.2f" +
                "\r\n\tSaving: %.2f\r\n\r\n",
                this.getAcctNumber(), this.getCheckingBalance(), this.getSavingsBalance());
    }

    public enum AccountType {checking, savings }
}
