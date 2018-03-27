package Word;

import java.io.*;
import java.lang.String;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import  java.lang.Integer;
import java.util.Arrays;


import static java.lang.String.format;

public class MCrypto {

    private final static String _ALPHA = "MNBVCXZLKJHGFDSAPOIUYTREWQITISITLΌĲΆΎΈАБВГГШЁЖЗИЙКЮМНОМКЕФТКПКРЕВОЛЮЦИЯМЕФИМПОНǱѴ";
    private final static String _BETA = "QAZWSXEDCRFVTGBYHNUJMIKOLPLONGCODΌĲŨŇΈƉБВГТЕРХЬЭЙЛГМВЬМКГРАПЛКМЬЬЪЫЬЭЮЯМЕФИПТОФǱѴ";
    private final static String _OMEGA = "QWERTYUIOPASDFGHJKLZXCVBNMALPHACOŒĿΆΎΈАБВГДЕЁЖЗИПКАЛИТЩЕЩЕРФХЦЧШЩЪЫЬЭЮМОРДОРЯПТǱѴ";
    private final static String ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ¶,.!?1234567890()ABCDEFGHIJKLMNOPQRSTUVWXYZ@&*:;";

    private final static String[] dict = {_ALPHA, _BETA, _OMEGA};
    private static String De;
    private static String DeTrust1;
    private static String inTrust;
    private static String s;
    private static int code;
    private static int onooff;
    private static String code1;
    private static String def_text;
    private static String text2;
    private static String text21;
    private static int NoO;


    public static String Encrypt(String def_text1) throws IOException {

        System.out.println("Введите значение");
        System.out.print("> ");
        BufferedReader HH211 = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
        NoO = Integer.parseInt(HH211.readLine());
       def_text = def_text1.replace(' ', '¶');
        System.out.println("1 - шифровка | 2 - расшифровка");
        System.out.print("> ");
        BufferedReader HH = new BufferedReader(new InputStreamReader(System.in,"utf-8"));
       onooff = Integer.parseInt(HH.readLine());
        char[] chars = new char[0];
        if (onooff == 1) {
             chars = new char[def_text.length()];
            for (int j = 0; j < dict.length; j++) {
                for (int i = j; i < def_text.length(); i += 3) {
                    chars[i] = dict[j].toCharArray()[ALPHABET.indexOf(def_text.toUpperCase().toCharArray()[i])];
                }
            }

            for (char c : chars) {
                code = (int) c;
                code1 = format("%04X", code);
                s = "" + code1;
             //1   System.out.println(s);
                inTrust = s.replace("A", "78");
                String inTrust1 = inTrust.replace("E", "54");
                String inTrust2 = inTrust1.replace("C", "32");
                String inTrust3 = inTrust2.replace("F", "98");
                String inTrust4 = inTrust3.replace("D", "87");
                String inTrust5 = inTrust4.replace("J", "34");
                String inTrust6 = inTrust5.replace("L", "77");
                String inTrust7 = inTrust6.replace("Q", "92");
                String inTrust8 = inTrust7.replace("R", "11");
                String inTrust9 = inTrust8.replace("I", "45");
                String inTrust11 = inTrust9.replace("B", "39");
                Integer NumberOne = Integer.valueOf(inTrust11);
              //2  System.out.println(inTrust11);
                Integer No1 = NumberOne + NoO;
              //3  System.out.println(No1);
                String No2 = Integer.toString(No1, 2);
                System.out.print(Integer.toString(No1, 2) + " ");

            }

        }
        if (onooff == 2) {
         //   while (true) {
             //   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in,"utf-8"));
              //   String  str = reader.readLine();
                   String [] yp = def_text1.split(" ");
                for(int i =0; i<yp.length; i++) {
                   //System.out.print(Integer.parseInt(String.valueOf( yp[i]), 2) + " ");
                            String FTrust = Integer.parseInt(String.valueOf( yp[i]), 2) + "";
                    int dock = Integer.parseInt(FTrust) - NoO;
                    String word = "00" + String.valueOf(dock);
                  //  System.out.print(word);
                    int ThreeG = word.length();
                    if (ThreeG > 4) {
                        String roar = word.substring(3, ThreeG);
                        //  System.out.println(roar);
                        inTrust = roar.replace("78", "A");
                        String inTrust1 = inTrust.replace("54", "E");
                        String inTrust2 = inTrust1.replace("32", "C");
                        String inTrust3 = inTrust2.replace("98", "F");
                        String inTrust4 = inTrust3.replace("87", "D");
                        String inTrust5 = inTrust4.replace("34", "J");
                        String inTrust6 = inTrust5.replace("77", "L");
                        String inTrust7 = inTrust6.replace("92", "Q");
                        String inTrust8 = inTrust7.replace("11", "R");
                        String inTrust9 = inTrust8.replace("45", "I");
                        String inTrust11 = inTrust9.replace("39", "B");
                        String road = word.substring(0, 3) + inTrust11;
                      //  System.out.println(road + " ");
                        text2 = String.valueOf(Character.toChars(Integer.parseInt(road, 16)));
                        System.out.print(text2);

                    }
                    if (ThreeG < 4 || ThreeG == 4) {
                        text21 = String.valueOf(Character.toChars(Integer.parseInt(word, 16)));
                        System.out.print(text21);

                    }

                }
                System.out.println("|Скопируйте всё до начала этого текста и вставьте сюда:");
            BufferedReader HH21 = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
            String str2 = HH21.readLine();
            String str1 = str2;

            char[] ITISNOTREALY = new char[str1.length()];
            for (int j = 0; j < dict.length; j++) {
                for (int w = j; w < str1.length(); w += 3) {
                    ITISNOTREALY[w] = ALPHABET.toCharArray()[dict[j].indexOf(str1.toUpperCase().toCharArray()[w])];
                }
            }
            String DeCrypt = String.copyValueOf(ITISNOTREALY);
            De = DeCrypt.replace('¶', ' ');
            System.out.print(De);
             //   }
            }
        return "";

        }

    }
