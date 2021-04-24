package com.cg.ova.service;

public class BillServiceImpl {

	private IBillDAO billdaoR;

	public BillServiceI() {
		billdaoR = new BilldaoRI();
	}
	
	public boolean isValidBillId(int billId) {
		return billId > 0;
	}
	
	public boolean isValidOrder(viewOrderBycustomerId order){
		return order.getOrderId()>0;
	}

	public boolean isValidBillDate(LocalDateTime billDate) {
		return billDate != null && billDate.isBefore(LocalDateTime.now());
	}

	public boolean isValidTotalCost(BigDecimal viewBill) {
		return totalCost !=null ;
	}

	public boolean isValidBill(Bill bill) throws OFDAException{

		List<String> errorMesseges = new ArrayList<>();
		boolean isValid = true;
		if (bill != null) {
			if (!isValidBillId(bill.getBillId())) {
				isValid = false;
				errorMesseges.add("bill id cannot be blank and must be a positive number");
			}
			if (!isValidOrder(bill.getviewOrderBycustomerId())) {
				isValid = false;
				errorMesseges.add("Order must be Valid");
			}
			if (!isValidTotalItem(bill.getTotalItem())) {
				isValid = false;
				errorMesseges.add("Total item cannot be blank and must be a positive number");
			}
			if (!isValidBillDate(bill.getBillDate())) {
				isValid = false;
				errorMesseges.add("Bill Date cannot be blank and must not be a future date");
			}
			if (!isValidTotalCost(bill.getTotalCost())) {
				isValid = false;
				errorMesseges.add("Bill Date cannot be blank and must not be a future date");
			}
			if (!errorMesseges.isEmpty()) {
				System.out.println("Invalid bill : " + errorMesseges);
			}

		} 
		else {
			isValid = false;
			throw new OFDAException("Contact details are not supplied");
		}
		return isValid;
	}

	@Override
	public Bill addBill(Bill bill) throws OFDAException {
		
		if (isValidBill(bill)) {
			billdaoR.addBill(bill);
		}
		return bill;
	}


	@Override
	public Bill updateBill(Bill bill) throws OFDAException {
		
		if (isValidBill(bill)) {
			billRepository.updateBill(bill);
		}
		return bill;
	}


	@Override
	public Bill viewBill(Bill bill) throws OFDAException{
		return billRepository.viewBill(bill);
	}

	@Override
	public List<Bill> viewBills(LocalDate startDate, LocalDate endDate) throws OFDAException {
		return billRepository.viewBills(startDate, endDate);
	}

	@Override
	public List<Bill> viewBills(String custId) throws OFDAException {
		return billRepository.viewBills(custId);
	}


}
