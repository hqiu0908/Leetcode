/*

The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it
returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that
reads n characters from the file.

Note: The read function will only be called once for each test case.

*/

public class ReadNCharactersGivenRead4 {    
    private int read4(char[] buffer) {
        // returns < 4 if eof
        return 4;
    }
    
    // read() will only be called once for each test case
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        // Total bytes have been read
        // Also the start index where to write the next byte
        int readBytes = 0;
        boolean eof = false;
        
        while(!eof && readBytes < n) {
            // Bytes read for each call
            int readSize = read4(buffer);
            
            // read4() returns < 4, means end of file
            if (readSize < 4) {
                eof = true;
            }
            
            // Not more than n bytes constraint
            int writeSize = Math.min(readSize, n - readBytes);
            System.out.println(writeSize);
            
            // System.arraycopy(src, srcPos, dest, destPos, length)
            System.arraycopy(buffer, 0, buf, readBytes, writeSize);

            readBytes += writeSize;
        }
        
        return readBytes;
    }
}

