package smartclick.cloud.system.store.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import smartclick.cloud.security.config.local.service.UserService;
import smartclick.cloud.system.base.AbstractBaseController;
import smartclick.cloud.system.entity.Address;
import smartclick.cloud.system.entity.Phone;
import smartclick.cloud.system.entity.SocialMedia;
import smartclick.cloud.system.store.entity.smartstore.SmartStore;
import smartclick.cloud.system.store.service.CategoryService;
import smartclick.cloud.system.store.service.SmartStoreService;
import smartclick.cloud.system.store.service.StoreProductService;

@RestController
@RequestMapping("/store")
public class SmartStoreController extends AbstractBaseController<SmartStore, String, SmartStoreService>{

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	StoreProductService productService;
	
	@Autowired
	UserService userService;
	
	public SmartStoreController(SmartStoreService service) {
		super(service);
	}
	
	@GetMapping("/add")
	public ResponseEntity<SmartStore> add(Pageable pageable) {
		SmartStore store = new SmartStore();
		store.setName("SmartClick");
		store.setDescription("Tecnologia");
		
		List<String> emailList = new ArrayList<>();
		emailList.add("smartclickweb@gmail.com");
		store.setEmailList(emailList);
		
		store.setHasExpressService(false);
		
		store.setCategoryList(categoryService.findByName("Tecnologia"));
		
		List<Phone> phoneList = new ArrayList<>();
		Phone phone = new Phone();
		phone.setPhoneType("mobile");
		phone.setPhoneNumber("88957623");
		phoneList.add(phone);
		
		Phone phone1 = new Phone();
		phone1.setPhoneType("whatsapp");
		phone1.setPhoneNumber("89269159");
		phoneList.add(phone1);
		
		Phone phone2 = new Phone();
		phone2.setPhoneType("telegram");
		phone2.setPhoneNumber("88957623");
		phoneList.add(phone2);
		
		Phone phone3 = new Phone();
		phone3.setPhoneType("fax");
		phone3.setPhoneNumber("88957623");
		phoneList.add(phone3);
		
		Phone phone4 = new Phone();
		phone4.setPhoneType("main");
		phone4.setPhoneNumber("89269159");
		phoneList.add(phone4);
		
		store.setIsActive(true);
		store.setPhoneList(phoneList);
		
		//store.setProductList(productService.getAll(pageable).getContent());
		List<String> scheduleList = new ArrayList<>();
		scheduleList.add("Lunes a Viernes de 7am a 4pm");
		store.setScheduleList(scheduleList);
		
		List<SocialMedia> socialMediaList = new ArrayList<SocialMedia>();
		SocialMedia socialMedia = new SocialMedia();
		socialMedia.setSocialMediaType("Facebook");
		socialMedia.setSocialMediaLink("https://www.facebook.com/robertaraya85/");
		socialMediaList.add(socialMedia);
		store.setSocialMediaList(socialMediaList);
		
		store.setUser(userService.findById("60b1199fd3dae451c4202b10"));
		//60b1199fd3dae451c4202b10
		List<Address> addressList = new ArrayList<Address>();
		Address address = new Address();
		address.setIsVirtual(false);
		address.setCantonCode("1");
		address.setCountryCode("CRI");
		address.setDistrictCode("1");
		address.setProvinceCode("1");
		address.setLine1("75 sur BCR entrada a mano derecha");
		address.setCoordinates("10.011384681321724, -84.09877197293244");
		addressList.add(address);
		store.setAddressList(addressList);
		
		service.create(store);
		
		return new ResponseEntity<>(store, HttpStatus.OK);
	}
	
}
