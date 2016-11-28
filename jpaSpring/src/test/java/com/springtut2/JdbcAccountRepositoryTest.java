package com.springtut2;

import com.springtut2.entities.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.number.BigDecimalCloseTo.closeTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.springtut2.config.AppConfig.class)
@Transactional
@ActiveProfiles({"prod", "test"})
public class JdbcAccountRepositoryTest {

    @Autowired
    private com.springtut2.repositories.AccountRepository repository;

    @Test
    public void testGetAccounts() throws Exception {
        List<com.springtut2.entities.Account> accounts = repository.getAccounts();
        System.err.println(accounts.size());
        assertThat(accounts.size(), is(3));
    }


    @Test
    public void testGetAccount() throws Exception {
        Account account = repository.getAccount(1L);
        assertThat(account.getId(), is(1L));
        assertThat(new BigDecimal("100.0"),
                is(closeTo(account.getBalance(), new BigDecimal("0.01"))));
    }


    @Test
    public void testGetNumberOfAccounts() throws Exception {
        assertThat(repository.getNumberOfAccounts(), is(3));
    }

    @Test
    public void testCreateAccount() throws Exception {
        Long id = repository.createAccount(new BigDecimal("250.00"));
        assertThat(id, is(notNullValue()));

        Account account = repository.getAccount(id);
        assertThat(account.getId(), is(id));
        assertThat(account.getBalance(), is(closeTo(new BigDecimal("250.0"),
                new BigDecimal("0.01"))));
    }

    @Test
    public void testUpdateAccount() throws Exception {
        Account account = repository.getAccount(1L);
        BigDecimal current = account.getBalance();
        BigDecimal amount = new BigDecimal("50.0");
        account.setBalance(current.add(amount));
        repository.updateAccount(account);

        Account again = repository.getAccount(1L);
        assertThat(again.getBalance(), is(closeTo(current.add(amount),
                new BigDecimal("0.01"))));
    }

    @Test
    public void testDeleteAccount() throws Exception {
        for (Account account : repository.getAccounts()) {
            repository.deleteAccount(account.getId());
        }
        assertThat(repository.getNumberOfAccounts(), is(0));
    }

}
