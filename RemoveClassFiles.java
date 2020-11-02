import java.io.*;

class RemoveClassFiles {

	public static void main(String[] args) throws Exception {

		checkAllFiles(args[0]);
	}


	public static void checkAllFiles(String name) throws Exception {

		File file = new File(name);

		for (File allFiles : file.listFiles()) {

			String fileName = allFiles.getName();

			if (allFiles.isDirectory()) checkAllFiles(name + "/" + fileName);
			else if (fileName.endsWith(".class")) {
				// and deletes
				boolean success = allFiles.delete();
			}
		}
	}
}