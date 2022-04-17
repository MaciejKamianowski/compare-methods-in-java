package kamski.mac;

public class CreditCard {
	private String provider;
	private int creditLimit;
	private int fee;

	public CreditCard(String provider, int creditLimit, int fee) {
		this.provider = provider;
		this.creditLimit = creditLimit;
		this.fee = fee;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public int getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	@Override

	public String toString() {
		return String.format(provider + ": " + creditLimit + ":" + fee);
	}

}
