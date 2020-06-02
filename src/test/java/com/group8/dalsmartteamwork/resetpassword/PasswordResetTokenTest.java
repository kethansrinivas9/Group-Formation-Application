package com.group8.dalsmartteamwork.resetpassword;

import com.group8.dalsmartteamwork.resetpassword.models.PasswordResetToken;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordResetTokenTest{

    private static final String TEMP_BANNERID = "B00000000";
    private static final String TEMP_TOKEN = "a0a1a2a3a4a5a6a7a8a9";
    private static  final Date TEMP_TIMESTAMP = new Date();

    @Test
    public void defaultConstructorTest(){
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        assertEquals(passwordResetToken.getTokenID(), 0, "tid Default constructor of PasswordResetToken failed.");
        assertNull(passwordResetToken.getBannerID(), "bid Default constructor of PasswordResetToken failed.");
        assertNull(passwordResetToken.getToken(), "tok Default constructor of PasswordResetToken failed.");
        assertNull(passwordResetToken.getTimestamp(), "timest Default constructor of PasswordResetToken failed.");
        assertNull(passwordResetToken.getStatus(), "statDefault constructor of PasswordResetToken failed.");
    }

    @Test
    public void constructorWithThreeArgumentsTest(){
        PasswordResetToken passwordResetToken = new PasswordResetToken(1, TEMP_BANNERID, TEMP_TOKEN, TEMP_TIMESTAMP, "valid");
        assertEquals(passwordResetToken.getTokenID(), 1, "TokenID not set.");
        assertEquals(passwordResetToken.getBannerID(), TEMP_BANNERID, "BannerID not set.");
        assertEquals(passwordResetToken.getToken(), TEMP_TOKEN, "Token not set.");
        assertEquals(passwordResetToken.getTimestamp(), TEMP_TIMESTAMP, "Timestamp not set.");
        assertEquals(passwordResetToken.getStatus(), "valid", "Status not set.");
    }

    @Test
    public void getTokenIDTest(){
        PasswordResetToken passwordResetToken = new PasswordResetToken(1, TEMP_BANNERID, TEMP_TOKEN, TEMP_TIMESTAMP, "valid");
        assertEquals(passwordResetToken.getTokenID(), 1, "Unable to retrieve TokenID.");
    }

    @Test
    public void setTokenIDTest(){
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setTokenID(1);
        assertEquals(passwordResetToken.getTokenID(), 1, "TokenID was not added to the PasswordResetToken object.");
    }

    @Test void getBannerIDTest(){
        PasswordResetToken passwordResetToken = new PasswordResetToken(1, TEMP_BANNERID, TEMP_TOKEN, TEMP_TIMESTAMP, "valid");
        assertEquals(passwordResetToken.getBannerID(), TEMP_BANNERID, "Unable to retrieve BannerID.");
    }

    @Test
    public void setBannerIDTest(){
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setBannerID(TEMP_BANNERID);
        assertEquals(passwordResetToken.getBannerID(), TEMP_BANNERID, "BannerID was not added to the PasswordResetToken object.");
    }

    @Test void getTokenTest(){
        PasswordResetToken passwordResetToken = new PasswordResetToken(1, TEMP_BANNERID, TEMP_TOKEN, TEMP_TIMESTAMP, "valid");
        assertEquals(passwordResetToken.getToken(), TEMP_TOKEN, "Unable to retrieve Token.");
    }

    @Test
    public void setTokenTest(){
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setToken(TEMP_TOKEN);
        assertEquals(passwordResetToken.getToken(), TEMP_TOKEN, "Token was not added to the PasswordResetToken object.");
    }

    @Test void getTimestampTest(){
        PasswordResetToken passwordResetToken = new PasswordResetToken(1, TEMP_BANNERID, TEMP_TOKEN, TEMP_TIMESTAMP, "valid");
        assertEquals(passwordResetToken.getTimestamp(), TEMP_TIMESTAMP, "Unable to retrieve Timestamp.");
    }

    @Test
    public void setTimestampTest(){
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setTimestamp(TEMP_TIMESTAMP);
        System.out.println("TIMESTAMP IS: "+ TEMP_TIMESTAMP);
        assertEquals(passwordResetToken.getTimestamp(), TEMP_TIMESTAMP, "Timestamp was not added to the PasswordResetToken object.");
    }

    @Test void getStatusTest(){
        PasswordResetToken passwordResetToken = new PasswordResetToken(1, TEMP_BANNERID, TEMP_TOKEN, TEMP_TIMESTAMP, "valid");
        assertEquals(passwordResetToken.getStatus(), "valid", "Unable to retrieve token status.");
    }

    @Test
    public void setStatusValidTest(){
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setStatusValid();
        assertEquals(passwordResetToken.getStatus(), "valid", "Status was not added/updated to the PasswordResetToken object.");
    }

    @Test
    public void setStatusExpiredTest(){
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setStatusExpired();
        assertEquals(passwordResetToken.getStatus(), "expired", "Status was not added/updated to the PasswordResetToken object.");
    }

    @Test
    public void setStatusNotFoundTest(){
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setStatusNotFound();
        assertEquals(passwordResetToken.getStatus(), "notfound", "Status was not added/updated to the PasswordResetToken object.");
    }

}
