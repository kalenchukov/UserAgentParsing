package dev.kalenchukov.tests;

import java.io.*;

class Package
{
	public static void main(String[] args)
	{
//		String str = "hello +world!+ wor + ld";
//
//		str = str.replaceAll("(\s+)?-(\s+)?", "-");
//
//		System.out.println(str);
//		System.exit(0);


		UserAgentParsing userAgentParser = new UserAgentParser();

		FileReader fileReader = null;
		FileWriter fileWriterY = null;
		FileWriter fileWriterN = null;
		FileWriter fileWriterModel = null;

		try
		{
			fileReader = new FileReader(System.getProperty("user.dir") + "/src/tests/resources/all");
			fileWriterY = new FileWriter(System.getProperty("user.dir") + "/src/tests/resources/mobile_yes", true);
			fileWriterN = new FileWriter(System.getProperty("user.dir") + "/src/tests/resources/mobile_not", true);
			fileWriterModel = new FileWriter(System.getProperty("user.dir") + "/src/tests/resources/mobile_model", true);

			BufferedReader reader = new BufferedReader(fileReader);

			String line = reader.readLine();

			while (line != null)
			{
				userAgentParser.setUserAgent(line);
				//System.out.println(userAgentParser.getDeviceType());
				if (userAgentParser.getDeviceType() != null &&
					(
						userAgentParser.getDeviceType().equals("Mobile") ||
						userAgentParser.getDeviceType().equals("Tablet")
					)
				)
				{
					String model = userAgentParser.getDeviceModel();

					//System.out.println(userAgentParser.getDeviceModel());
					if (model != null)
					{
						fileWriterModel.write(model + "\n");
						fileWriterY.write(line + "\n");
					}
					else
					{
						fileWriterN.write(line + "\n");
					}

				}

				line = reader.readLine();
			}

//			do
//			{
//				line = reader.readLine();
//
//				userAgentParser.setUserAgent(line);
//
//				if (userAgentParser.getDeviceType() != null)
//				{
//					fileWriter.write(line);
//				}
//			}
//			while (line != null);

			fileReader.close();
			fileWriterY.close();
			fileWriterN.close();
			fileWriterModel.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
