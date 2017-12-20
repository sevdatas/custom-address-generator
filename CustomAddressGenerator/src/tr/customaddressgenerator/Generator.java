package tr.customaddressgenerator;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.params.MainNetParams;

public class Generator extends Thread {
	public int id;

	public Generator(int _id) {
		this.id = _id;
	}

	public void run() {
		String addressString = "";
		String keyString = null;

		while (!this.control(addressString)) {
			ECKey key = new ECKey();
			Address address = new Address(MainNetParams.get(), key.getPubKeyHash());
			keyString = key.getPrivateKeyAsWiF(MainNetParams.get());
			addressString = address.toBase58();
			if (Parameter.stop) {
				return;
			}
		}
		System.out.println(String.valueOf(keyString.concat(" ").concat(addressString)));
		Parameter.stop = true;
	}

	public boolean control(String value) {
		for (String param : Parameter.list) {
			if (value.startsWith(param)) {
				return true;
			}
		}
		return false;
	}
}
