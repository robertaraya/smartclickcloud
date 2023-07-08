package smartclick.cloud.system.propertyhuntercr.repository;

import java.util.List;

import org.bson.BsonDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import smartclick.cloud.system.propertyhuntercr.entity.Property;
import smartclick.cloud.system.propertyhuntercr.entity.PublicProperty;

@Repository
public interface PropertyRepository extends MongoRepository<Property, String>{
	List<Property> findByTitle(String name);
	List<Property> findByTitleAndIdNotContaining(String name, String id);
	
	Property findFirstByOrderByConsecutiveDesc();
	
	@Query(value="{}")
//	, fields="{ _id:1, title:1, propertyId:1, description:1, forSale:1, "
//			+ "saleInformation: {salePrice: 1, totalPrice: 1 }, "
//			+ "forRent:1, "
//			+ "rentInformation:{ guests:1, dailyPrice:1, weeklyPrice:1, monthlyPrice:1, dailyLowSeasonPrice:1, weeklyLowSeasonPrice:1, monthlyLowSeasonPrice:1, dailyHighSeasonPrice:1, weeklyHighSeasonPrice:1, monthlyHighSeasonPrice:1, longTermPrice:1, onlyShortTerm:1 }, "
//			+ "propertyType:1, buildingList:1, lotInformation:1, amenityList:1, parkingSpaces:1, maintenanceFee:1, address:1, mainImage:1, images:1, active:1 }")
	Page<PublicProperty> findAllPublic(Pageable pageable);
	
	@Query(value="?0")
//			, fields="{ _id:1, title:1, propertyId:1, description:1, forSale:1, "
//			+ "saleInformation: {salePrice: 1, totalPrice: 1 }, "
//			+ "forRent:1, "
//			+ "rentInformation:{ guests:1, dailyPrice:1, weeklyPrice:1, monthlyPrice:1, dailyLowSeasonPrice:1, weeklyLowSeasonPrice:1, monthlyLowSeasonPrice:1, dailyHighSeasonPrice:1, weeklyHighSeasonPrice:1, monthlyHighSeasonPrice:1, longTermPrice:1, onlyShortTerm:1 }, "
//			+ "propertyType:1, buildingList:1, lotInformation:1, amenityList:1, parkingSpaces:1, maintenanceFee:1, address:1, mainImage:1, images:1, active:1 }")
	Page<PublicProperty> search(BsonDocument bsonDocument, Pageable pageable);
	
	@Query("{'id' : ?0}")
	PublicProperty searchById(String id);
}
