public class Testing {
    public static void main(String[] args) {
        String message = "EHIJ";
        String newmessage = "";
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == 'A' || message.charAt(i) == 'E' || message.charAt(i) == 'I' || message.charAt(i) == 'O' || message.charAt(i) == 'U' || message.charAt(i) == 'Y') {
                newmessage = newmessage + "OB" + message.charAt(i);
            }
            else {
                newmessage = newmessage + message.charAt(i);
            }
        }
        System.out.println(newmessage);
    }}