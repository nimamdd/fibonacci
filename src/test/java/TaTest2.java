import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TaTest2 {

    private ByteArrayOutputStream outStream;

    public static int fibonacci(int n){
        if (n==0) return 0;
        if (n==1 || n==2) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static String ExpectedOutput(List<Integer> inputList) {
        StringBuilder sb = new StringBuilder();
        int x = inputList.get(0);

        int ans = fibonacci(x);
        sb.append(ans);

        return sb.toString().trim();
    }

    public static List<Integer> generateRandomTestNumbers() {
        Random random = new Random();
        List<Integer> input = new ArrayList<>();
        int testCount = random.nextInt(20) + 10;

        input.add(testCount);

        return input;
    }

    public void baseTest(List<Integer> inputList, String correctResult) {
        Process p;

        try {
            StringBuilder inputBuilder = new StringBuilder();
            for (int num : inputList) {
                inputBuilder.append(num).append("\\n");
            }

            if (inputBuilder.length() >= 2) {
                inputBuilder.setLength(inputBuilder.length() - 2);
            }

            String echoInput = "echo -e \"" + inputBuilder.toString() + "\"";
            String fullCmd = echoInput + " | java -jar lib/rars.jar nc src/main/java/solution.s";

            String[] cmd = {"/bin/bash", "-c", fullCmd};

            p = Runtime.getRuntime().exec(cmd);
            p.waitFor();

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String result = br.readLine().trim();
            br.close();

            assertEquals(correctResult, result);
            p.destroy();

        } catch (Exception e) {
            System.err.println("Execution error: " + e.getMessage());
            fail();
        }
    }

    @Before
    public void initStreams() {
        outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
    }

    @Test
    public void test2() {
        List<Integer> input = generateRandomTestNumbers();
        String correctOutput = ExpectedOutput(input);
        baseTest(input, correctOutput);
    }
}
