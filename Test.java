package Word;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Test {
    public static void main(String[] args) throws IOException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeySpecException, InterruptedException {







        System.out.println("  ________            ___    __                 _ __  __                 ____                        \n" +
                " /_  __/ /_  ___     /   |  / /___ _____  _____(_) /_/ /_  ____ ___     / __ )_________  ____  __  __\n" +
                "  / / / __ \\/ _ \\   / /| | / / __ `/ __ \\/ ___/ / __/ __ \\/ __ `__ \\   / __  / ___/ __ \\/ __ \\/ / / /\n" +
                " / / / / / /  __/  / ___ |/ / /_/ / /_/ / /  / / /_/ / / / / / / / /  / /_/ / /  / /_/ / / / / /_/ / \n" +
                "/_/ /_/ /_/\\___/  /_/  |_/_/\\__, /\\____/_/  /_/\\__/_/ /_/_/ /_/ /_/  /_____/_/   \\____/_/ /_/\\__, /  \n" +
                "                           /____/                                                           /____/  ");
        System.out.println("  ___  _                            _____   _____         \n" +
                " / _ \\| |                     _    |  __ \\ / ____|  /\\    \n" +
                "| (_) | | _____ _   _ ___   _| |_  | |__) | (___   /  \\   \n" +
                " \\__, | |/ / _ \\ | | / __| |_   _| |  _  / \\___ \\ / /\\ \\  \n" +
                "   / /|   <  __/ |_| \\__ \\   |_|   | | \\ \\ ____) / ____ \\ \n" +
                "  /_/ |_|\\_\\___|\\__, |___/         |_|  \\_\\_____/_/    \\_\\\n" +
                "                 __/ |             Created by EdT.                            \n" +
                "                |___/                                  ");

        System.out.println("");
            System.out.println("Введите текст для шифровки/расшифровки");
            System.out.print("> ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
            String str = "";
            String strWord = "";
            try {

                str = reader.readLine();

                // strWord = str.replace(' ', '¶');
                // System.out.println(strWord);
            } catch (IOException e) {
                e.printStackTrace();
            }

        String t = MCrypto.Encrypt(str);
        String r = MCrypto.Decrypt(str);
        System.out.println(t);
        System.out.println(MCrypto.Decrypt(t));


    }
    }


