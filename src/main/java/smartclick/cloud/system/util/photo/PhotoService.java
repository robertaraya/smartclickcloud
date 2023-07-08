package smartclick.cloud.system.util.photo;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PhotoService {

	@Autowired
    private PhotoRepository photoRepository;
 
    public String addPhoto(String title, MultipartFile file) throws IOException { 
        Photo photo = new Photo(); 
        photo.setTitle(title);
        photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
        photo = photoRepository.insert(photo); 
        return photo.getId(); 
    }
    
    public String addPhoto(String title, String base64File){
    	try {
//			byte[] decodedBytes = Base64.decodeBase64(base64File);
	        Photo photo = new Photo();
	        photo.setTitle(title);
	        photo.setBase64Image(base64File);
//	        photo.setImage(new Binary(BsonBinarySubType.BINARY, decodedBytes)); 
	        photo = photoRepository.insert(photo);
	        return photo.getId(); 
		} catch (Exception e) {
			return null;
		}
    }
    
    public Photo getPhoto(String id) { 
        return photoRepository.findById(id).get(); 
    }
    
    public boolean deletePhoto(String id) {
    	photoRepository.deleteById(id);
    	return true;
    }
    
    public boolean delete(String id) throws IllegalArgumentException  {
		try {
			if (id == null || id.toString().isBlank()) {
				throw new IllegalArgumentException();
			}
			
			String _id = id.toString().replaceAll("\"","");
			
			photoRepository.deleteById((String) _id);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
}
