package utils;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static utils.ADateUtils.*;

public class ADateUtilsTest {

	@Test
	public void testFormataDataBR() {
		Date date = fromLocalDateTime( LocalDateTime.of( 2014, 3, 20, 10, 10 ) );
		assertEquals( "20/03/2014", formataDataBR( date ) );
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetDateFromString() throws Exception {
		String date = "20/05/2014";
		assertEquals( getDateFromString( date ), fromLocalDateTime( LocalDateTime.of( 2014, 5, 20, 0, 0, 0 ) ) );
		getDateFromString( "A" );
	}

	@Test
	public void testToday() {
		Date today = DateUtils.truncate( today() , Calendar.SECOND) ;
		Date date = DateUtils.truncate( new Date() , Calendar.SECOND) ;

		assertEquals( today, date );
	}

	@Test
	public void testFromLocalDateTime() {
		Date localDate = fromLocalDateTime( LocalDateTime.of( 2014, 5, 20, 0, 0, 0 ) );
		Date data = getDateFromString( "20/05/2014" );
		assertEquals( localDate, data );
	}

	@Test
	public void testFromDate() throws Exception {
		Date data = getDateFromString( "20/05/2014" );
		LocalDateTime localDate = fromDate( data );
		assertEquals( LocalDateTime.of( 2014, 5, 20, 0, 0, 0 ) , localDate );
	}
}