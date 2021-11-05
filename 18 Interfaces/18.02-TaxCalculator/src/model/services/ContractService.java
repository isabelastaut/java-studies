package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService; // declarando o tipo interface para inverter controle
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService; // injetando a dependencia do onlinePaymentService
	}
	
	public void processContract(Contract contract, int months) {
		double monthlyValue = contract.getTotalValue() / months;
		for (int i = 1; i<= months; i++) {
			double quota = monthlyValue + onlinePaymentService.interest(monthlyValue, i);
			double fullQuota = quota + onlinePaymentService.paymentFee(quota); 
			
			Date dueDate = addMonths(contract.getDate(), i);
			contract.getInstallments().add(new Installment(dueDate, fullQuota));
		}

	}
	
	private Date addMonths(Date date, int N) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, N);
		return calendar.getTime();
	}
	

}
