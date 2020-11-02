import java.io.*;

class RemoveClassFiles {

	public static void main(String[] args) throws Exception {

		checkAllFiles(args[0]);
	}


	public static void checkAllFiles(String name) throws Exception {

		File file = new File(name);

		File[] allFiles = file.list();

		for (int i = 0; i < allFiles.length; i++) {

			if (allFiles[i].isDirectory()) checkAllFiles(name + "/" + allFiles[i]);
			else if (pes.endsWith(".class")) {
				// and deletes
				boolean success = (new File(allFiles[i]).delete());
			}
		}
	}
}