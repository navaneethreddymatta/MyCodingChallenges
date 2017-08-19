package nav.twitter;

public class AcmeRotation {
    public static void main(String[] args) {
        System.out.println("baabccd");
    }

    /*static int minRotate(String inscription) {
        /*String currentString = inscription;
        String minString = inscription;

        long counter = 0;
        long stringLength = inscription.length();
        /*for(long i=1; i<stringLength; i++) {
            currentString = currentString + currentString.substring(0,1);
            currentString = currentString.substring(1);
            if(isCurrentStrSmall(minString, currentString)) {
                minString = currentString;
                counter = i;
            }
        }
        return (int)counter;
        final ThreadResult t1 = new ThreadResult();
        ThreadResult t2;
        ThreadResult t3;

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String currentString = inscription;
                String minStr = inscription;
                long start = 0;
                long end = (long) Math.floor(stringLength / 3);
                long counter = start;
                for (long i = start; i < end; i++) {
                    currentString = currentString + currentString.substring(0, 1);
                    currentString = currentString.substring(1);
                    if (isCurrentStrSmall(minStr, currentString)) {
                        minStr = currentString;
                        counter = i;
                    }
                }
                t1[0] = new ThreadResult(minStr, counter);
            }
        });

        thread1.start();

    }


    static boolean isCurrentStrSmall(String minStr, String currStr) {
        System.out.println("Min - " + minStr + "---Cur - " + currStr);
        for(int i=0; i<minStr.length(); i++) {
            if(currStr.charAt(i) < minStr.charAt(i)) {
                System.out.println(i+"====="+currStr.charAt(i) + "---" + minStr.charAt(i));
                System.out.println("returnin true at i = " + i);
                return true;
            } else if(currStr.charAt(i) > minStr.charAt(i)){
                return false;
            }
        }
        System.out.println("returnin false");
        return false;
    }

    static class ThreadResult {
        private String inscription;
        private long counter;

        public ThreadResult(String inscription, long counter) {
            this.inscription = inscription;
            this.counter = counter;
        }

        public String getInscription() {
            return inscription;
        }

        public long getCounter() {
            return counter;
        }
    }*/
}
