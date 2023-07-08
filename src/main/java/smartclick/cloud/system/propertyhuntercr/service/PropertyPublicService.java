package smartclick.cloud.system.propertyhuntercr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.json.JsonObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import smartclick.cloud.system.base.AbstractBaseService;
import smartclick.cloud.system.propertyhuntercr.entity.Property;
import smartclick.cloud.system.propertyhuntercr.entity.PublicProperty;
import smartclick.cloud.system.propertyhuntercr.repository.PropertyRepository;

@Service
public class PropertyPublicService extends AbstractBaseService<Property, String, PropertyRepository>{
//	@Autowired
//	private PhotoService photoService;
//	
//	@Autowired
//	FileService fileService;
	
	public Page<PublicProperty> getAllCustom(Pageable pageable) throws IllegalArgumentException {
		try {			
//			Query query = new Query();
//			query.addCriteria(Criteria.where("title").regex(title));
			
			return repository.findAllPublic(pageable);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}
	
	//Model model,
	
	public Page<PublicProperty> search(String searchType, String propertyType, String provinceCode, Pageable pageable) throws IllegalArgumentException {
		try {
			
			Map<String, Object> filterRequestMap = new HashMap<String, Object>();
			if (propertyType != null && !propertyType.isBlank()) {
				filterRequestMap.put("propertyType", propertyType);				
			}
			if (provinceCode != null && !provinceCode.isBlank()) {
				filterRequestMap.put("address.provinceCode", provinceCode);				
			}
			
			Map<String, Object>	filterMap = new HashMap<String, Object>();
			
			filterRequestMap.forEach((key, value) -> {
				Map<String, Object> attributes = new HashMap<String, Object>();
				attributes.put("pattern", value);
				attributes.put("options", "i");
				
				Map<String, Object> regularExp = new HashMap<String, Object>();
				regularExp.put("$regularExpression", attributes);

				filterMap.put(key, regularExp);			
			});
			
			
			if (searchType != null && !searchType.isBlank()) {
				filterMap.put(searchType, true);
			}
			
			Document jsonDocument = new Document(filterMap);
			String jsonString = jsonDocument.toJson();
			
			JsonObject jsonQuery = new JsonObject(jsonString);
			
			// 'title' : {$regex : ?0, $options: 'i'}, 'propertyType' : {$regex : ?1, $options: 'i'}, 'address.provinceCode' : {$regex : ?2, $options: 'i'} 
			if (jsonString.equalsIgnoreCase("{}")) {
				return repository.findAllPublic(pageable);
			}
			
			return repository.search(jsonQuery.toBsonDocument(), pageable);
		} catch (Exception e) {
			System.out.println(e);
			throw new IllegalArgumentException();
		}
	}
	
	public PublicProperty searchById(String id) {
		return repository.searchById(id);
	}
	
	public PropertyPublicService(PropertyRepository repository) {
		super(repository);
	}
	
	public List<Property> findByTitle(String name) {
		return repository.findByTitle(name);
	}

	@Override
	public boolean hasInvalidFields(Property entity) {
		return entity.getTitle().isBlank() || entity.getAddress().getProvinceCode().isBlank() || entity.getContact().getName().isBlank() || entity.getPropertyType().isBlank() ;
	}
}
