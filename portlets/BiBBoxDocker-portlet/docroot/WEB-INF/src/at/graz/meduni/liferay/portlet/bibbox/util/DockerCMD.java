package at.graz.meduni.liferay.portlet.bibbox.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DockerCMD {
	
	String[] dockerpsarray = {"CONTAINERID", "IMAGE", "COMMAND", "CREATED", "STATUS", "PORTS", "NAME"};
	
	public String test() {
		String command = "echo $USER";
		String output = executeCommand(command);
		System.out.println(output);
		command = "whoami";
		output = executeCommand(command);
		System.out.println(output);
		return output;
	}
	
	public String dockerPs(boolean all) {
		String command = "docker ps";
		if(all) {
			command += " -a";
		}
		
		String output = "";
		try {
			Process p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			boolean first = true;
			String splitter = "";
			while ((line = reader.readLine())!= null) {
				if(first) {
					first = false;
					continue;
				}
				output += splitter + "{";
				String[] fields = line.split("([^\\S\\r\\n]{2,})");
				int fieldcounter = 0;
				String fieldsplitter = "";
				for(String field : fields) {
					if(fieldcounter == 5 && !field.contains("->")) {
						fieldcounter++;
					} else {
						field = field.replaceAll("0\\.0\\.0\\.0:", "");
					}
					output += fieldsplitter + "\"" + dockerpsarray[fieldcounter] + "\":\"" + field.replaceAll("\"", "") + "\"";
					fieldsplitter = ",";
					fieldcounter++;
				}
				output += "}";
				splitter = ",";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println(output);
		return output;
	}
	
	public String ping() {
		
		String domainName = "google.com";
		
		//in mac oxs
		String command = "ping -c 3 " + domainName;
		
		//in windows
		//String command = "ping -n 3 " + domainName;
		
		String output = executeCommand(command);

		System.out.println(output);
		return output;
	}
	
	private String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

                        String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}
}
