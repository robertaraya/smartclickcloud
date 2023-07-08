package smartclick.cloud.system.propertyhuntercr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import smartclick.cloud.system.base.AbstractBaseService;
import smartclick.cloud.system.propertyhuntercr.entity.Property;
import smartclick.cloud.system.propertyhuntercr.repository.PropertyRepository;
import smartclick.cloud.system.util.document.FileService;
import smartclick.cloud.system.util.photo.PhotoService;

@Service
public class PropertyAdminService extends AbstractBaseService<Property, String, PropertyRepository>{
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	FileService fileService;
	
	public PropertyAdminService(PropertyRepository repository) {
		super(repository);
	}
	
	public List<Property> findByTitle(String name) {
		return repository.findByTitle(name);
	}
	
	public Property create(Property entity) throws DuplicateKeyException, IllegalArgumentException {
		Integer lastConsecutive = 0;
		
		if (repository.count() > 0) {
			lastConsecutive = repository.findFirstByOrderByConsecutiveDesc().getConsecutive();
		}
		
		entity.setPropertyId(entity.getPropertyId() + entity.getAddress().getProvinceCode() + "-" + (lastConsecutive.intValue() + 1));
		entity.setConsecutive(lastConsecutive.intValue() + 1);
		
		entity.getImagesToAdd().forEach((image) -> {
			String imageId = photoService.addPhoto(entity.getPropertyId(), image);
			if (imageId != null) {
				entity.getImages().add(imageId);
			}
		});
		
		entity.getImagesToRemove().forEach((imageId) -> {
			photoService.delete(imageId);
		});
		
		entity.setImagesToAdd(null);
		entity.setImagesToRemove(null);
		
		entity.getDocumentsToAdd().forEach((document) -> {
			String documentId = fileService.addFile(entity.getPropertyId(), document);
			if (documentId != null) {
				entity.getDocuments().add(documentId);
			}
		});
		
		entity.getDocumentsToRemove().forEach((documentId) -> {
			fileService.delete(documentId);
		});
		
		entity.setImagesToAdd(null);
		entity.setImagesToRemove(null);
		
		return super.create(entity);
	}
	
	public Property update(String id, Property entity) throws DuplicateKeyException, IllegalArgumentException {

		entity.getImagesToAdd().forEach((image) -> {
			String imageId = photoService.addPhoto(entity.getPropertyId(), image);
			if (imageId != null) {
				entity.getImages().add(imageId);
			}
		});
		
		entity.getImagesToRemove().forEach((imageId) -> {
			photoService.delete(imageId);
		});
		
		entity.getDocumentsToAdd().forEach((document) -> {
			String documentId = fileService.addFile(entity.getPropertyId(), document);
			if (documentId != null) {
				entity.getDocuments().add(documentId);
			}
		});
		
		entity.getDocumentsToRemove().forEach((documentId) -> {
			fileService.delete(documentId);
		});
		
		entity.setImagesToAdd(null);
		
		return super.update(id, entity);
	}

	@Override
	public boolean hasInvalidFields(Property entity) {
		return entity.getTitle().isBlank() || entity.getAddress().getProvinceCode().isBlank() || entity.getContact().getName().isBlank() || entity.getPropertyType().isBlank() ;
	}
}
