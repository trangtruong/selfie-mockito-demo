package phone;

import java.util.ArrayList;
import java.util.List;

public class Client {
	List<Phone> phones = new ArrayList<>();

	public void addPhone(Phone phone) {
		this.phones.add(phone);
	}

	public boolean hasMobile() {
		for (Phone phone : phones) {
			if (phone.isMobile()) {
				return true;
			}
		}

		return false;
	}
}
