package com.hrp.rabbitmq.consumer;

import com.hrp.rabbitmq.model.ModelRegisterManager;
import com.hrp.rabbitmq.model.ModelTurnAllAdvancePaymentRequest;
import com.hrp.rabbitmq.model.ModelTurnAllExpenseRequest;
import com.hrp.rabbitmq.model.ModelTurnAllLeaveRequest;
import com.hrp.service.ManagerService;
import com.hrp.utility.StaticValues;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Consumer {
    private final ManagerService managerService;

    @RabbitListener(queues = "queue-register-manager")
    public void registerCompanyManager(ModelRegisterManager model){
        managerService.createManager(model);
    }

    @RabbitListener(queues = "queue-turnallleave-employee")
    public void turnAllLeaveRequest(List<ModelTurnAllLeaveRequest> model){
        StaticValues.findAllLeave = model;
    }

    @RabbitListener(queues = "queue-turnallexpense-employee")
    public void turnAllExpenseRequest(List<ModelTurnAllExpenseRequest> model){
        StaticValues.findAllExpense = model;
    }

    @RabbitListener(queues = "queue-turnalladvancepayment-employee")
    public void turnAllAdvancePaymentRequest(List<ModelTurnAllAdvancePaymentRequest> model){
        StaticValues.findAllAdvancePayment = model;
    }









}