package job4j.bank;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MoneyTest {
    @Test
    public void whenAddUserAndAccount() {
        Money bank = new Money();
        User user1 = new User("Никита", "1111");
        User user2 = new User("Влад", "2222");
        Account acc1 = new Account(1000, "a1");
        Account acc2 = new Account(5000, "b1");
        Account acc11 = new Account(2500, "a2");
        bank.addUser(user1);
        bank.addAccountToUser(user1.getPasspot(), acc1);
        bank.addAccountToUser(user1.getPasspot(), acc11);
        bank.addAccountToUser(user2.getPasspot(), acc2);
        boolean flag = bank.transferMoney(user2.getPasspot(), acc2.getRequisites(), user1.getPasspot(), acc11.getRequisites(), 1500);
        assertThat(acc2.getValue(), is(3500));
        assertThat(flag, is(true));
    }
}
