import java.net.*;

public class AAA {
	InetAddress myServer = null;
	InetAddress myIPaddress = null;
	String domainName = null;

	public AAA (String domainName) {
		this.domainName = domainName;
	}

	public InetAddress getServerIP () {
		try {
			myServer = InetAddress.getByName (domainName);
		} catch (UnknownHostException e) {
		}
		return (myServer);
	}

	// 取得LOCALHOST的IP地址
	public InetAddress getMyIP () {
		try {
			myIPaddress = InetAddress.getLocalHost ();
		} catch (UnknownHostException e) {
		}
		return (myIPaddress);
	}

	public static void main (String[] args) {
		AAA pdn = new AAA ("google.com");
		System.out.println ("Your host IP is: " + pdn.getMyIP ().getHostAddress ());
		System.out.println ("The Server IP is :" + pdn.getServerIP ().getHostAddress ());
	}
}