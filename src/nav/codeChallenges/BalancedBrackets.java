package nav.codeChallenges;

public class BalancedBrackets {
    public static void main(String[] args) {
        int[] result = balancedOrNot(new String[]{"<<<><><>"}, new int[]{2});
        for(int i: result) {
            System.out.println(i);
        }
    }

    static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
        int[] result = new int[expressions.length];
        for(int i = 0; i < expressions.length; i++) {
            String expression = expressions[i];
            expression = expression.replaceAll("[^\\<\\>]","");
            while(expression.length() != (expression.replaceAll("\\<\\>","")).length()) {
                expression = expression.replaceAll("\\<\\>","");
            }
            if(expression.isEmpty()) {
                result[i] = 1;
            } else if (expression.endsWith("<")) {
                result[i] = 0;
            } else {
                if(expression.length() <= maxReplacements[i]) {
                    result[i] = 1;
                } else {
                    result[i] = 0;
                }
            }
        }
        return result;
    }
}
