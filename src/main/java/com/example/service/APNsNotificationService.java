package com.example.service;

import com.google.common.io.Resources;
import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import com.notnoop.apns.ApnsServiceBuilder;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.Date;

public class APNsNotificationService {
    protected static Logger logger = Logger.getLogger(APNsNotificationService.class);

    public static void main(String[] args) {
        String p12Path = null;
        String password = null;

        logger.debug("Sending an iOS push notification...");

        String token = "";
        String type = "dev";
        String message = "the test push notification message " + new Date().getTime();

        try {
            token = args[0];
        } catch (Exception e) {
            logger.debug("Usage: PushNotifications devicetoken");
            logger.debug("example: PushNotifications 1testdevicetoken3eb414627e78991ac5a615b4a2a95454c6ba5d18930ac137 'hi there!' prod");
            return;
        }
        try {
            message = args[1];
        } catch (Exception e) {
            logger.debug("no message defined, using '" + message + "'");
        }
        try {
            type = args[2];
        } catch (Exception e) {
            logger.debug("no API type defined, using " + type);
        }
        try {
            password = args[3];
        } catch (Exception e) {
            logger.debug("no API type defined, using " + type);
        }
        try {
            p12Path = args[4];
        } catch (Exception e) {
            logger.debug("no API type defined, using " + type);
        }

        logger.debug("The target token is " + token);

        ApnsServiceBuilder serviceBuilder = APNS.newService();

        logger.debug("using prod API");
        URL url = Resources.getResource(p12Path);

        String certPath = url.getPath();
        serviceBuilder.withCert(certPath, password)
                .withSandboxDestination();

        ApnsService service = serviceBuilder.build();

        //Payload with custom fields
        String payload = APNS.newPayload()
                .alertBody(message)
                .alertTitle("test alert title")
                .sound("default")
                .customField("custom", "custom value").build();

        logger.debug("payload: " + payload);
        service.push(token, payload);

        logger.debug("The message has been hopefully sent...");
    }
}
