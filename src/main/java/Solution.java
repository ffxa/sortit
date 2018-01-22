import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Неверное количество входных параметров");
        } else {
            String inFile = args[0];
            String outFile = args[1];
            String dataType = args[2];
            String sortOrder = args[3];

            try {
                List lines = getDataFromInFile(inFile, dataType);
                if ("-a".equals(sortOrder)) {
                    sort(lines);
                } else if ("-d".equals(sortOrder)) {
                    sort(lines);
                    Collections.reverse(lines);
                } else {
                    throw new Exception("Unsupported sort ordering: " + sortOrder);
                }
                write(lines, outFile);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //Write array to file
    private static void write(List lines, String outFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))) {
            for (Object o : lines) {
                writer.write(String.valueOf(o) + "\n");
            }
            writer.flush();
        }
    }

    //Inserting sort
    private static void sort(List lines) throws Exception {
        for (int i = 1; i < lines.size(); i++) {
            Object x = lines.get(i);
            int j = i;
            while (j > 0 && compare(lines.get(j - 1), x) >= 0) {
                lines.set(j, lines.get(j - 1));
                j = j - 1;
            }
            lines.set(j, x);
        }
    }

    //Compare two Object
    @SuppressWarnings("unchecked")
    private static int compare(Object line, Object x) {
        return ((Comparable) line).compareTo(x);
    }

    //Read lines from file to List
    private static List<Object> getDataFromInFile(String path, String dataType) throws IOException, NoSuchFieldException {
        List<Object> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            switch (dataType) {
                case "-i":
                    String s = null;
                    while(reader.ready()) {
                        try {
                            s = reader.readLine();
                            Integer num = Integer.parseInt(s);
                            list.add(num);
                        } catch (NumberFormatException e) {
                            throw new IOException("Invalid input data: [" + s + "] is not Integer");
                        }
                    }
                    break;
                case "-s":
                    while(reader.ready()) {
                        list.add(reader.readLine());
                    }
                    break;
                default:
                    throw new NoSuchFieldException("Unsupported data conversion type: " + dataType);
            }
        }

        return list;
    }
}
