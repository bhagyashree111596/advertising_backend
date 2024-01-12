package com.java.adProvider.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
//  public static ResponseEntity<?> responseBuilder(String message,HttpStatusCode httpstatuscode)
//  {
//	  Map<String ,Object> response=new HashMap<>();
//	  response.put("message",message);
//	  response.put("status", httpstatuscode);
//	return new ResponseEntity<>(response,httpstatuscode);
//
//  }
//  public static ResponseEntity<Object> responseBuilder(String message,HttpStatusCode httpstatuscode,Object entity)
//  {
//	  Map<String ,Object> response=new HashMap<>();
//	  response.put("message",message);
//	  response.put("status", httpstatuscode);
//	  response.put("data", entity);
//	return new ResponseEntity<>(response,httpstatuscode);
//
//  }
  public static ResponseEntity<Object> responseBuilder(String message,HttpStatus httpstatus,Object responseObject)
  {
	  Map<String ,Object> response=new HashMap<>();
	  response.put("message",message);
	  response.put("status", httpstatus  );
	  response.put("data", responseObject);

	return new ResponseEntity<>(response,httpstatus);

  }
  public static ResponseEntity<?> responseBuilder(String message,HttpStatus httpstatus,List<Object> responseObject)
  {
	  Map<String ,Object> response=new HashMap<>();
	  response.put("message",message);
	  response.put("status", httpstatus  );
	  response.put("data", responseObject);

	return new ResponseEntity<>(response,httpstatus);

  }
public static ResponseEntity<?> responseBuilder(String message, int value, Object userPojo,HttpStatus httpStatus) {
     Map<String,Object> response=new HashMap<>();
     response.put("message", message);
     response.put("status", value);
     response.put("data", userPojo);
     response.put("HttpStatus", httpStatus);
	return new ResponseEntity<>(response,httpStatus);
}

//public static  ResponseEntity<User> responseBuilder(String msg, int values,HttpStatus HttpStatus) {
//	// TODO Auto-generated method stub
//	Map<String,Object> response=new HashMap<>();
//	response.put("message", msg);
//	response.put("status", values);
//	response.put("HttpStaus",HttpStatus);
//	return new ResponseEntity<>(response,HttpStatus);
//}
}
