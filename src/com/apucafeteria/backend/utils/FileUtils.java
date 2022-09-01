package com.apucafeteria.backend.utils;

import java.io.*;

public class FileUtils {
    
    FileInputStream fileStream;
    InputStreamReader input;
    BufferedReader reader;
            
    public BufferedReader read(String filename) throws FileNotFoundException{
        File file = new File(filename);
        fileStream = new FileInputStream(file);
        input = new InputStreamReader(fileStream);
        reader = new BufferedReader(input);
        return reader;
    }
    
    public void close() throws IOException{
        if(fileStream == null){
            fileStream.close();
        }
        if(input == null){
            input.close();
        }
        if(input == null){
            reader.close();
        }
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
            FileInputStream fileStream = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fileStream);
            BufferedReader reader = new BufferedReader(input);
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
