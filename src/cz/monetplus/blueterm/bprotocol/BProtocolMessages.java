package cz.monetplus.blueterm.bprotocol;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BProtocolMessages {

	public static byte[] getAppInfo(String terminalId) {

		BProtocol bprotocol = new BProtocol("B1", "01", terminalId,
				getCurrentDateTimeForHeader(), "    ", "A5A5");

		bprotocol.getTagMap().put(BProtocolTag.TransactionType, "80");

		BProtocolFactory factory = new BProtocolFactory();

		return factory.serialize(bprotocol);
	}

	public static byte[] getSale(String terminalId, int amount,
			String invoiceNumber) {

		BProtocol bprotocol = new BProtocol("B1", "01", terminalId,
				getCurrentDateTimeForHeader(), "0000", "A5A5");

		bprotocol.getTagMap().put(BProtocolTag.TransactionType, "00");
		bprotocol.getTagMap().put(BProtocolTag.Amount1, String.valueOf(amount));
		bprotocol.getTagMap().put(BProtocolTag.CurrencyCode2,
				String.valueOf(203));
		bprotocol.getTagMap().put(BProtocolTag.InvoiceNumber, invoiceNumber);

		BProtocolFactory factory = new BProtocolFactory();

		return factory.serialize(bprotocol);
	}

	public static byte[] getHanshake(String terminalId) {

		BProtocol bprotocol = new BProtocol("B1", "01", terminalId,
				getCurrentDateTimeForHeader(), "0000", "A5A5");

		bprotocol.getTagMap().put(BProtocolTag.TransactionType, "95");

		BProtocolFactory factory = new BProtocolFactory();

		return factory.serialize(bprotocol);
	}

	private static String getCurrentDateTimeForHeader() {
		SimpleDateFormat formater = new SimpleDateFormat("yyMMddHHmmss");
		return formater.format(new Date());

	}
}
