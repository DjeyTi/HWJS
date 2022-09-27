public class check {
    
    public static void main(String[] args) {
        checking("a+(d*3)");
        checking("[a+(1*3)");
        checking("[6+(3*3)]");
        checking("{a}[+]{(d*3)}");
        checking("<{a}+{(d*3)}>");
        checking("{a+]}{(d*3)}");
    }   
    
    public static void checking(String args) {
        char[] list = args.toCharArray();
        int answer = 0;
        for (int i = 0; i < list.length; i++) {
            switch (list[i]) {
                case '(':
                    for (int j = 0; j < list.length; j++)
                        if (list[j] == ')') {
                            answer = j;
                            j = list.length;
                        } else {
                            answer = -1;
                        }
                    if (answer == -1) {
                        System.out.println("Error");
                        return;
                    } else {
                        list[i] = '.';
                        list[answer] = '.';
                    }
                    break;
                case '[':
                    for (int j = 0; j < list.length; j++)
                        if (list[j] == ']') {
                            answer = j;
                            j = list.length;
                        } else {
                            answer = -1;
                        }
                    if (answer == -1) {
                        System.out.println("Error");
                        return;
                    } else {
                        list[i] = '.';
                        list[answer] = '.';
                    }
                    break;
                case '{':
                    for (int j = 0; j < list.length; j++)
                        if (list[j] == '}') {
                            answer = j;
                            j = list.length;
                        } else {
                            answer = -1;
                        }
                    if (answer == -1) {
                        System.out.println("Error");
                        return;
                    } else {
                        list[i] = '.';
                        list[answer] = '.';
                    }
                    break;
                case '<':
                    for (int j = 0; j < list.length; j++)
                        if (list[j] == '>') {
                            answer = j;
                            j = list.length;
                        } else {
                            answer = -1;
                        }
                    if (answer == -1) {
                        System.out.println("Error");
                        return;
                    } else {
                        list[i] = '.';
                        list[answer] = '.';
                    }
                    break;
            }
            if (i == list.length - 1) {
                System.out.println("True");
                return;
            }
            if (list[i] == ')' || list[i] == ']' || list[i] == '}' || list[i] == '>') {
                System.out.println("Error");
                return;
            }
        }
    }
}
