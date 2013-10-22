package licinv;

import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InventoryReader {

	public static void main(String args[]) {
		String s = null;

		String cmd = "lsmon localhost";
		//File workDir = new File(System.getProperty("user.dir"));

		try {
			Process p = Runtime.getRuntime().exec(cmd);
			int i = p.waitFor();
			if (i == 0) {
				BufferedReader stdInput = new BufferedReader(
						new InputStreamReader(p.getInputStream()));
				while ((s = stdInput.readLine()) != null) {
					System.out.println(s);
				}
			} else {
				BufferedReader stdErr = new BufferedReader(
						new InputStreamReader(p.getErrorStream()));
				while ((s = stdErr.readLine()) != null) {
					System.out.println(s);
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
