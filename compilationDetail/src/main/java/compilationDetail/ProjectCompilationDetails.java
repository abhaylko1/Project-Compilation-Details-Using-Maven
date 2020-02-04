package compilationDetail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import javax.servlet.ServletContext;

public class ProjectCompilationDetails {

	public Map<String, String> getDetails(ServletContext servletContext) {
		Map<String, String> details = new HashMap<String, String>();
		// JarFile file;
		Manifest manifest = new Manifest();
		try {
			// file = new JarFile(
			// "compilationDetail-0.0.1-SNAPSHOT.war");
			manifest = new Manifest(servletContext.getResourceAsStream("/META-INF/MANIFEST.MF"));
		} catch (IOException e) {
			System.out.println("Couldn't read manifest.");
			e.printStackTrace();
		}
		Attributes attributes = manifest.getMainAttributes();
		String impBuiltBy = attributes.getValue("Built-By");
		String impBuiltTime = attributes.getValue("Build-Time");
		String impHostName = attributes.getValue("Host-Name");
		String implBuildJdk = attributes.getValue("Build-Jdk");
		if (impBuiltBy != null) {
			details.put("Built-By", impBuiltBy);
		}
		if (impBuiltTime != null) {
			details.put("Build-Time", impBuiltTime);
		}
		if (impHostName != null) {
			details.put("Host-Name", impHostName);
		}
		if (implBuildJdk != null) {
			details.put("Build-Jdk", implBuildJdk);
		}
		return details;
	}

}
