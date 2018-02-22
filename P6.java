/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class P6 {
    public String convert(String s, int numRows) {
        StringBuilder[] builders = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        int index = 0;
        boolean flag = true;
        char[] array = s.toCharArray();
        for(char ch: array) {
            builders[index].append(ch);
            if (flag && index < numRows-1)
                index++;
            else if (!flag && index > 0)
                index--;
            if(index==0 && !flag)
                flag = true;
            else if(index==numRows-1)
                flag = false;
        }

        String result = "";
        for(StringBuilder builder: builders) {
            result += builder;
        }
        return result;
    }

    public static void main(String[] args) {
        P6 solution = new P6();
        System.out.println(solution.convert("paypalishiring", 3));
    }
}