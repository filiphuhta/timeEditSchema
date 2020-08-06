package com.mycompany.schemaprojekt_3.resources;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.SSLContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.apache.connector.ApacheConnectorProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.glassfish.jersey.media.multipart.internal.LocalizationMessages;

/**
 *
 * @author
 */
@Path("javaee8")
public class JavaEE8Resource {

    @GET
    public Response ping() {
        return Response
                .ok("ping")
                .build();
        
        
    }

    @POST
    @Path("canvas")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void canvas(String schema) throws MalformedURLException, ProtocolException, IOException  {
 System.out.print("hej");

 Gson g = new Gson();
        
        Type userListType = new TypeToken<ArrayList<TimeEdit2>>(){}.getType();
        ArrayList<TimeEdit2> userArray = g.fromJson(schema, userListType);
 
 System.out.print(userArray);
        String canvas_url = "https://ltu.instructure.com/api/v1/calendar_events.json";
        String bearerToken = "3755~jJi7sxsTMbdwZvFJWNxC7HgiLM9Sb6aAPVTAcRe0XlBMQtT08ywMhcCcBbPELmpD";

        URL url = new URL(canvas_url);
       

        for (TimeEdit2 timeEdit1 : userArray) {
            System.out.println(timeEdit1.getDatum());
          String title=timeEdit1.getTyp();
            String startAtDate=timeEdit1.getDatum();
           String startAtTime= timeEdit1.getStarttid();
           System.out.println(timeEdit1.getStarttid());
           
           String endAtDate =timeEdit1.getDatum();
           String endAtTime = timeEdit1.getSluttid();
           String description=timeEdit1.getBeskrivning();
     
        Form form = new Form();
       
         form.param("calendar_event[context_code]", "user_55150" );
    form.param("calendar_event[title]", title);
    form.param("calendar_event[start_at]", startAtDate+"T"+startAtTime+":00Z");
    form.param("calendar_event[end_at]", endAtDate+"T"+endAtTime+":00Z");
    form.param("calendar_event[description]",description);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
  final ClientConfig config = new ClientConfig();
    final ApacheConnectorProvider connectorProvider = new ApacheConnectorProvider();
    config.connectorProvider(connectorProvider);
       
        Client client = ClientBuilder.newClient(config).register(OAuth2ClientSupport.feature(bearerToken));
     
  
        
            String a = "hej";
        
        WebTarget target = client.target(canvas_url);
        Invocation.Builder invocationB = target.request(MediaType.APPLICATION_JSON_TYPE);
        Entity ent = Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE);
        Response r = invocationB.post(ent);
        if (r != null && r.getStatus() == 201) {
            System.out.println("ok jaja");
           
        } else if (r != null) {
            System.out.println("naj det gick inte");
            System.out.println(r.getStatus());
        } else {
            System.out.println("Response is null");
        }
  
   }
 

       
    }
    
    @POST
    @Path("postcanvas")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void post_canvas() throws MalformedURLException, ProtocolException, IOException  {

        test();
    }
    
    
   public void test() throws MalformedURLException, ProtocolException, IOException{
        System.out.print("hej");

        String canvas_url = "https://ltu.instructure.com/api/v1/calendar_events.json";
        String bearerToken = "3755~jJi7sxsTMbdwZvFJWNxC7HgiLM9Sb6aAPVTAcRe0XlBMQtT08ywMhcCcBbPELmpD";

        URL url = new URL(canvas_url);

        Form form = new Form();
         form.param("calendar_event[context_code]", "user_55150" );
    form.param("calendar_event[title]", "Filip skickar från get metoden");
    form.param("calendar_event[start_at]", "2020-01-11T17:00:00Z");
    form.param("calendar_event[end_at]", "2020-01-11T20:00:00Z");
    form.param("calendar_event[description]","hej jag vill testa description");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
  final ClientConfig config = new ClientConfig();
    final ApacheConnectorProvider connectorProvider = new ApacheConnectorProvider();
    config.connectorProvider(connectorProvider);
       
        Client client = ClientBuilder.newClient(config).register(OAuth2ClientSupport.feature(bearerToken));
     
  
        
        
        
        WebTarget target = client.target(canvas_url);
        Invocation.Builder invocationB = target.request(MediaType.APPLICATION_JSON_TYPE);
        Entity ent = Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE);
        Response r = invocationB.post(ent);
        if (r != null && r.getStatus() == 201) {
            System.out.println("ok jaja");
        } else if (r != null) {
            System.out.println("naj det gick inte");
            System.out.println(r.getStatus());
        } else {
            System.out.println("Response is null");
        }

       
   }
              
}
