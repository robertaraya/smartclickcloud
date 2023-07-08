package smartclick.cloud.system.util.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "files")
public class File {
    @Id
    private String id;
    
    private String title;
    
    private String base64File;

	public File() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBase64Image() {
		return base64File;
	}

	public void setBase64Image(String base64File) {
		this.base64File = base64File;
	}	
}