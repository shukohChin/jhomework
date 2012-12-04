package ch22.ex22_08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Ex22_08 {
	static final int CELLS = 4;

	public static List<String[]> readCSVTable(Readable source) throws IOException {
        Scanner in = new Scanner(source);
        List<String[]> vals = new ArrayList<String[]>();
        String exp = "^(.*),(.*),(.*),(.*)";
        Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
        while (in.hasNext()) {
            String line = in.findInLine(pat);
            if (line != null) {
                String[] cells = new String[CELLS];
                MatchResult match = in.match();
                for (int i = 0; i < CELLS; i++)
                    cells[i] = match.group(i + 1);
                vals.add(cells);
                in.nextLine();
            } else {
                throw new IOException("input format error");
            }
        }

        IOException ex = in.ioException();
        if (ex != null)
            throw ex;

        return vals;
    }
}
