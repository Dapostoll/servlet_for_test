package service.test;

import com.hillel.dao.AccountDao;
import com.hillel.dto.AccountDto;
import com.hillel.entity.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountDao accountDao;

    private Account account = new Account();

    @BeforeEach
    private void accountInitialization() {
        account.setId(1);
        account.setClientId(1);
        account.setNumber("1234 8800 5555 3535");
        account.setValue(14.88);
        when(accountDao.findAllAccounts()).thenReturn(Collections.singletonList(account));
    }

    @Test
    public void findAllAccountsListCheckBySizeCorrectValueTest() {
        List<AccountDto> actualList = accountService.findAllAccounts();

        assertTrue(actualList.size() == 1);
    }
}
