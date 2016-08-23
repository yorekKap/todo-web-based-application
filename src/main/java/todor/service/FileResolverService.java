package todor.service;

public interface FileResolverService {

	byte[] loadFile(String fileName);
	void saveFile(String fileName, byte[] data);
	void deleteFile(String fileName);
	
}
