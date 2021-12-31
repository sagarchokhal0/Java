ZIP File Streams
ZIP files are archives that store one or more files in (usually) compressed format.
 Java 1.1 can handle both GZIP and ZIP format.
In this section we concentrate on the more familiar (but somewhat more complicated) 
ZIP format and leave the GZIP classes to you if you need them. (They work in much the same way.)
Java graphics notes_icon

The Classes for handling ZIP files are in java.util.zip and not in java.io, 
so remember to add the necessary import statement. Although not part of java.io,
 the GZIP and ZIP classes subclass java.io.FilterInputStream and java.io.FilterOutputStream.
 The java.util.zip packages also contain classes for computing cyclic redundancy check (CRC) checksums.
 (CRC is a method to generate a hashlike code that the receiver of a file can use to check the integrity of the data.)
Each ZIP file has a header with information such as the name of the file and the compression method that was used. 
In Java, you use a ZipInputStream to read a ZIP file by layering the ZipInputStream constructor onto a FileInputStream.
 You then need to look at the individual entries in the archive.
 The getNextEntry method returns an object of type ZipEntry that describes the entry.
 The read method of the ZipInputStream is modified to return -1 at the end of the current entry
 (instead of just at the end of the ZIP file). You must then call closeEntry to read the next entry.
 Here is a typical code sequence to read through a ZIP file:

ZipInputStream zin = new ZipInputStream
 (new FileInputStream(zipname));
ZipEntry entry;
while ((entry = zin.getNextEntry()) != null)
{
 analyze entry;
 read the contents of zin;
 zin.closeEntry();
}
zin.close();
To read the contents of a ZIP entry, you will probably not want to use the raw read method;
 usually, you will use the methods of a more competent stream filter.
 For example, to read a text file inside a ZIP file, you can use the following loop:

BufferedReader in = new BufferedReader
 (new InputStreamReader(zin));
String s;
while ((s = in.readLine()) != null)
 do something with s;
The program in Example 12-1 lets you open a ZIP file.
 It then displays the files stored in the ZIP archive in the list box at the top of the screen.
 If you double-click on one of the files, the contents of the file are displayed in the text area, 