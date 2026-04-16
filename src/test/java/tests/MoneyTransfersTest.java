package tests;

import org.testng.annotations.Test;
import pojo.MoneyTransferSystem;
import steps.StepsMoneyTransfers;

import java.util.List;


public class MoneyTransfersTest  {
    @Test
    public void getMoneyTransferSystemsStatusCodeTest() {
        StepsMoneyTransfers steps = new StepsMoneyTransfers();

        List<MoneyTransferSystem> systems = steps
                .moneyTransfersApi()
                .deserializedTransfers()
                .getMoneyTransferSystems();


    }}