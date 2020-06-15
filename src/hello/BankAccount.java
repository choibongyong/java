package hello;

import java.text.NumberFormat;
import java.util.Locale;

public class BankAccount {
	private String mAccount;
	private String mAccountHolder;
	private int mAmount;

	public BankAccount(String account, String holder, int amount) {
		mAccount = account;
		mAccountHolder = holder;
		mAmount = amount;
	}

	public boolean deposit(int amount) {
		if (!isPositiveAmount(amount)) return false;
		
		mAmount += amount;

		String strFormat = "%s �� �Ա��մϴ�.%n";
		System.out.printf(strFormat, convertToDecimalFormat(amount));

		printAmount();
		
		return true;
	}

	public boolean withDraw(int amount) {
		if (!isPositiveAmount(amount)) return false;
		if (!canWithdraw(amount)) return false;
		
		mAmount -= amount;

		String strFormat = "%s �� ����մϴ�.%n";
		System.out.printf(strFormat, convertToDecimalFormat(amount));

		printAmount();
		return true;
	}

	private void printAmount() {
		String strFormat = "�ܾ�: %s ��%n";
		System.out.printf(strFormat, convertToDecimalFormat(mAmount));
	}

	public void printStatus() {
		String strFormat = "���� %s (������:%s)%n�ܾ�: %s ��%n";
		System.out.printf(strFormat, mAccount, mAccountHolder, convertToDecimalFormat(mAmount));
	}
	
	private boolean isPositiveAmount(int amount)
	{
		if (amount < 0) {
			System.out.println("[����] �ݾ��� ������ �Է��� �� �����ϴ�.");
			return false;
		}
		
		return true;
	}
	
	private boolean canWithdraw(int amount)
	{
		if (mAmount - amount < 0) {
			System.out.println("�����޽��� : [����] �ܾ��� �����մϴ�.");
			return false;
		}
		
		return true;
	}
	
	private String convertToDecimalFormat(int amount) {
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.KOREA);
		nf.setMaximumFractionDigits(3);
		return nf.format(amount);
	}
}