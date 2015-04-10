class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        // interleace[i][j] represents s1(0, i) + s2(0, j) -> s3(0, i + j - 1)
        vector<vector<bool> > interleave(s1.length() + 1, vector<bool>(s2.length() + 1));
        
        // initialization
        interleave[0][0] = true;
        // first column, only compose s3 with s1
        for (int i = 1; i <= s1.length(); i++) {
            interleave[i][0] = interleave[i - 1][0] && s1[i - 1] == s3[i - 1];
        }
        // first row, only compose s3 with s2
        for (int i = 1; i <= s2.length(); i++) {
            interleave[0][i] = interleave[0][i - 1] && s2[i - 1] == s3[i - 1];
        }
        
        // f[i][j] = (f[i - 1][j] && s1[i - 1] == s3[i + j - 1]) || (f[i][j - 1] && s2[j - 1] == s3[i + j - 1])
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                interleave[i][j] = (interleave[i - 1][j] && s1[i - 1] == s3[i + j - 1]) 
                || (interleave[i][j - 1] && s2[j - 1] == s3[i + j - 1]);
            }
        }
        
        return interleave[s1.length()][s2.length()];
    }
};
