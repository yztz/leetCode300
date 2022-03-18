package s52;

public class Bank {
    long[] balance;
    public Bank(long[] balance) {
        this.balance = balance;
    }

    private boolean isValidUser(int account) {
        int n = balance.length;
        return account >= 1 && account <= n;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!isValidUser(account1) || !isValidUser(account2)) return false;
        if (money > balance[account1 - 1]) return false;
        balance[account2 - 1] += money;
        balance[account1 - 1] -= money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!isValidUser(account)) return false;
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!isValidUser(account) || money > balance[account - 1]) return false;
        balance[account - 1] -= money;
        return true;
    }
}
