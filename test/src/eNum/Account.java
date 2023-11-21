package eNum;

public class Account {
	private String accountNo;	//口座番号
	private int zandaka;		//預金残高
	private AccountType accountType;	//口座種類

	public void setAccountNo(String accountNo) { this.accountNo = accountNo; }
	public String getAccountNo() { return this.accountNo; }
	public void setZandaka(int zandaka) { this.zandaka = zandaka; }
	public int getZandaka() { return this.zandaka; }
	public void setAccountType(AccountType accountType) { this.accountType = accountType; }
	public AccountType getAccountType() { return this.accountType; }

	public Account(String accountNo, AccountType accountType) {
		this.accountNo = accountNo;
		this.accountType = accountType;
	}

	public String toString() {
		return "口座番号:" + accountNo + "\n預金残高:" + zandaka + "円\n口座種類:" + accountType;
	}


}
