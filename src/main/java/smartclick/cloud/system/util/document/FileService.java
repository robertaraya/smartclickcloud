package smartclick.cloud.system.util.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

	@Autowired
    private FileRepository fileRepository;
    
    public String addFile(String title, String base64File){
    	try {
	        File file = new File();
	        file.setTitle(title);
	        file.setBase64Image(base64File); 
	        file = fileRepository.insert(file);
	        return file.getId(); 
		} catch (Exception e) {
			return null;
		}
    }
    
    public File getFile(String id) { 
    	String _id = id.toString().replaceAll("\"","");
        return fileRepository.findById(_id).get(); 
    }
    
    public boolean delete(String id) throws IllegalArgumentException  {
		try {
			if (id == null || id.toString().isBlank()) {
				throw new IllegalArgumentException();
			}
			
			String _id = id.toString().replaceAll("\"","");
			fileRepository.deleteById((String) _id);
			
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
}
