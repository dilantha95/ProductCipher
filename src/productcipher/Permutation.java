/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productcipher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Dilantha
 */
public class Permutation {
    protected String encrypt(String plain, String keyin){
        ArrayList<String[]> list = new ArrayList<>();
        String[] text = plain.split("");
        for (int i = 0; i < plain.length(); i = i + keyin.length()) {
            String[] temp = new String[keyin.length()];
            for (int j = 0; j < keyin.length(); j++) {
                if (i + j >= plain.length()) {
                    temp[j] = "X";
                } else {
                    temp[j] = text[i + j];	
                }
            }
            list.add(temp);
        }
        Integer[] key = genKey(keyin);

        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String[] listtemp = list.get(i);
            for (int j = 0; j < keyin.length(); j++) {
                res.add(listtemp[key[j]]);
            }
        }
        return String.join("", res);
}

    protected String decrypt(String plain, String keyin){
        ArrayList<String[]> list = new ArrayList<>();
        String[] text = plain.split("");
        for (int i = 0; i < plain.length(); i = i + keyin.length()) {
            String[] temp = new String[keyin.length()];
            for (int j = 0; j < keyin.length(); j++) {
                if (i + j >= plain.length()) {
                    temp[j] = "X";
                } else {
                    temp[j] = text[i + j];	
                }
            }
            list.add(temp);
        }
        Integer[] key = genKey(keyin);
        ArrayList<Integer> nKey = new ArrayList<>(Arrays.asList(key));
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String[] listtemp = list.get(i);
            for (int j = 0; j < keyin.length(); j++) {
                if(!listtemp[nKey.indexOf(j)].equals("X")){
                    res.add(listtemp[nKey.indexOf(j)]);
                }
            }
        }
        return String.join("", res);
    }


    private Integer[] genKey(String keyin) {
        Integer[] temp = new Integer[keyin.length()];
        for (int i = 0; i < keyin.length(); i++) {
                temp[i] = (int) keyin.charAt(i);
        }	
        Integer[] reskey = new Integer[keyin.length()];
        for (int i = 0; i < temp.length; i++) {
            int max = Collections.max(Arrays.asList(temp));
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == max){
                reskey[j] = temp.length - 1 - i;	
                temp[j] = 0;
                break;
                }
            }
        }
        return reskey;
    }
}
