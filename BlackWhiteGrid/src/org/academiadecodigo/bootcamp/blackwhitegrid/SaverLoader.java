package org.academiadecodigo.bootcamp.blackwhitegrid;

import java.io.*;

/**
 * Created by codecadet on 31/05/17.
 */
public class SaverLoader {

    public static String read(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String result = "";
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result = result.concat(line);
            }
            bufferedReader.close();
            fileReader.close();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void write(String s, String filepath) {
        try {
            FileWriter fileWriter=new FileWriter(filepath);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write(s);
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
