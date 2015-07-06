/*

Similar to Question [15. Read N Characters Given Read4], but the read function
may be called multiple times.

*/

public class ReadNCharactersGivenRead4CallMultiTimes {
    private char[] buffer = new char[4];
    
    // Keep track of where the data begins in the next read call
    int offset = 0;
    
    // Real buffer size that stores actual data
    // If bufsize > 0, there is partial data left in buffer from
    // the last read call and we should consume it before calling
    // read4 again!!! If bufsize == 0, no data left
    int bufsize = 0;
    
    private int read4(char[] buffer) {
        return 4;
    }
    
    // read() will be called multiple times
    public int read(char[] buf, int n) {
        // Total bytes have been read
        int readBytes = 0;
        boolean eof = false;
        
        while(!eof && readBytes < n) {
            // Bytes read for each call
            // Should check if there is data left from previous read4()
            int readSize = (bufsize > 0) ? bufsize : read4(buffer);

            if (bufsize == 0 && readSize < 4) {
                eof = true;
            }
            
            // Not more than n bytes constraint
            int writeSize = Math.min(readSize, n - readBytes);
            
            // System.arraycopy(src, srcPos, dest, destPos, length)
            System.arraycopy(buffer, offset, buf, readBytes, writeSize);
            
            offset = (offset + writeSize) % 4;
            bufsize = readSize - writeSize;
            // offset = (bufsize == 0)? 0 : writeSize + 1;
            readBytes += writeSize;
        }
        
        return readBytes;
    }
}

