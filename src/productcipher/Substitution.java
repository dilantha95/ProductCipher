/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productcipher;

import java.util.ArrayList;

/**
 *
 * @author Dilantha
 */
public class Substitution {
    private String[] input;
    private String[] key;
    String x, y, z;
	
    private ArrayList<String> temp;
	
    protected String encrypt(String input, String key){
        this.input = input.split("");
        this.key = key.split("");
        temp = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            x = Integer.toBinaryString(input.charAt(i) + key.charAt(i % key.length()));
            y = x.substring(0, x.length() / 2);
            z = x.substring(x.length() / 2, x.length());
            temp.add(Character.toString((char) (Integer.parseInt(y, 2) + 65)));
            temp.add(Character.toString((char) (Integer.parseInt(z, 2) + 65)));
        }
        return String.join("", temp);
    }
	
    protected String decrypt(String input, String key){
        this.input = input.split("");
        this.key = key.split("");
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<String> temp2 = new ArrayList<>();
        for(int i = 1; i < input.length(); i = i + 2) {
            x = Integer.toBinaryString(input.charAt(i) - 65);
            int t = 4 - x.length();
            for (int k = 0; k < t; k++) {
                x = "0" + x;
            }
            y = Integer.toBinaryString(input.charAt(i - 1) - 65);
            t = 4 - y.length();
            for (int k = 0; k < t; k++) {
                y = "0" + y;
            }
            z = y + x;
            temp1.add(Integer.parseInt(z, 2));
        }
        for(int i = 0; i < temp1.size(); i++) {
            temp2.add(Character.toString((char) (temp1.get(i) - key.charAt(i % key.length()))));
        }
        return String.join("", temp2);
    }
}
