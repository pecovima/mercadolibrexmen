package com.mercadolibre;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.internal.LambdaContainerHandler;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.serverless.proxy.spring.SpringBootProxyHandlerBuilder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Instant;

public class MagnetoServiceHandler implements RequestStreamHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(MagnetoServiceHandler.class);

    private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
    static {
        try {
            //handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(AppUnifiedXmenMagneto.class);

            long startTime = Instant.now().toEpochMilli();

            LambdaContainerHandler.getContainerConfig().setInitializationTimeout(60_000);
             handler = new SpringBootProxyHandlerBuilder()
                                .defaultProxy()
                                .asyncInit(startTime)
                                .springBootApplication(AppUnifiedXmenMagneto.class)
                                .buildAndInitialize();

        } catch (ContainerInitializationException e) {
            throw new RuntimeException("Could not initialize Spring Boot application", e);
        }
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context)
            throws IOException {
         logger.info("EJECUTA HANDLER");
    	try {
    		handler.getContainerConfig().setDefaultContentCharset("UTF-8");
    		handler.proxyStream(inputStream, outputStream, context);
    		 logger.info("OUTPUTSTREAM::: "+outputStream);
		} catch (Exception e) {
			logger.info("ERRROR HANDLER");
			logger.info(e.getMessage());
		}

    }



}