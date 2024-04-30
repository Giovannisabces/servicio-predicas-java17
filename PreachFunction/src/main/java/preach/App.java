package preach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
// import com.amazonaws.serverless.proxy.model.Headers;
/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<Request, Object> {

    @Override
    public Object handleRequest(Request request, Context context) {
        AmazonDynamoDB db = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDBMapper mapper = new DynamoDBMapper(db);
        AwsProxyResponse response = new AwsProxyResponse();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Access-Control-Allow-Headers","Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token");
        headers.put("Access-Control-Allow-Methods","*");
        headers.put("Access-Control-Allow-Origin","*");
        response.setHeaders(headers);
        response.setStatusCode(200);

        switch(request.getHttpMethod().toUpperCase()) {
            case "GET": 
                List<Preach> preaches = new ArrayList<>();
                preaches = mapper.scan(Preach.class, new DynamoDBScanExpression());
                response.setBody(getList(preaches));
                return response;
        }
        return null;
    }
    public String getList(List<Preach> preaches){
        String body = "";
        for (int i = 0; i < preaches.size(); i++){
            body += preaches.get(i).toString();
        }
        return body;
    }
}
//mvn clean (esto es para limpiar y eliminar toda compilacion previa)
//mvn package -DskipTests=true (Esto es para generar ejecutable .jar)