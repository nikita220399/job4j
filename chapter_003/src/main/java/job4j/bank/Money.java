package job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Money {
    private HashMap<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        this.users.put(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.users.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        for (User user : this.users.keySet()) {
            if (user.getPasspot().equals(passport)) {
                this.users.get(user).add(account);
                break;
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (User user : this.users.keySet()) {
            if (user.getPasspot().equals(passport)) {
                this.users.get(user).remove(account);
                break;
            }
        }
    }

    public List<Account> getUserAccounts (String passport) {
        List<Account> bank = new ArrayList<>();
        for (User user : this.users.keySet()) {
            if (user.getPasspot().equals(passport)) {
                bank = this.users.get(user);
                break;
            }
        }
        return bank;
    }

    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String destRequisite, int amount) {
        boolean flag = false;
        Account chet1 = null;
        Account chet2 = null;
        for (User user : this.users.keySet()) {
            if (user.getPasspot().equals(srcPassport)) {
                for (Account acc : this.users.get(user)) {
                    if (acc.getRequisites().equals(srcRequisite)) {
                        chet1 = acc;
                    }
                }
            }
            if (user.getPasspot().equals(destPassport)) {
                for (Account acc : this.users.get(user)) {
                    if (acc.getRequisites().equals(destRequisite)) {
                        chet2 = acc;
                    }
                }
            }
        }
        if (chet1.getValue() >= amount && chet1 != null && chet2 != null) {
            chet1.setValue(chet1.getValue() - amount);
            chet2.setValue(chet2.getValue() + amount);
            flag = true;
        }
        return flag;
    }
}
