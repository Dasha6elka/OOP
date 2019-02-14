package lab1.task2;

class Binary {
    private Binary() {
    }

    static int bin2dec(String binary) {
        int result = 0;
        int len = binary.length();

        if (len > 31) {
            System.out.println("Maximum length exceeded");
            return len;
        }
        for (int i = 0; i < len; i++) {
            result += Math.pow(2, len - 1 - i) * (binary.charAt(i) == '1' ? 1 : 0);
        }

        return result;
    }

    static boolean verify(String binary) {
        for (int i = 0; i < binary.length(); i++) {
            char ch = binary.charAt(i);
            if (ch != '0' && ch != '1') {
                return false;
            }
        }
        return true;
    }
}
