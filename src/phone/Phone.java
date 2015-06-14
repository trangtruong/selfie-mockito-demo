package phone;

public class Phone {

	private boolean mobile;
	private String number;

	public Phone(String anyNumber, boolean isMobile) {
		this.mobile = isMobile;
	}

	public Phone(String number) {
		this.number = number;
		this.mobile = number.startsWith("+") && number.endsWith("9");
	}

	public boolean isMobile() {
		return mobile;
	}

}
