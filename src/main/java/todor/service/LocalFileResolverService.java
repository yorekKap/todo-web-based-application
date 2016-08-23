package todor.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class LocalFileResolverService implements FileResolverService{

	private final String path = "/home/yuri/JEEWorkspace/todor/src/main/resources/photos/";
	private Map<String, byte[]> cache = new HashMap<>();

	@Override
	public void saveFile(String fileName, byte[] data) {
		
		File file = new File(path+fileName);
	
		
		try(FileOutputStream out = new FileOutputStream(file)){
	
		out.write(data);
		out.close();
		
		}catch(IOException e){
			
			e.printStackTrace(System.err);
			
		}
		
		cache.put(fileName, data);
		
	}

	@Override
	public byte[] loadFile(String fileName) {
		
		if(cache.containsKey(fileName)){
			
			return cache.get(fileName);
			
		}
		
		else{
		
			File inputFile = new File(path+fileName);
			
			try(FileInputStream in = new FileInputStream(inputFile)){
				
			}catch(IOException e){
				
				e.printStackTrace(System.err);
			
			};
			
			byte data[] = new byte[(int)inputFile.length()];
			cache.put(fileName, data);
			return data;
		}

	}
	
	@Override
	public void deleteFile(String fileName) {
	
		cache.remove(fileName);
		
	}
}
