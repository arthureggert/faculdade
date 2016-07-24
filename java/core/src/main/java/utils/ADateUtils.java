package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ADateUtils {
	
	public static String formataDataBR( Date data ){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format( data );
    }

    public static Date getDateFromString (String data) {
        Date dataRetorno;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "dd/MM/yyyy" );
        try {
            dataRetorno = simpleDateFormat.parse( data );
        } catch ( ParseException e ) {
            throw new IllegalArgumentException( String.format( "Impossivel de converter para Date: %s" , e.getMessage() ) );
        }
        return dataRetorno;
    }

	public static Date today() {
		return Date.from( LocalDateTime.now().atZone( ZoneId.systemDefault() ).toInstant() );
	}

	public static Date fromLocalDateTime(LocalDateTime dateTime) {
		return Date.from( dateTime.atZone( ZoneId.systemDefault() ).toInstant() );
	}

	public static LocalDateTime fromDate(Date date) {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli( date.getTime() ) , ZoneId.systemDefault());
	}

}
