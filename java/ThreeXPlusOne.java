import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ThreeXPlusOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();

        System.out.println("Enter your Password : ");
        String password = sc.nextLine();

        // System.out.println("Enter your Rotation no. : ");
        // int n = sc.nextInt();

        sc.close();

        int passwordLength = password.length();

        if (passwordLength == 0) {
            System.out.println("You have entered an empty password");
        } else if (passwordLength < 8) {
            System.out.println("Your password is too short");
        } else {
            int x = passwordLength;
            int highestPossible = 0;
            int highestPoint = 0;
            while (x != 4) {

                if (x % 2 == 0) {
                    if (x > highestPossible) {
                        highestPossible = x;
                        highestPoint = highestPoint + 1;
                    }
                    x = x / 2;

                } else if (x % 2 != 0) {
                    if (x > highestPossible) {
                        highestPossible = x;
                        highestPoint = highestPoint + 1;
                    }
                    x = (x * 3) + 1;

                }
            }
            System.out.println("Your password has " + highestPossible + " as Highest Possible No which was reached at  " + highestPoint
                    + " Step.");

            for (int i = 0; i < highestPossible; i++) {
                int j;
                char last;
                last = arr[arr.length - 1];
                for (j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = last;
            }

            try {
                System.out.println("Enc generated : " + ThreeXPlusOne
                        .bytesToHex(ThreeXPlusOne.getSHA(ThreeXPlusOne.bytesToHex(ThreeXPlusOne.getSHA(password))
                                + ThreeXPlusOne.bytesToHex(ThreeXPlusOne.getSHA(Integer.toString(highestPoint)))
                                + ThreeXPlusOne.bytesToHex(ThreeXPlusOne.getSHA(Integer.toString(highestPossible))))));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

        }

    }

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}