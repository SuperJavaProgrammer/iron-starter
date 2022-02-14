package com.ironbank.moneyraven.controller;

import com.ironbank.moneyraven.dao.MoneyDao;
import com.ironbank.moneyraven.service.TransferMoneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@RestController
@RequiredArgsConstructor
public class IronBankController {
  private final TransferMoneyService transferMoney;
  private final MoneyDao moneyDao;

  @GetMapping("/credit")
  public String credit(@RequestParam String name, @RequestParam long amount) { //пример запроса http://localhost:8080/credit?name=Targarian&amount=100
    long resultedDeposit = transferMoney.transfer(name, amount);
    if (resultedDeposit == -1) { //кредит не одобрен
      return "Rejected<br/>" + name + " <b>won't</b> survive this winter";
    }
    return format("<i>Credit approved for %s</i> <br/>Current  bank balance: <b>%s</b>", name, resultedDeposit);
  }

  @GetMapping("/state")
  public long currentState() {
    return moneyDao.findAll().get(0).getTotalAmount();
  }
}
