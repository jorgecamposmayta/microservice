package org.devsu.domain.service;

import org.devsu.application.dto.TypeMovementDTO;
import org.devsu.domain.exception.AccountInsufficientBalanceException;
import org.devsu.domain.exception.AccountNotFoundException;
import org.devsu.domain.service.constant.Constant;

import java.math.BigDecimal;
public class MovementServiceDomain {
    public static BigDecimal caculateAvailableBalance(BigDecimal InitialBalance, BigDecimal valueMovement){
        return InitialBalance.add(valueMovement);
    }

    public static TypeMovementDTO calculateTypeMovement(BigDecimal valueMovement){
        if (valueMovement.signum()<=0){
            return TypeMovementDTO.builder()
                    .id(Constant.TYPE_MOVEMENT_WITHDRAWAL_VALUE)
                    .description(Constant.TYPE_MOVEMENT_WITHDRAWAL)
                    .build();
        }else if(valueMovement.signum()>=0){
            return TypeMovementDTO.builder()
                    .id(Constant.TYPE_MOVEMENT_DEPOSIT_VALUE)
                    .description(Constant.TYPE_MOVEMENT_DEPOSIT)
                    .build();
        }
        throw new AccountNotFoundException(Constant.MOVEMENT_VALUE_NOT_FOUND_FOR_OPERATION.concat(" - VALUE OPERATION: ")+valueMovement);
    }
    public static void validateBalance(String typeMovement,BigDecimal balance, BigDecimal valueMovement){
        if (balance.signum()==0 && typeMovement.equals(Constant.TYPE_MOVEMENT_WITHDRAWAL_VALUE)){
            throw new AccountInsufficientBalanceException(Constant.ACCOUNT_INSUFFICIENT_BALANCE.concat(" - BALANCE: ")+balance);
        } else if (balance.add(valueMovement).signum()<0) {
            throw new AccountInsufficientBalanceException(Constant.ACCOUNT_INSUFFICIENT_BALANCE.concat(" - ( BALANCE: ")+balance+" ) - ( VALUE-MOVEMENT: "+valueMovement +" = "+balance.add(valueMovement));
        }

    }

}
