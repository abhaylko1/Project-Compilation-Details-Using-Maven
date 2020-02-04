package compilationDetail;

import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class packageVersion {
	void printVersion() throws IOException {
		try {
			JarFile file = new JarFile(
					"../compilationDetail/target/compilationDetail-0.0.1-SNAPSHOT.war");
			Manifest manifest = file.getManifest();
			Attributes attributes = manifest.getMainAttributes();

			// String impTitle = attributes.getValue("Implementation-Title");
			// String impVersion =
			// attributes.getValue("Implementation-Version");
			// String impBuildDate = attributes.getValue("Built-Date");
			String impBuiltBy = attributes.getValue("Built-By");
			String impBuiltTime = attributes.getValue("Build-Time");
			String impHostName = attributes.getValue("Host-Name");

			// if (impTitle != null) {
			// System.out.println("Implementation-Title: " + impTitle);
			// }
			// if (impVersion != null) {
			// System.out.println("Implementation-Version: " + impVersion);
			// }
			// if (impBuildDate != null) {
			// System.out.println("Built-Date: " + impBuildDate);
			// }
			if (impBuiltBy != null) {
				System.out.println("Built-By:   " + impBuiltBy);
			}
			if (impBuiltTime != null) {
				System.out.println("Build-Time:   " + impBuiltTime);
			}
			if (impHostName != null) {
				System.out.println("Host-Name:   " + impHostName);
			}
			System.exit(0);

		} catch (IOException e) {
			System.out.println("Couldn't read manifest.");
		}
		System.out.println("**********End*************");

	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		packageVersion version = new packageVersion();
		System.out.println("Details : ");
		version.printVersion();
	}

}