package com.aurionpro.model;

public class Beneficiary {

	private int beneficiary_id;
	private String bankName;
	private String beneficiaryName;
	public Beneficiary(String bankName, String beneficiaryName) {
		super();
		this.bankName = bankName;
		this.beneficiaryName = beneficiaryName;
	}
	public int getBeneficiary_id() {
		return beneficiary_id;
	}
	public String getBankName() {
		return bankName;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiary_id(int beneficiary_id) {
		this.beneficiary_id = beneficiary_id;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	
	
}
