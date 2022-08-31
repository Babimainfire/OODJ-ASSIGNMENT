package com.apucafeteria.backend.utils;

import java.io.*;

public class FileUtils {
    
    public BufferedReader read(String filename) throws FileNotFoundException{
        File file = new File(filename);
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);
        return reader;
    }

    public void write(String filename, String text) throws IOException{
        try{
            File file = new File(filename);
            //if flag is true - written in the end, if flag is false - written in beginning;
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            if(GetLineCount(filename) != 0){ writer.append("\r\n"); }
            writer.append(text);
            writer.close();
        } catch (IOException ex) { System.out.println(ex.getMessage()); }
        finally{
            
        }
    }
    
    public int GetLineCount(String filename) throws IOException {
        String data;
        int lineCount = 0;
        File file = new File(filename);
        try{
            var fileStream = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fileStream);
            var reader = new BufferedReader(input);
            while((data = reader.readLine()) != null) { lineCount++; }
            reader.close();
            input.close(); 
            fileStream.close();
            return lineCount;
        } catch (IOException ex) { System.out.println(ex.getMessage()); } 
        finally{
//            if (reader == null){
//                reader.close();
//            }
        }
        return 0;
    }

    public boolean CheckFileExist(String filename){
        File file = new File(filename);
        return file.exists();
    }
}
