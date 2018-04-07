package Word;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;

public class MCrypto {

    private final static String _ALPHA =   "ЙКЛМТУФZYXWVUTSRQ5BAАБ:;,ГДЕЁВХPONMLK678НОПРСDCJI90ȐȔȜ@&*ЖЗȞHGFEИ4ЦЧШЩЪЫЬЭЮЯ123ȠŒ";
    private final static String _BETA =    "JIHGFEDCЭЮЯ12ZYXWRQPOШЩЪЧОПР67890ȐȔȜ@&BAАБВСТУЫЬМНNMLK345ГДЕЁЖЗИЙКЛХЦФ*:;,ȞȠŒVUTS";
    private final static String _OMEGA =   "ZYXSR8Ȝ@;,QPONЫЬЭK&*:JIHMLУФГХAАБЮЯ12345WVUT67ЦЧШЩ90ȐȔЪGFEDCBȞȠŒВДЕЁЖЗИЙКЛМНОПРСТ";
    private final static String ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ .!?1234567890()ABCDEFGHIJKLMNOPQRSTUVWXYZ@&*:;,";
    private final static String[] dict = {_ALPHA, _BETA, _OMEGA};

    private final static String _ALPHA1 =   "WVUTSRQ5678ԘОПРԊȐȔСDCBВХPϒNMLKJIǊАБ:;,ɌДЕЁЯ129ЙКYXЭЮ3ЛМТУФZȜ@&*ЖЗȞHGFEИ4ЦΔШԖҤЫЬȠŒ";
    private final static String _BETA1 =    "ԘОПРСDCBǊАБ:;,ɌДЕЁВХ5MLKJIЙКЛМТУФZYXWVUTȔȜ@&*SRQЭЮЯ6789ԊȐЖЗȞHGFN1EИ4ЦΔШԖҤЫЬPϒ23ȠŒ";
    private final static String _OMEGA1 =   "ZYXWVUTSRQЖЗȞ8KJI9Ԋ3ȠԘОПРСDCЙКЛМТУФBǊАБ:ȐȔȜ@&*ЮЯ12;,ɌДЕЁВХPϒHGFEИ4ЦΔШԖҤЫЬЭ567NMLŒ";
    private final static String ALPHABET1 = "ZYXSRQPONЫЬЭK&*:JIHMLУФГХЦЧШЩ90ȐȔЪGFEDCBAАБЮЯ12345WVUT678Ȝ@;,ȞȠŒВДЕЁЖЗИЙКЛМНОПРСТ";
    private final static String[] dict1 = {_ALPHA1, _BETA1, _OMEGA1};

    private final static String _ALPHA2 =   "ХЦЧОПР67ШЩЪЫȜ@&*:;WRQPOMLKႴ45ГDCЭЮЯ12ZYXБВСТУФЬ90ȐДЕЁЖЗ,ȞȠŒVUBAАМНN8JIHGFEȔИЙКЛTS";
    private final static String _BETA2 =    "МНNMLKႴ45ГДЕЁЖЗИЙКЛХЦЧОПР678JIHGFEDCЭЮЯ12ZYXWRQPOШЩЪЫЬ90ȐȔȜ@&BAАБВСТУФ*:;,ȞȠŒVUTS";
    private final static String _OMEGA2 =   "Ȝ@;,ȞȠŒВДЕЁЖЗИЙКK&*:JIЛМНОПРСТZЬЭHMLУФГХЦЧШЩ90ȐȔЪGYXSRQPONЫFEDCBAАБЮЯ12Ⴔ45WVUT678";
    private final static String ALPHABET2 = "ЙКЛМТУФZYXWVUTSRQ5678ԘОПРСDCBǊАБ:;,ɌДЕЁВХPϒNMLKJI9ԊȐȔȜ@&*ЖЗȞHGFEИ4ЦΔШԖҤЫЬЭЮЯ123ȠŒ";
    private final static String[] dict2 = {_ALPHA2, _BETA2, _OMEGA2};
  static int str;
    public static String Encrypt(String def_text) throws NoSuchAlgorithmException,
            NoSuchPaddingException,
            InvalidKeyException,
            IllegalBlockSizeException,
            BadPaddingException, IOException, InvalidAlgorithmParameterException, InvalidKeySpecException, InterruptedException {

        System.out.println("1 - Шифровка, 2 - Расшифровка, 3 - Создать новые ключи");
        System.out.print(">");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
        str = Integer.parseInt(reader.readLine());
        if (str == 1) {
            String def_text1 = def_text + "(StringTest)";
            char[] chars = new char[def_text1.length()];
            for (int j = 0; j < dict.length; j++) {
                for (int i = j; i < def_text1.length(); i += 3) {
                    chars[i] = dict[j].toCharArray()[ALPHABET.indexOf(def_text1.toUpperCase().toCharArray()[i])];
                }
            }
            String oneCode = String.copyValueOf(chars);


            char[] chars2 = new char[oneCode.length()];
            for (int j = 0; j < dict1.length; j++) {
                for (int i = j; i < oneCode.length(); i += 3) {
                    chars2[i] = dict1[j].toCharArray()[ALPHABET1.indexOf(oneCode.toUpperCase().toCharArray()[i])];
                }
            }
            String twoCode = String.copyValueOf(chars2);
            // System.out.println(twoCode);


            char[] chars3 = new char[twoCode.length()];
            for (int j = 0; j < dict2.length; j++) {
                for (int i = j; i < twoCode.length(); i += 3) {
                    chars3[i] = dict2[j].toCharArray()[ALPHABET2.indexOf(twoCode.toUpperCase().toCharArray()[i])];
                }
            }
            String threeCode = String.copyValueOf(chars3);
           // System.out.println(threeCode);



            KeyFactory kf = KeyFactory.getInstance("RSA");
            BufferedReader brony = new BufferedReader( new FileReader("Private_m.txt"));
            String line = brony.readLine();
            BigInteger BronyLove = new BigInteger(line);

            BufferedReader pr_x1 = new BufferedReader( new FileReader("Private_x.txt"));
            String R2D2 = pr_x1.readLine();
            BigInteger pr_x2 = new BigInteger(R2D2);



            BufferedReader pb_m = new BufferedReader( new FileReader("Public_m.txt"));
            String pb_m1 = pb_m.readLine();
            BigInteger pub_m2 = new BigInteger(pb_m1);

            BufferedReader pb_x1 = new BufferedReader( new FileReader("Public_x.txt"));
            String R2D21 = pb_x1.readLine();
            BigInteger pub_x2 = new BigInteger(R2D21);

            BufferedReader pub = new BufferedReader( new FileReader("PublicTRUE.txt"));
            String R2D2pub = pub.readLine();
            // BigInteger pubStar = new BigInteger(R2D2pub);


            // Востанавливаем ключ из полученных ранее BigInteger-ов.
            RSAPrivateKeySpec new_prks = new RSAPrivateKeySpec(BronyLove, pr_x2);
            RSAPublicKeySpec new_pubks = new RSAPublicKeySpec(pub_m2, pub_x2);
            PrivateKey new_private = kf.generatePrivate(new_prks);
            PublicKey new_public = kf.generatePublic(new_pubks);
            //PublicKey new_pubks1 = (PublicKey) R2D2pub;
            Cipher c = Cipher.getInstance("RSA");
            // Шифруем оригинальным ключом.
            c.init(Cipher.ENCRYPT_MODE, new_public);
            byte [] encrypted = c.doFinal(threeCode.getBytes());
            System.out.println(Arrays.toString(encrypted));
            StringSelection stringSelection = new StringSelection(Arrays.toString(encrypted));
            Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            clpbrd.setContents(stringSelection, null);
            System.out.print("Сообщение скопированно в буфер обмена.");
            Thread.sleep(9999999);
        }
        return "";
        }


    public static String Decrypt(String enc_text) throws NoSuchAlgorithmException, IOException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InterruptedException {

        if (str == 2) {

            String response = "[-99, 16, -42, -59, -118, 64, 76, -17, -21, 106, -86, 26, 103, -74, 94, 25, -76, -105, -36, -35, -103, 11, 60, 103, -29, -65, -115, 97, 53, 98, -120, -105, -91, 80, 71, -94, -108, -20, -23, 82, -49, -31, -61, -118, -107, 56, -9, 101, 40, 124, -22, 50, -22, 28, -109, -48, 37, 70, -54, 55, -59, -19, 89, -103, 100, 102, -26, 51, 26, -98, -61, 100, -53, 67, -88, -22, -101, -17, -87, 67, 6, 114, -10, -43, 90, -120, 61, 90, 7, 80, 54, 49, 8, -3, 108, -72, 15, 52, -57, -80, -91, 110, -80, -44, 93, -75, -111, 12, 82, -67, -68, -82, 122, -83, -9, -30, 61, -85, 80, -106, 98, 15, 23, -97, -3, 58, -77, 21, 49, -35, -81, -110, -35, -49, 111, 71, -125, 38, 8, -39, 51, -77, 6, 20, 56, 40, -15, -89, 22, -7, -116, -101, -117, 96, 70, 70, 42, 101, -104, 108, -27, -58, -29, -36, -16, -45, 114, 99, -105, 101, 72, 108, 50, 40, 96, 91, -98, -37, 127, 21, 88, 115, 86, -83, 100, 10, 103, -16, 84, -29, -80, -96, -64, 81, -119, 51, -51, 51, 19, -29, 27, 26, 124, -74, 54, -70, 125, -76, 42, -107, -12, -64, 44, -121, -120, -4, 75, 98, -72, -109, -84, 110, 73, 102, -89, -28, -15, 35, -65, -49, 12, 43, -43, -84, 51, 102, -47, -52, 73, 99, -56, 3, -23, -106, 55, -109, 39, 60, -25, 23, 73, 118, 57, 112, -32, 62]";
            String[] byteValues = enc_text.substring(1, enc_text.length() - 1).split(",");
            byte[] bytes = new byte[byteValues.length];

            for (int i=0, len=bytes.length; i<len; i++) {
                bytes[i] = Byte.parseByte(byteValues[i].trim());
            }

            String str = new String(bytes);
            //System.out.print(str);
        Cipher c = Cipher.getInstance("RSA");
        KeyFactory kf = KeyFactory.getInstance("RSA");
        BufferedReader brony = new BufferedReader( new FileReader("Private_m.txt"));
        String line = brony.readLine();
        BigInteger BronyLove = new BigInteger(line);

        BufferedReader pr_x1 = new BufferedReader( new FileReader("Private_x.txt"));
        String R2D2 = pr_x1.readLine();
        BigInteger pr_x2 = new BigInteger(R2D2);


        BufferedReader pb_m = new BufferedReader( new FileReader("Public_m.txt"));
        String pb_m1 = pb_m.readLine();
        BigInteger pub_m2 = new BigInteger(pb_m1);

        BufferedReader pb_x1 = new BufferedReader( new FileReader("Public_x.txt"));
        String R2D21 = pb_x1.readLine();
        BigInteger pub_x2 = new BigInteger(R2D21);

        BufferedReader pub = new BufferedReader( new FileReader("PublicTRUE.txt"));
        String R2D2pub = pub.readLine();
        // BigInteger pubStar = new BigInteger(R2D2pub);


        // Востанавливаем ключ из полученных ранее BigInteger-ов.
        RSAPrivateKeySpec new_prks = new RSAPrivateKeySpec(BronyLove, pr_x2);
        RSAPublicKeySpec new_pubks = new RSAPublicKeySpec(pub_m2, pub_x2);
        PrivateKey new_private = kf.generatePrivate(new_prks);
        PublicKey new_public = kf.generatePublic(new_pubks);
//          byte [] encrypted = {Byte.parseByte(enc_text)};
        c.init(Cipher.DECRYPT_MODE, new_private);
        byte [] decrypted = c.doFinal(bytes);

        String s = new String(decrypted);

          //  System.out.println(s);



            char[] chars = new char[s.length()];
            for (int j = 0; j < dict2.length; j++) {
                for (int i = j; i < s.length(); i += 3) {
                    chars[i] = ALPHABET2.toCharArray()[dict2[j].indexOf(s.toUpperCase().toCharArray()[i])];
                }
            }

            String oneCode = String.copyValueOf(chars);

            char[] chars1 = new char[oneCode.length()];
            for (int j = 0; j < dict1.length; j++) {
                for (int i = j; i < oneCode.length(); i += 3) {
                    chars1[i] = ALPHABET1.toCharArray()[dict1[j].indexOf(oneCode.toUpperCase().toCharArray()[i])];
                }
                //   System.out.println(String.copyValueOf(chars1));
            }
            String twoCode = String.copyValueOf(chars1);
            char[] chars2 = new char[twoCode.length()];
            for (int j = 0; j < dict.length; j++) {
                for (int i = j; i < twoCode.length(); i += 3) {
                    chars2[i] = ALPHABET.toCharArray()[dict[j].indexOf(twoCode.toUpperCase().toCharArray()[i])];
                }

            }
         int programsignature = String.copyValueOf(chars2).length();
            String ProgramSignature = String.copyValueOf(chars2).substring(programsignature - 12, programsignature);
            if (ProgramSignature.equals("(STRINGTEST)") == true) {
                System.out.println(String.copyValueOf(chars2).replace("(STRINGTEST)", ""));
                StringSelection stringSelection = new StringSelection(String.copyValueOf(chars2).replace("(STRINGTEST)", ""));
                Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                clpbrd.setContents(stringSelection, null);
                System.out.print("Сообщение скопированно в буфер обмена.");
                Thread.sleep(9999999);
            }
            if (ProgramSignature.equals("(STRINGTEST)") == false) {
                System.out.println("Проверка на подлинность была не пройдена!");
                System.out.print("Это сообщение было подделанно!");
                System.out.println(String.copyValueOf(chars2));
                StringSelection stringSelection = new StringSelection(String.copyValueOf(chars2));
                Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                clpbrd.setContents(stringSelection, null);
                System.out.print("Сообщение скопированно в буфер обмена.");
                Thread.sleep(9999999);
            }
        }

        if (str == 3) {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(4096);
            KeyPair kpair = kpg.genKeyPair();

            PrivateKey privateKey = kpair.getPrivate();
            PublicKey publicKey = kpair.getPublic();
            Writer wr4 = new FileWriter("PublicTRUE.txt");
            wr4.write(String.valueOf(publicKey));
            wr4.close();
            // "Разбираем" RSA ключи.
            KeyFactory kf = KeyFactory.getInstance("RSA");

            RSAPrivateKeySpec prks = kf.getKeySpec(privateKey, RSAPrivateKeySpec.class);
            // Достачно знать эти 2 числа, чтобы востановить секретный ключ. Сохранять нужно их.
            BigInteger pr_m = prks.getModulus();
            BigInteger pr_x = prks.getPrivateExponent();
            // System.out.print(pr_m);
            //  System.out.print(pr_m);
            Writer wr = new FileWriter("Private_m.txt");
            wr.write(String.valueOf(pr_m));
            wr.close();
            Writer wr1 = new FileWriter("Private_x.txt");
            wr1.write(String.valueOf(pr_x));
            wr1.close();

            RSAPublicKeySpec pubks =  kf.getKeySpec(publicKey, RSAPublicKeySpec.class);
            // Достачно знать эти 2 числа, чтобы востановить открытый ключ. Сохранять нужно их.
            BigInteger pub_m = pubks.getModulus();
            BigInteger pub_x = pubks.getPublicExponent();
            Writer wr2 = new FileWriter("Public_m.txt");
            wr2.write(String.valueOf(pub_m));
            wr2.close();
            Writer wr3 = new FileWriter("Public_x.txt");
            wr3.write(String.valueOf(pub_x));
            wr3.close();
            //System.console().readLine();
        }
        return "";

        }
    }


















