package child.parent;

import java.io.File;

import java.util.Arrays;

import java.util.List;

import java.util.stream.Collectors;

public class RenameFilesToParentFolders

{

	static void RecursivePrint(File[] arr, int index, int level)

	{

		// terminate condition

		if (index == arr.length)

			return;

		// tabs for internal levels

		for (int i = 0; i < level; i++)

			System.out.print("\t");

		// for files and not directory

		if (arr[index].isFile()) {

			// System.out.println(arr[index].getParentFile().getName() + ":" +
			// arr[index].getName());

			File f = new File(arr[index].getParentFile() + "\\" + arr[index].getName());

			// String fileExt = FilenameUtils.getExtension(f.getName());

			String fileExt = getFileExtension(f);

			System.out.println("file Extension :" + fileExt);

			// f.renameTo(new File(arr[index].getParentFile() + "\\" +
			// arr[index].getParentFile().getName()+ "_" );

			String newName = arr[index].getParentFile().getName() + "_" + (index + 1) + fileExt;

			f.renameTo(new File(arr[index].getParentFile() + "\\" + newName));

			// System.out.println("newName :" + newName );

		}

		// for sub-directories

		else if (arr[index].isDirectory())

		{

			// System.out.println("[" + arr[index].getName() + "]");

			// recursion for sub-directories

			RecursivePrint(arr[index].listFiles(), 0, level + 1);

		}

		// recursion for main directory

		RecursivePrint(arr, ++index, level);

	}

	private static String getFileExtension(File file) {

		String extension = "";

		try {

			if (file != null && file.exists()) {

				String name = file.getName();

				extension = name.substring(name.lastIndexOf("."));

			}

		} catch (Exception e) {

			extension = "";

		}

		return extension;

	}

	public static void main(String[] args)

	{

		// String replaceAll = "PRODUCT-TYPE~1".replaceAll("~", " ");

		// System.out.println("rwar");

		File maindir = new File("C:\\Users\\yogis\\Pictures\\Images");

		// String maindirpath = "C:\\Users\\Gaurav Miglani\\Desktop\\Test";

		// File object

		// File maindir = new File(maindirpath);

		if (maindir.exists() && maindir.isDirectory())

		{

			// array for files and sub-directories

			// of directory pointed by maindir

			File arr[] = maindir.listFiles();

			System.out.println("**********************************************");

			System.out.println("Files from main directory : " + maindir);

			System.out.println("**********************************************");

			// Calling recursive method

			RecursivePrint(arr, 0, 0);

		}

	}

}