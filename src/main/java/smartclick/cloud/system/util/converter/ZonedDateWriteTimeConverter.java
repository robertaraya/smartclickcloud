package smartclick.cloud.system.util.converter;

import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class ZonedDateWriteTimeConverter implements Converter<ZonedDateTime, Date>{

	@Override
	public Date convert(ZonedDateTime source) {
		return Date.from(source.toInstant());
	}

	
}
