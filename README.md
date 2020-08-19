# api-gateway-sample

This repository integrates following into micro services architechture based on spring boot.
* Swagger for automatic nice doc generation of the rest apis exposed.
* Zuul for implementing a gateway service for single point access to the platform.


## Swagger
It automatically generates a swagger ui html page with all the rest apis in the application. It also provides a rest client to hit request to micro services directly from the swagger ui page.<br/><br/>
![Swagger UI](docs/product-swagger.png)

## Zuul
It is used to proxy requests to other micro services and returns the response. In a micro services architechture, there may be many micor services, but we may not expose all of them to public. There may be some security reasons, there may be some private apis. Using Zuul we cater this issue by exposing only one gateway service to public.<br/>
Gateway Service proxies the request to different micro services based on the request url and relays the response back to consumers. Now we need to secure only one micro service from the public. We can use high security while communication between public and gateway service, whereas we may use less security while communication among gateway and other micro services.<br/>
![Gateway](docs/gateway-design.png)

## How to run
Clone this repository, and run all three micro services (gateway, product and user).
* Open http://localhost:8081 in a browser, it will redirect to user service swagger ui page.
* Open http://localhost:8082 in a browser, it will redirect to product service swagger ui page.
* Open http://localhost:8080 in a browser, it will redirect to gateway service swagger ui page. One important thing to note that, gateway service doesn't have their own apis, so its swagger ui page will list all the micorservices swagger ui page. So from one place we can test all our micro services.<br/><br/>
![Gateway](docs/gateway-swagger.png)

