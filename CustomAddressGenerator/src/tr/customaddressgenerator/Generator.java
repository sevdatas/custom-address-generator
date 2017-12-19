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
		while (!addressString.startsWith("1Must") && !addressString.startsWith("1MUST")) {
			ECKey key = new ECKey();
			Address address = new Address(MainNetParams.get(), key.getPubKeyHash());
			keyString = key.getPrivateKeyAsWiF(MainNetParams.get());
			addressString = address.toBase58();
			
		}
		System.out.println(String.valueOf(this.id).concat(" ").concat(keyString.concat(" ").concat(addressString)));
	}
}
