# cloud-ribbon-client
Spring Cloud Netflix Ribbon - Client side load balancer : Spring cloud ribbon is an easy to use implementation for client side load balancing. Client side load balancing allows the client to select a server based on some criteria.

This client instead of getting the URLs of client1 and client2 from eureka server, will use Rest Template as load balancer.

-----------------------------------------
**Part 1, Run Eureka and word servers**	
1. You already created cloud-eureka-server, cloud-eureka-client1(for first word), cloud-eureka-client2(for second word). Start all these services.

2. Create cloud-ribbon-client on the top of cloud-eureka-client3 to get the senetence.

 **Part 2, Modify sentence server to use Ribbon**	

3.  Create a copy of cloud-eureka-client3 with the name cloud-ribbon-client, Run the cloud-ribbon-client.  Refresh Eureka to see it appear in the list.  Test to make sure it works by opening [http://localhost:8020/sentence](http://localhost:8020/sentence).  You should see several random sentences appear.  We will refactor this code to make use of Ribbon.

4.  Stop the cloud-ribbon-client.  Add the org.springframework.cloud / spring-cloud-starter-netflix-ribbon dependency.

5.  Go to Application.java.  Create a new @Bean method that instantiates and returns a new RestTemplate.  The @Bean method should also be annotated with @LoadBalanced - this will associate the RestTemplate with Ribbon.  Code should look something like this:

  ```
    //  This "LoadBalanced" RestTemplate 
    //  is automatically hooked into Ribbon:
    @Bean @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }  
  ```

6.  Open SentenceController.java.  Replace the @Autowired DiscoveryClient with an @Autowired RestTemplate.  Note that this will temporarily break the code.

7.  Refactor the code in the getWord method.  Use your restTemplate's getForObject method to call the given service.  The first argument should be a concatenation of "http://" and the given service ID.  The second argument should simply be a String.class; we want the restTemplate to yield a String containing whatever was returned to the server.  The call should look like this:

  ```
    return template.getForObject("http://" + service, String.class);
  ```

8.  Run the project.  Test it to make sure it works by opening [http://localhost:8020/sentence](http://localhost:8020/sentence).  The application should work the same as it did before, though now it is using Ribbon client side load balancing.

