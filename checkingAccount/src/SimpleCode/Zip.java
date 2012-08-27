package SimpleCode;

import java.io.IOException;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;

//Przyk³ad zastosowania kowariantnych typów zwracanych wartoœci
class Zip {
	ZipFile getArchive(String name) throws IOException
	{
		return new ZipFile(name);
	}
}

class Jar extends Zip
{
	@Override JarFile getArchive(String name) throws IOException
	{
		return new JarFile(name);
	}
}

class Archive
{
	public static void main(String[] args) throws IOException
	{
		if (args.length == 2 && args[0].equals("-zip"))
		{
			ZipFile zf = new Zip().getArchive(args[1]);
		}
		else
		if (args.length == 2 && args[0].equals("-jar"))
		{
			JarFile jf = new Jar().getArchive(args[1]);
		}
	}
}
