/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.List;

/**
 *
 * @author Axel
 */
public class UploadFile extends ActionSupport{

    private List<File> files;
    private List<String> filesContentType;
    private List<String> filesFileName;     
    
    @Override
    public String execute() throws Exception{
        System.out.print("\n\n---------------------------------------\n");
        int i=0;
        System.out.print("Archivos subidos " + files.size());
        for (File file : files){
            System.out.print("\nFile ["+i+"] ");
            System.out.print("; name:"         + filesFileName.get(i));
            System.out.print("; contentType: " + filesContentType.get(i));
            System.out.print("; length: "      + file.length());
            i++;
        }
        System.out.println("\n---------------------------------------\n");
        return SUCCESS;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public List<String> getFilesContentType() {
        return filesContentType;
    }

    public void setFilesContentType(List<String> filesContentType) {
        this.filesContentType = filesContentType;
    }

    public List<String> getFilesFileName() {
        return filesFileName;
    }

    public void setFilesFileName(List<String> filesFileName) {
        this.filesFileName = filesFileName;
    }
    
    

}
